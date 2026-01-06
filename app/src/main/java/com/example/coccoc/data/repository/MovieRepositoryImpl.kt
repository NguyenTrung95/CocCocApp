package com.example.coccoc.data.repository

import com.example.coccoc.data.local.MovieDao
import com.example.coccoc.data.local.entity.NowPlayingEntity
import com.example.coccoc.data.local.entity.TrendingEntity
import com.example.coccoc.data.mappers.toDomain
import com.example.coccoc.data.mappers.toEntity
import com.example.coccoc.data.remote.TmdbApi
import com.example.coccoc.data.util.networkBoundResource
import com.example.coccoc.domain.model.Movie
import com.example.coccoc.domain.repository.MovieRepository
import com.example.coccoc.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TmdbApi,
    private val dao: MovieDao
) : MovieRepository {

    override fun getTrendingMovies(): Flow<Resource<List<Movie>>> {
        return networkBoundResource(
            query = {
                dao.getTrendingMovies().map { entities ->
                    entities.map { it.toDomain() }
                }
            },
            fetch = {
                api.getTrendingMovies()
            },
            saveFetchResult = { response ->
                val movieEntities = response.results.map { it.toEntity() }
                val links = response.results.mapIndexed { index, movieDto ->
                    TrendingEntity(movieId = movieDto.id, rank = index)
                }

                dao.updateTrendingFeed(movieEntities, links)
            }
        )
    }

    override fun getNowPlayingMovies(): Flow<Resource<List<Movie>>> {
        return networkBoundResource(
            query = {
                dao.getNowPlayingMovies().map { entities ->
                    entities.map { it.toDomain() }
                }
            },
            fetch = { api.getNowPlayingMovies() },
            saveFetchResult = { response ->
                val movieEntities = response.results.map { it.toEntity() }
                val links = response.results.mapIndexed { index, movieDto ->
                    NowPlayingEntity(movieId = movieDto.id, rank = index)
                }

                dao.updateNowPlayingFeed(movieEntities, links)
            }
        )
    }

    override suspend fun searchMovies(query: String): Resource<List<Movie>> {
        return try {
            //try online search first
            val response = api.searchMovies(query)
            val entities = response.results.map { it.toEntity() }

            dao.upsertMoviesSafely(entities)

            val movies = entities.map { it.toDomain() }
            Resource.Success(movies)
        } catch (e: Exception) {
            if (e is IOException) {
                //try offline search
                val localMovies = dao.searchMoviesLocally(query)
                if (localMovies.isNotEmpty()) {
                    Resource.Success(localMovies.map { it.toDomain() })
                } else {
                    Resource.Error("No internet and no local results found.")
                }
            } else {
                Resource.Error("Could not search: ${e.message}")
            }
        }
    }

    override suspend fun toggleBookmark(movie: Movie) {
        val updatedMovie = movie.copy()
        dao.updateMovie(updatedMovie.toEntity())
    }

    override fun getBookmarkedMovies(): Flow<List<Movie>> {
        return dao.getBookmarkedMovies().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getMovie(movieId: Int): Flow<Resource<Movie?>> {
        return networkBoundResource(
            query = {
                dao.getMovie(movieId).map { entity ->
                    entity?.toDomain()
                }
            },
            fetch = {
                api.getMovie(movieId)
            },
            saveFetchResult = { movieDto ->
                val movieEntity = movieDto.toEntity()
                dao.upsertMoviesSafely(listOf(movieEntity))
            },
            shouldFetch = { localMovie ->
                localMovie == null
            }
        )
    }
}
package com.example.coccoc.domain.usecases

import com.example.coccoc.domain.model.Movie
import com.example.coccoc.domain.repository.MovieRepository
import com.example.coccoc.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> {
        return repository.getTrendingMovies()
    }
}
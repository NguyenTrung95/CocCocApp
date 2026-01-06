package com.example.coccoc.domain.usecases

import com.example.coccoc.domain.model.Movie
import com.example.coccoc.domain.repository.MovieRepository
import com.example.coccoc.domain.util.Resource
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String): Resource<List<Movie>> {
        if (query.isBlank()) {
            return Resource.Success(emptyList())
        }
        return repository.searchMovies(query)
    }
}
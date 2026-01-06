package com.example.coccoc.domain.usecases

import com.example.coccoc.domain.model.Movie
import com.example.coccoc.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarkedMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> {
        return repository.getBookmarkedMovies()
    }
}
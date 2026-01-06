package com.example.coccoc.domain.usecases

import com.example.coccoc.domain.model.Movie
import com.example.coccoc.domain.repository.MovieRepository
import com.example.coccoc.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId: Int): Flow<Resource<Movie?>> {
        return repository.getMovie(movieId)
    }
}
package com.example.coccoc.domain.usecases

import com.example.coccoc.domain.model.Movie
import com.example.coccoc.domain.repository.MovieRepository
import javax.inject.Inject

class ToggleBookmarkUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) {
        repository.toggleBookmark(movie)
    }
}
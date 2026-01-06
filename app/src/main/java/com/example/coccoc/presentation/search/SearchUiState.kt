package com.example.coccoc.presentation.search

import com.example.coccoc.domain.model.Movie

sealed class SearchUiState {
    object Idle: SearchUiState()
    object Loading: SearchUiState()
    data class Success(val movies: List<Movie>): SearchUiState()
    data class Error(val message: String): SearchUiState()
}

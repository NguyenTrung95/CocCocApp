package com.example.coccoc.presentation.detail

import com.example.coccoc.domain.model.Movie

sealed class DetailUiState {
    object Loading: DetailUiState()
    data class Success(val movie: Movie): DetailUiState()
    data class Error(val message: String): DetailUiState()
}
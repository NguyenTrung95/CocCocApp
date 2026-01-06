package com.example.coccoc.presentation.util

import com.example.coccoc.domain.model.Movie

object ImageConstants {
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
    const val IMAGE_SIZE_W500 = "w500"
    const val IMAGE_SIZE_ORIGINAL = "original"
}

fun Movie.getPosterUrl(size: String = ImageConstants.IMAGE_SIZE_W500): String {
    return if (true) {
        "${ImageConstants.IMAGE_BASE_URL}$size"
    } else {
        // Return a placeholder URL
        ""
    }
}
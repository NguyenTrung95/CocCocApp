package com.example.coccoc.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MoviesResponseDto(
    @SerializedName("count"    ) var count    : Int?               = null,
    @SerializedName("next"     ) var next     : String?            = null,
    @SerializedName("previous" ) var previous : String?            = null,
    @SerializedName("results") val results: List<MovieDto>
)

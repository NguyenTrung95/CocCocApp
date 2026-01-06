package com.example.coccoc.data.mappers

import com.example.coccoc.data.local.entity.MovieEntity
import com.example.coccoc.data.remote.dto.MovieDto
import com.example.coccoc.domain.model.Movie

fun MovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        url = url ?: "",
        summary = summary
    )
}

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        url = url ?: "",
        summary = summary
    )
}

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        url = url,
        summary = summary
    )
}

fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        url = url,
        summary = summary
    )
}
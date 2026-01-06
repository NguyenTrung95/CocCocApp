package com.example.coccoc.data.remote


import com.example.coccoc.data.remote.dto.MovieDto
import com.example.coccoc.data.remote.dto.MoviesResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {

    @GET("v4/articles/")
    suspend fun getTrendingMovies(): MoviesResponseDto

    @GET("v4/articles/")
    suspend fun getNowPlayingMovies(): MoviesResponseDto

    @GET("search/movie")
    suspend fun searchMovies(@Query("query") query: String): MoviesResponseDto

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") movieId: Int): MovieDto
}
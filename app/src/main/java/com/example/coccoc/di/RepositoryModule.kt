package com.example.coccoc.di

import com.example.coccoc.data.repository.MovieRepositoryImpl
import com.example.coccoc.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(
    SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}
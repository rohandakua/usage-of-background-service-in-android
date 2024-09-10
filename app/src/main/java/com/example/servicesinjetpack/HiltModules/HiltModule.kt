package com.example.servicesinjetpack.HiltModules

import com.example.servicesinjetpack.Domain.LogCatService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    fun provideLogCatService(): LogCatService {
        return LogCatService()
    }

}
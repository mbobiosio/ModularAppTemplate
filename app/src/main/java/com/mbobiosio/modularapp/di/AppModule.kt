package com.mbobiosio.modularapp.di

import com.mbobiosio.data.SampleRepoImpl
import com.mbobiosio.domain.SampleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSampleRepo(): SampleRepo = SampleRepoImpl()
}

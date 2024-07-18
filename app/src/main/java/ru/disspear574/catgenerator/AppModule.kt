package ru.disspear574.catgenerator

import cats.data.remote.BASE_URL
import cats.data.remote.CatsApi
import cats.data.repository.CatRepositoryImpl
import cats.domain.repository.CatRepository
import cats.domain.usecase.GetCatUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatsApi(): CatsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCatRepository(api: CatsApi): CatRepository {
        return CatRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCatUseCase(repository: CatRepository): GetCatUseCase {
        return GetCatUseCase(repository)
    }
}
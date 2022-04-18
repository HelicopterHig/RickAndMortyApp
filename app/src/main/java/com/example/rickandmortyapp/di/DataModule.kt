package com.example.rickandmortyapp.di

import com.example.data.api.Api
import com.example.data.constants.Constants
import com.example.data.repository.RepositoryInit
import com.example.domain.repository.Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    fun provideRepository(api: Api): Repository {
        return RepositoryInit(api)
    }
}

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(getOkHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getHttpLoginInterceptor()).build()
    }

    @Provides
    fun getHttpLoginInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    internal fun getApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }


}
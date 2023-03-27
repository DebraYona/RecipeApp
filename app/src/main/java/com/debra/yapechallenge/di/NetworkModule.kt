package com.debra.yapechallenge.di

import com.debra.yapechallenge.constants.Constants
import com.debra.yapechallenge.data.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providerLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    private fun addApiKeyToRequests(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val newUrl = originalHttpUrl.newBuilder()
            .build()
        request.url(newUrl)
        return chain.proceed(request.build())
    }

    @Singleton
    @Provides
    fun providerClient( logger: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor{ chain -> return@addInterceptor addApiKeyToRequests(chain) }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client:OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviesApiClient(retrofit: Retrofit):ApiClient{
        return retrofit.create(ApiClient::class.java)
    }

}
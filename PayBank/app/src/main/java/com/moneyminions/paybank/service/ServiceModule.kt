package com.moneyminions.paybank.service

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    @Named("BASE_URL")
    fun BaseUrl() : String = "http://3.39.110.134:8083/"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .addInterceptor(HttpLoggingInterceptor())
        .addInterceptor(ResponseInterceptor())
        .addInterceptor(RequestInterceptor())
//            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
//            .addInterceptor(AddCookiesInterceptor())  //쿠키 전송
//            .addInterceptor(ReceivedCookiesInterceptor()) //쿠키 추출
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


    @Singleton
    @Provides
    fun provideRetrofit(
        @Named("BASE_URL") baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()
            )
        )
        .client(provideOkHttpClient())
        .build()


    @Singleton
    @Provides
    fun provideBankService(
        retrofit: Retrofit
    ): BankService = retrofit.create(BankService::class.java)

}
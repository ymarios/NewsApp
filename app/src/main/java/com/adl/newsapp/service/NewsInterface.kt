package com.adl.newsapp.service

import com.adl.newsapp.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsInterface
{
    @Headers("x-api-key:b417974aecb74c838e14e90c5c296409")
    @GET("https://newsapi.org/v2/top-headlines?country=id&apiKey=b417974aecb74c838e14e90c5c296409")
    fun getNews(): Call<ResponseNews>

    @Headers("x-api-key:b417974aecb74c838e14e90c5c296409")
    @GET("https://newsapi.org/v2/top-headlines?category=health&country=id&apiKey=b417974aecb74c838e14e90c5c296409")
    fun getHealth(): Call<ResponseNews>

    @Headers("x-api-key:b417974aecb74c838e14e90c5c296409")
    @GET("https://newsapi.org/v2/top-headlines?category=entertainment&country=id&apiKey=b417974aecb74c838e14e90c5c296409")
    fun getEntertainment(): Call<ResponseNews>

    @Headers("x-api-key:b417974aecb74c838e14e90c5c296409")
    @GET("https://newsapi.org/v2/top-headlines?category=science&country=id&apiKey=b417974aecb74c838e14e90c5c296409")
    fun getScience(): Call<ResponseNews>

    @Headers("x-api-key:b417974aecb74c838e14e90c5c296409")
    @GET("https://newsapi.org/v2/top-headlines?category=sports&country=id&apiKey=b417974aecb74c838e14e90c5c296409")
    fun getSports(): Call<ResponseNews>

    @Headers("x-api-key:b417974aecb74c838e14e90c5c296409")
    @GET("https://newsapi.org/v2/top-headlines?category=technology&country=id&apiKey=b417974aecb74c838e14e90c5c296409")
    fun getTechnology(): Call<ResponseNews>
}
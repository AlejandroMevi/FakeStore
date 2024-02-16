package com.mevi.fakestore.ui

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoriesApieClient {

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("categories")
    suspend fun categories(): List<String>

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("category/{category}")
    suspend fun products(
        @Path("category") category: String
    ): List<ProductsResponse>
}
package com.example.mydogapp.client

import com.example.mydogapp.model.Dog
import retrofit2.http.GET
import retrofit2.http.Headers

interface IDogClient {
    // função com retorno modelo da classe
    @GET("v1/breeads")
    @Headers("x-api-key:8a334d12-3aa2-4ad5-87a9-429d62a1d8b2")
    suspend fun getBreads(): List<Dog>
}

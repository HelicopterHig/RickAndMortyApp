package com.example.data.api


import com.example.domain.model.CharacterList
import retrofit2.http.GET

interface Api {
    @GET("api/character")
    suspend fun getCharacters(): CharacterList
}
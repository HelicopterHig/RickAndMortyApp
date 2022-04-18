package com.example.domain.repository

import com.example.domain.model.CharacterList

interface Repository {
    suspend fun getCharacters(): CharacterList
}
package com.example.data.repository

import com.example.data.api.Api
import com.example.domain.model.CharacterList
import com.example.domain.repository.Repository

class RepositoryInit( val api: Api): Repository {

    override suspend fun getCharacters(): CharacterList {
        return  api.getCharacters()
    }
}
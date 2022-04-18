package com.example.domain.usecase

import com.example.domain.model.CharacterList
import com.example.domain.repository.Repository

class GetCharacterUseCase(val repository: Repository) {

    suspend fun getCustomPost(): CharacterList {
        return repository.getCharacters()
    }
}
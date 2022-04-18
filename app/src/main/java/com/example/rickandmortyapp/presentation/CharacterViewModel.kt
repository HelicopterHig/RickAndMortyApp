package com.example.rickandmortyapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CharacterData
import com.example.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.launch

class CharacterViewModel (private val getCharacterUseCase: GetCharacterUseCase): ViewModel() {

    var charactersPost = MutableLiveData<List<CharacterData>>()

    fun getCharacters() {
        viewModelScope.launch {
            val response = getCharacterUseCase.getCustomPost()
            charactersPost.value = response.results
        }
    }

}
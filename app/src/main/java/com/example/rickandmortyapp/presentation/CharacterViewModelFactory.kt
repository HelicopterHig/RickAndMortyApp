package com.example.rickandmortyapp.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetCharacterUseCase


class CharacterViewModelFactory (private  val getCharacterUseCase: GetCharacterUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterViewModel(getCharacterUseCase) as T
    }


}
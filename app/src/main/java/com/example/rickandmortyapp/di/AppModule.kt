package com.example.rickandmortyapp.di

import android.content.Context
import com.example.domain.usecase.GetCharacterUseCase
import com.example.rickandmortyapp.presentation.CharacterViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideCharacterViewModelFactory(getCharacterUseCase: GetCharacterUseCase): CharacterViewModelFactory{
        return CharacterViewModelFactory(getCharacterUseCase)
    }



}
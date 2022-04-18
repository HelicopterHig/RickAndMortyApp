package com.example.rickandmortyapp.di

import com.example.domain.repository.Repository
import com.example.domain.usecase.GetCharacterUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCharacterUseCase(repository: Repository): GetCharacterUseCase{
        return  GetCharacterUseCase(repository)
    }
}
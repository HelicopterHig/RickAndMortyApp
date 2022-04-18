package com.example.domain.model

data class CharacterData (
    val id: Int,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val location : LocationData?,
    val image: String?,
    var episode : List<String>
)
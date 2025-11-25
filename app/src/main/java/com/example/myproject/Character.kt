package com.example.myproject // CHANGE TO YOUR PACKAGE NAME

data class Character(
    val name: String,
    val species: String,
    val status: String,
    val image: String,
    val url: String
)

data class CharacterResponse(
    val results: List<Character>
)
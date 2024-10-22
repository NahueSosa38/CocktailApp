package com.example.cocktailapp

data class Cocktail(
    val drinks: List<Drink>
)

data class Drink(
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String,
    val strTags: String,
    val strCategory: String
)

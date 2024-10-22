package com.example.cocktailapp

import retrofit2.Call
import retrofit2.http.GET

interface CocktailApi {
    @GET("random.php")
    fun getRandomCocktail(): Call<Cocktail>

    @GET("filter.php?c=Cocktail")
    fun getCocktailList(): Call<Cocktail>

    @GET("filter.php?a=Non_Alcoholic")
    fun getNonAlcoholicList(): Call<Cocktail>
}

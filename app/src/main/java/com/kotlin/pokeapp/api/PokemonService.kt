package com.kotlin.pokeapp.api

import com.kotlin.pokeapp.api.model.PokemonApiResults
import com.kotlin.pokeapp.api.model.PokemonsApiResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
  @GET("pokemon")
  fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResults>

  @GET("pokemon/{number}")
  fun getPokemon(@Path("number")number: Int): Call<PokemonApiResults>
}
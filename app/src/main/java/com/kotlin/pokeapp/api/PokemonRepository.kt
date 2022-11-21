package com.kotlin.pokeapp.api

import android.util.Log
import com.kotlin.pokeapp.api.model.PokemonApiResults
import com.kotlin.pokeapp.api.model.PokemonsApiResults
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
  private val service: PokemonService

  init{
    val retrofit = Retrofit.Builder()
      .baseUrl("https://pokeapi.co/api/v2/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    service = retrofit.create(PokemonService::class.java)
  }

  fun listPokemons(limit: Int = 151): PokemonsApiResults?{
    val call = service.listPokemons(limit)
    return  call.execute().body()
  }

  fun getPokemon(number: Int): PokemonApiResults? {
    val call = service.getPokemon(number)

    return call.execute().body()

  }
}
package com.kotlin.pokeapp.api.model

import com.kotlin.pokeapp.domain.Pokemon
import com.kotlin.pokeapp.domain.PokemonType

data class PokemonsApiResults (
  val count: Int,
  val previous: String?,
  val next: String?,
  val results: List<PokemonResult>
  )

data class PokemonResult(
  val name: String,
  val url: String
)

data class PokemonApiResults(
  val id: Int,
  val name: String,
  val types: List<PokemonTypeSlot>
)

data class PokemonTypeSlot(
  val slot: Int,
  val type: PokemonType,
)


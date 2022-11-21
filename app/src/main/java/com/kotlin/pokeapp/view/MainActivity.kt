package com.kotlin.pokeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.pokeapp.R
import com.kotlin.pokeapp.api.PokemonRepository
import com.kotlin.pokeapp.api.model.PokemonResult
import com.kotlin.pokeapp.domain.Pokemon
import com.kotlin.pokeapp.domain.PokemonType

class MainActivity : AppCompatActivity() {
  lateinit var recyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)

    /*
    val charmander = Pokemon(
      "https://www.google.com/search?q=charmander&sxsrf=ALiCzsbnUf1ysvMLv9qJjFgOekHoJc3ETA:1668983429731&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjU9Nvj5737AhWdmIQIHXBAAHgQ_AUoAXoECAIQAw&biw=922&bih=734&dpr=1.25#imgrc=V9bLIeM2jgzwzM",
      4,
      "Charmander",
      listOf(
        PokemonType("Fire")
      )
    )
    val pokemons = listOf(charmander, charmander, charmander)
     */

    Thread(Runnable{
      loadPokemons()
    }).start()

  }

  private fun loadPokemons(){
    val pokemonsApiResult = PokemonRepository.listPokemons()

    pokemonsApiResult?.results?.let{
      val pokemons: List<Pokemon?> = it.map{ pokemonResult ->
        val number = pokemonResult.url.replace(
          "https://pokeapi.co/api/v2/pokemon",
          "")
          .replace("/", "").toInt()
        val pokemonApiResult = PokemonRepository.getPokemon(number)

       pokemonApiResult?.let{
         Pokemon(
           pokemonApiResult.id,
           pokemonApiResult.name,
           pokemonApiResult.types.map{
             type ->
              type.type
           }
         )
       }
      }

      val layoutManager = LinearLayoutManager(this)

      recyclerView.post {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
      }
    }
  }
}
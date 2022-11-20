package com.kotlin.pokeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.pokeapp.R
import com.kotlin.pokeapp.domain.Pokemon
import com.kotlin.pokeapp.domain.PokemonType

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)

    val charmander = Pokemon(
      "https://www.google.com/search?q=charmander&sxsrf=ALiCzsbnUf1ysvMLv9qJjFgOekHoJc3ETA:1668983429731&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjU9Nvj5737AhWdmIQIHXBAAHgQ_AUoAXoECAIQAw&biw=922&bih=734&dpr=1.25#imgrc=V9bLIeM2jgzwzM",
      4,
      "Charmander",
      listOf(
        PokemonType("Fire")
      )
    )

    val pokemons = listOf(charmander, charmander, charmander)


    val layoutManager = LinearLayoutManager(this)
    recyclerView.layoutManager = layoutManager
    recyclerView.adapter = PokemonAdapter(pokemons)
  }
}
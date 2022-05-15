package com.example.mydogapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mydogapp.databinding.ActivityMainBinding
import com.example.mydogapp.model.DogDetailsActivity
import com.example.mydogapp.model.mockDogs

class MainActivity : AppCompatActivity() {

    // Configurando Reyclerview

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Referenciando recyclerview passando o Adapter

        val dogListAdapter = DogItemAdapter()

        dogListAdapter.onClickListener = { dogId ->
            gotDogDetails(dogId)
        }
        binding.dogListRecyclerView.adapter = dogListAdapter

        // Passando os dados mockados
        dogListAdapter.submitList(mockDogs())
    }
    //Criando uma função para ter a intenção de chamar a tela de detalhes, e puxar inf, com putExtra
    private fun gotDogDetails(dogId: Int) {
        val intent = Intent(this, DogDetailsActivity::class.java)
        intent.putExtra("dogId",dogId)
        startActivity(intent)
    }
}

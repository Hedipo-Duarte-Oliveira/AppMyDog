package com.example.mydogapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydogapp.databinding.ActivityMainBinding
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
        }
        binding.dogListRecyclerView.adapter = dogListAdapter

        // Passando os dados mockados
        dogListAdapter.submitList(mockDogs())
    }
}

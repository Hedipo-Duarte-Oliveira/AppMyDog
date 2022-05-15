package com.example.mydogapp.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydogapp.databinding.ActivityDogDetailsBinding

class DogDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDogDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Pegando as informações lá do putExtra, caso não encontre passe o 0, pode fazer trativa
        val dogId = intent.getIntExtra("dogId", 0)

        // Vai pegar um mock selecionado
        val dogSelected = mockDogs().find { dog -> dog.id == dogId }

        // chamando o setData para ser executado no mee oncreate
        setData(dogSelected)
    } // Colocando os dados selecionados na minha tela, se não for nulo ele não roda o que está dentro do Let

    private fun setData(dogSelected: Dog?) {
        dogSelected?.let { dog ->
            binding.dogName.text = dog.name
            binding.dogBredForAndBreedGroup.text = dog.breed_group
            binding.dogLifeSpan.text = dog.life_span
            binding.dogTemperament.text = dog.temperament
        }
    }
}

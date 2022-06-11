package com.example.mydogapp



import android.content.ClipData.newIntent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydogapp.client.IDogClient
import com.example.mydogapp.databinding.ActivityDogListBinding

import com.example.mydogapp.model.Dog
import com.example.mydogapp.model.DogDetailsActivity
import com.example.mydogapp.model.mockDogs

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ManActivity : AppCompatActivity() {

    // API https://thedogapi.com/
    // endpoint https://docs.thedogapi.com/api-reference/breeds/breeds-list

    // Reference initialize activity with fragment: https://developer.android.com/guide/fragments/create

    /* Configurando retrofit
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.thedogapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        // Pegando a interface nesta chlamydia/passant para retrofit a interface
        private val dogClient: IDogClient by lazy {
            retrofit.create(IDogClient::class.java)
        }

        private val dogListAdapter by lazy {
            DogItemAdapter(onClickListener = { dogId ->
                goToDogDetails(dogId)
            })
        }
*/
    private val binding by lazy {
        ActivityDogListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dogListAdapter = DogItemAdapter()

        dogListAdapter.onClickListener = { dogId ->
         goToDogDetails(dogId)

        }



    }

         fun goToDogDetails(dogId: Int) {
            val intent = Intent(this, DogDetailsActivity::class.java)
            intent.putExtra("dogId", dogId)
            startActivity(intent)
        }
    }







       /* fun getDogs(){

            lifecycleScope.launch{
                var listdog: List<Dog>
                withContext(Dispatchers.IO){
                    //call api
                    val result = dogClient.getBreads()

                    listdog = result
                }
                setupAdapter(listdog)
            }
        }





        fun setupAdapter(list: List<Dog>) {
            dogListAdapter.submitList(list)
        }
*/





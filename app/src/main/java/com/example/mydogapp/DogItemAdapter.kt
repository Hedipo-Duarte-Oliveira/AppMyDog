package com.example.mydogapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydogapp.databinding.DogListItemBinding
import com.example.mydogapp.model.Dog

class DogItemAdapter(onClikListener: Any) : ListAdapter<Dog, DogItemAdapter.DogItemViewHolder>(DIFF_CALLBACK) {

    var onClickListener: ((dogId: Int) -> Unit)? = null

    // Membro dos ItemAdapter esse espera receber um ViewHolder/Chamado unica vez
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogItemViewHolder {
        val binding = DogListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        // espera ListBinding precisamos Inflar
        return DogItemViewHolder(binding, onClickListener)
    }

    // CHAMADO ATODO MOMENTO PEGAR UM ITEM DE ACORDO COM A POSIÇÃO

    override fun onBindViewHolder(holder: DogItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // List espera um ViewHoder, que faz o processo de bindo,pegar iTens da lista.

    class DogItemViewHolder(
        private val binding: DogListItemBinding,
        private val onClickListener: ((dogId: Int) -> Unit)?

    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dog: Dog) {
            binding.dogName.text = dog.name
            binding.dogBredFor.text = dog.bred_for

           /* // carregando a imagem para o contexto passado
            Glide
                .with(binding.root.context)
                .load(dog.image.url)
                .centerCrop()
                .into(binding.dogImage)
*/
            binding.root.setOnClickListener {
                onClickListener?.invoke(dog.id)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Dog>() {

            // Comparar uma propiedade especifica, que seja única
            override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
                return oldItem.id == newItem.id
            }

            // Comparar se os objetos são diferentes, ou seja as instancias
            override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
                return oldItem == newItem
            }
        }
    }
}

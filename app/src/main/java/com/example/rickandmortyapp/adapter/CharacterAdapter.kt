package com.example.rickandmortyapp.adapter


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.CharacterData
import com.example.rickandmortyapp.CharacterActivity
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.CharacterItemBinding


class CharacterAdapter(): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var myList = emptyList<CharacterData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myList[position])

      holder.itemView.setOnClickListener { view ->

          val intent = Intent(view.context, CharacterActivity::class.java)
          intent.putExtra("name", myList[position].name.toString())
          intent.putExtra("gender",myList[position].gender.toString())
          intent.putExtra("species",myList[position].species.toString())
          intent.putExtra("status",myList[position].status.toString())
          intent.putExtra("location",myList[position].location?.name.toString())
          intent.putExtra("image",myList[position].image.toString())
          intent.putExtra("episode",myList[position].episode.size.toString())
          view.context.startActivity(intent)
      }
    }


    override fun getItemCount(): Int {
        return myList.size
    }

    inner class ViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(characterData: CharacterData) {
            binding.tvId.text = characterData.id.toString()
            binding.tvName.text = characterData.name.toString()
            binding.tvSpecies.text =characterData.species.toString()
            binding.tvGender.text = characterData.gender.toString()

            setCharactermage(characterData)
        }

        private fun setCharactermage(characterData: CharacterData) {
            Glide.with(itemView)
                .load(characterData.image)
                .placeholder(R.drawable.default_rick)
                .into(binding.characterImg)
        }
    }

    fun setData(charactersList: List<CharacterData?>) {
        try {
            myList = charactersList as List<CharacterData>
            notifyDataSetChanged()
        } catch (e: Exception) {
            Log.d("Exception", "Data not changed")
        }
    }
}
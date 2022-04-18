package com.example.rickandmortyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.domain.model.CharacterData
import com.example.rickandmortyapp.databinding.ActivityCharacterBinding


class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        bindCharacter()
        setCharacterImage()
    }

    private fun bindCharacter(): String {
        val intent = intent
        binding.tvName.text = intent.getStringExtra("name")
        binding.tvGender.text = intent.getStringExtra("gender")
        binding.tvSpecies.text = intent.getStringExtra("species")
        binding.tvStatus.text = intent.getStringExtra("status")
        binding.tvLocation.text = intent.getStringExtra("location")
        binding.tvEpisodes.text = intent.getStringExtra("episode")
        return intent.getStringExtra("image").toString()
    }

    private fun setCharacterImage() {
        Glide.with(binding.imageCharacterAbout)
            .load(bindCharacter())
            .placeholder(R.drawable.default_rick)
            .circleCrop()
            .into(binding.imageCharacterAbout)
    }
}
package com.example.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmortyapp.adapter.CharacterAdapter
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.presentation.CharacterViewModel
import com.example.rickandmortyapp.presentation.CharacterViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var characterViewModelFactory: CharacterViewModelFactory

    private lateinit var characterViewModel: CharacterViewModel
    private val characterAdapter by lazy { CharacterAdapter() }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerview()

        (applicationContext as App).appComponent.inject(this)
        characterViewModel = ViewModelProvider(this, characterViewModelFactory)[CharacterViewModel::class.java]

        characterViewModel.getCharacters()
        characterViewModel.charactersPost.observe(this, Observer { response ->
            characterAdapter.setData(response)
        })
    }

    private fun setupRecyclerview() {
        binding.rcView.adapter = characterAdapter
        binding.rcView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
    }
}
package com.example.lessonsapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselSnapHelper

class CarroselPageActivity : AppCompatActivity() {

    private lateinit var carouselRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_carousel)

        carouselRecyclerView = findViewById(R.id.carouselRecyclerView)

        val imageResIds = listOf(
            R.drawable.tuto_home,
            R.drawable.tuto_musica,
            R.drawable.tuto_pesquisa
        )

        carouselRecyclerView.adapter = CarouselAdapter(imageResIds)
        CarouselSnapHelper().attachToRecyclerView(carouselRecyclerView)
    }
}
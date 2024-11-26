package com.example.lessonsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class AdvancedScreen : AppCompatActivity() {

    lateinit var selectBtn: Button
    lateinit var previousBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.advanced_screen)
        selectBtn = findViewById(R.id.selectBtn)
        previousBtn = findViewById(R.id.previousBtn)

        selectBtn.setOnClickListener {goToSongListActivity()}
        previousBtn.setOnClickListener {goToStarterScreen()}
    }

    private fun goToStarterScreen(){
        val intent = Intent(this, StarterScreen::class.java)
        startActivity(intent)
    }

    private fun goToSongListActivity(){
        val intent = Intent(this, SongListActivity::class.java)
        startActivity(intent)
    }

}
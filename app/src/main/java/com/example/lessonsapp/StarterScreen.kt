package com.example.lessonsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class StarterScreen : AppCompatActivity() {

    lateinit var selectBtn: Button
    lateinit var nextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.starter_screen)

        selectBtn = findViewById(R.id.selectBtn)
        nextBtn = findViewById(R.id.nextBtn)

        selectBtn.setOnClickListener {goToSongListActivity()}
        nextBtn.setOnClickListener {goToNextScreen()}
    }

    private fun goToNextScreen(){
        val intent = Intent(this, AdvancedScreen::class.java)
        startActivity(intent)
    }

    private fun goToSongListActivity(){
        val intent = Intent(this, SongListActivity::class.java)
        startActivity(intent)
    }

}
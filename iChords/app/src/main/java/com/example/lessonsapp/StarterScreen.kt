package com.example.lessonsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class StarterScreen : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.starter_screen)
        button = findViewById(R.id.selectBtn)
        button.setOnClickListener {goToSongListActivity()}
    }

    private fun goToSongListActivity(){
        val intent = Intent(this, SongListActivity::class.java)
        startActivity(intent)
    }

}
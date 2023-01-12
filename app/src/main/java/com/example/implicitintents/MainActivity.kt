package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnTakePhoto = findViewById<Button>(R.id.btnTakePhoto)
        val ivPhoto =  findViewById<ImageView>(R.id.ivPhoto)
        val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
            ivPhoto.setImageURI(it)
        }

        btnTakePhoto.setOnClickListener {
            pickImage.launch("image/*")
        }
    }


}
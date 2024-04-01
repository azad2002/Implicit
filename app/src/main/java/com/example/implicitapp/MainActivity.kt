package com.example.implicitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webButton = findViewById<CardView>(R.id.cardWeb)
        val cameraButton = findViewById<CardView>(R.id.cardCamera)
        val txtbutton = findViewById<EditText>(R.id.text1)
        val pressButton = findViewById<Button>(R.id.btnOne)
        val callButton = findViewById<Button>(R.id.btnTwo)


        webButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.reddit.com/")
            startActivity(intent)
        }
        cameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        pressButton.setOnClickListener {
           val text = txtbutton.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type ="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,text)
            startActivity(Intent.createChooser(intent,"Share via"))
        }
        callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+123456789")
            startActivity(intent)
        }




    }
}
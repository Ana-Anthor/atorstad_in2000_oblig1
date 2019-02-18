package com.example.atorstad_in2000_oblig1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

class PictureActivity : AppCompatActivity() {

    //oppretter en imageview hvor leg legger bildet
    lateinit var ImageView1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)
        ImageView1 = findViewById(R.id.image_from_url)

        //henter bilde og legger det inn vha url
        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ole-Johan_Dahls_hus_20110911-11.JPG")
            .into(ImageView1)

        //change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Picture"
    }

    //called when the user taps the nextActivity button
    fun nextActivity(view: View) {
        //Do something in response to button
        val intent = Intent(this, Converter::class.java).apply {
        }
        startActivity(intent)
    }
}

package com.example.atorstad_in2000_oblig1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_converter.*

//Det kan se ut som om det var denne som manglet???
const val EXTRA_MESSAGE = "com.example.atorstad_in2000_oblig1.MESSAGE"

class Converter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        //change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Converter"

        /** Called when the user taps the CALCULATE button */
        calculate_btn.setOnClickListener{
            val input = findViewById<EditText>(R.id.inputCm)
            val inputDouble = input.text.toString().toDouble()
            val gyldigInput = 0.0..999999.0

            if (inputDouble in gyldigInput){
                //beregner
                val inch = 0.39370097
                val inInches = inputDouble * inch
                val avrundet = "%.2f".format(inInches)

                outputInch.setText("$inputDouble cm = $avrundet inches")

            } else {
                //feilmelding
                Toast.makeText(this,"Input not between 0 - 999 999",Toast.LENGTH_LONG).show()
            }
        }
    }
    /** Called when the user taps the nextActivity button*/
    fun nextActivity2(view: View) {
        //Do something in response to button
        val intent = Intent(this, ListActivity::class.java).apply {
        }
        startActivity(intent)
    }
}

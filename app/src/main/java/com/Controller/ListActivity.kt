package com.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import com.Model.Element
import com.Services.DataServise
import com.example.atorstad_in2000_oblig1.R
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.add_new_element.view.*

class ListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        //change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "List"

        //adding the first two elements
        val adapter = com.Adapters.ListAdapter(this, DataServise.elements)


        my_recycler_view.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        my_recycler_view.layoutManager = layoutManager
        my_recycler_view.setHasFixedSize(true)

        //the floating action button
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            //setContentView(R.layout.add_new_element)
            //allert(it)
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_new_element, null)

            val builder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Add New Element")
            val mAlertDialog: AlertDialog = builder.show()

            //pressed the "+" btn -> open dialog
            mDialogView.dialogbtn.setOnClickListener {

                mAlertDialog.dismiss()
                //get text from dialog view
                val title = mDialogView.dialogTitle.text.toString()
                val text = mDialogView.dialogText.text.toString()
                if (title.trim().length > 0 || text.trim().length > 0) {

                    //create the new element
                    val newElement = Element(title, text)
                    //add the new element to the list in DataService
                    DataServise.adding(newElement)
                    //making a new view
                    val newAdapter = com.Adapters.ListAdapter(this, DataServise.elements)
                    my_recycler_view.adapter = newAdapter
                }

                

            }
        }
    }

}












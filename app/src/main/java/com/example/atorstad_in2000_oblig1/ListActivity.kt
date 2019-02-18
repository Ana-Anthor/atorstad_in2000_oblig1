package com.example.atorstad_in2000_oblig1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class ListActivity : AppCompatActivity() {
    //skal dette være med?
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var listenMin: MutableList<String> = mutableListOf() //i stedet for String: liste med objektene mine



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        //change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "List"

        //Proever aa putte noe inn i listen min, men det funker ikke
        val s1 = "Hei"
        val s2 = "Hallo"
        listenMin.add(s1)
        listenMin.add(s2)

        //dette etter her har jeg bare puttet her
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(listenMin) //her skal listen min inn

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    class MyAdapter(private val myDataset: MutableList<String>) : //I stedet for <string>: min objekt
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        // Each data item is just a string in this case that is shown in a TextView.
        class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)


        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyAdapter.MyViewHolder {
            // create a new view
            val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.element, parent, false) as TextView  //endrer fra my_text_view til element
            // set the view's size, margins, paddings and layout parameters
            //...
            return MyViewHolder(textView)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textView.text = myDataset[position]
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = myDataset.size
    }

}





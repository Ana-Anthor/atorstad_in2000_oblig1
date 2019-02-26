package com.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.Model.Element
import com.example.atorstad_in2000_oblig1.R

class ListAdapter(val context: Context, val elements: List<Element> ) : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.element, p0, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return elements.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, p1: Int) {
        holder.bindCategory(elements[p1], context)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val elementText = itemView.findViewById<TextView>(R.id.elementText)
        val elementTitle = itemView.findViewById<TextView>(R.id.elementTitle)

        fun bindCategory(element: Element, context: Context){
            val resourseId = context.resources.getIdentifier(element.text,
                "drawable", context.packageName)
            elementText?.text = element.text
            elementTitle?.text = element.title
        }
    }

}

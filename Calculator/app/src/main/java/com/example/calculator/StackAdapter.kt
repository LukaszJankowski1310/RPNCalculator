package com.example.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StackAdapter(val numberList:List<Float>) : RecyclerView.Adapter<StackViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StackViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val stackItem = layoutInflater.inflate(R.layout.stack_item, parent, false)

        return StackViewHolder(stackItem)
    }

    override fun onBindViewHolder(holder: StackViewHolder, position: Int) {
        val num = numberList[position]
        holder.stackItemTV.text = num.toString()

    }

    override fun getItemCount(): Int {
        return numberList.size
    }


}

class StackViewHolder(val view : View): RecyclerView.ViewHolder(view){
    val stackItemTV = view.findViewById<TextView>(R.id.tv_stackItem)
}
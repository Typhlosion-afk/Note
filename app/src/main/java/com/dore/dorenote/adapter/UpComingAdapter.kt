package com.dore.dorenote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import com.dore.dorenote.R
import com.dore.dorenote.model.Planning

class UpComingAdapter(var context: Context, var list: ArrayList<Planning>): RecyclerView.Adapter<UpComingAdapter.ComingHolder>(){

    private lateinit var rootView: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingHolder {
        rootView = LayoutInflater.from(context).inflate(R.layout.card_upcoming, parent, false)
        return ComingHolder(rootView)
    }

    override fun onBindViewHolder(holder: ComingHolder, position: Int) {
        holder.txtName.text = list[position].name
        holder.itemView.setOnClickListener {
            holder.checkBox.isChecked = !holder.checkBox.isChecked
        }
    }

    override fun getItemCount(): Int = list.size


    inner class ComingHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtName: TextView = itemView.findViewById(R.id.name_upcoming)
        var checkBox: CheckBox = itemView.findViewById(R.id.checkbox_upcoming)
    }
}
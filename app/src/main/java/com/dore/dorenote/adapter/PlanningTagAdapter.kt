package com.dore.dorenote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dore.dorenote.R
import com.dore.dorenote.model.Planning

class PlanningTagAdapter(private val context: Context, private val listPlanning: List<Planning>) :
    RecyclerView.Adapter<PlanningTagAdapter.PlanningHolder>() {

    private lateinit var rootView: View
    private lateinit var listBg: ArrayList<Int>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanningTagAdapter.PlanningHolder {
        rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_planning, parent, false)

        listBg = ArrayList()
        randomBackGround()

        return PlanningHolder(rootView)
    }

    override fun onBindViewHolder(holder: PlanningTagAdapter.PlanningHolder, position: Int) {
        val planning = listPlanning[position]
        holder.txtPlanningTag.text = planning.tagName
        holder.itemView.setBackgroundResource(planning.backgroundNumber)
    }

    override fun getItemCount(): Int = listPlanning.size

    inner class PlanningHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtPlanningTag: TextView = itemView.findViewById(R.id.txt_tag_name)
        init {
            itemView.setOnClickListener {
                Toast
                    .makeText(context, "${txtPlanningTag.text} was clicked", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun addListBg(){
        listBg.add(R.drawable.planning_tag_gradient_1)
        listBg.add(R.drawable.planning_tag_gradient_2)
        listBg.add(R.drawable.planning_tag_gradient_3)
        listBg.add(R.drawable.planning_tag_gradient_4)
        listBg.add(R.drawable.planning_tag_gradient_5)
        listBg.add(R.drawable.planning_tag_gradient_6)
        listBg.add(R.drawable.planning_tag_gradient_7)
    }

    private fun randomBackGround(){
        if(listBg.size == 0){
            addListBg()
        }
        for (p in listPlanning){
            p.backgroundNumber = listBg.random()
        }
    }
}
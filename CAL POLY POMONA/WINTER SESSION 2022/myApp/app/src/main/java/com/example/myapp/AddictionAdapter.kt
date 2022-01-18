package com.example.myapp

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_todo.view.*


class AddictionAdapter(
    private val addictionList: MutableList<Addiction>

):RecyclerView.Adapter<AddictionAdapter.AddictionHolder>() {

    class AddictionHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddictionHolder {
        return AddictionHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun addApp(todo: Addiction){
        addictionList.add(todo)
        notifyItemInserted(addictionList.size - 1)
    }

    fun deleteApp(){
        addictionList.removeAll { addiction ->
            addiction.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(addictAppNames: TextView, isChecked: Boolean){
        if(isChecked){
            addictAppNames.paintFlags = addictAppNames.paintFlags or STRIKE_THRU_TEXT_FLAG
        }

        else{
            addictAppNames.paintFlags = addictAppNames.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }

    }

    override fun onBindViewHolder(holder: AddictionHolder, position: Int) {

        val currentApp = addictionList[position]
        holder.itemView.apply {
            addictAppNames.text = currentApp.title
            removeApp.isChecked = currentApp.isChecked
            toggleStrikeThrough(addictAppNames, currentApp.isChecked)
            removeApp.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(addictAppNames, isChecked)
                currentApp.isChecked = !currentApp.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return addictionList.size
    }
}
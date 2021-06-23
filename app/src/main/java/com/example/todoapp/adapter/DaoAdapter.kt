package com.example.todoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.Task

class DaoAdapter(private val listOfTasks: List<Task>): RecyclerView.Adapter<DaoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val item = layoutInflater.inflate(R.layout.task_item, parent, false)
        return MyViewHolder(item)
    }

    override fun getItemCount(): Int {

        return listOfTasks.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.categoryTextView.text = listOfTasks[position].category
        holder.nameTextView.text = listOfTasks[position].name
        holder.dataTextView.text = listOfTasks[position].date
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val categoryTextView: TextView = view.findViewById(R.id.tv_category)
        val nameTextView: TextView = view.findViewById(R.id.tv_name)
        val dataTextView: TextView = view.findViewById(R.id.tv_data)
    }



}
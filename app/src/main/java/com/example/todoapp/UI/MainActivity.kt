package com.example.todoapp.UI

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.adapter.DaoAdapter
import com.example.todoapp.data.Task
import com.example.todoapp.viewmodel.TasksViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TasksViewModel
    private lateinit var daoAdapter: DaoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listOfTasks: LiveData<List<Task>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider.AndroidViewModelFactory
            .getInstance(application)
            .create(TasksViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        listOfTasks = viewModel.getAllTasks()
        listOfTasks.observe(this, Observer{
            if (it.isNotEmpty()){
                daoAdapter = DaoAdapter(it)
                recyclerView.adapter = daoAdapter
                text11.setText("")
            } else
                text11.setText("Brak zadań")
        })

            floatingActionButton.setOnClickListener {
                 val intent = Intent(this, ShowListActivity::class.java)
                startActivity(intent)
            }

    }

}
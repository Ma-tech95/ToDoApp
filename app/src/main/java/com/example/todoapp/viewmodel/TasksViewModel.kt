package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.todoapp.data.Task
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class TasksViewModel(application: Application) :
  AndroidViewModel(application){

    private var tasksRepository: TasksRepository =
          TasksRepository(application)

    private var allTasks: Deferred<LiveData<List<Task>>> =
            tasksRepository.getAllTasksAsync()

    fun insertTask(task: Task) {
        tasksRepository.insertTask(task)
    }

    fun getAllTasks(): LiveData<List<Task>> = runBlocking {
        allTasks.await()
    }

    fun deleteAllItems(){
        tasksRepository.deleteAllItems()
    }
}
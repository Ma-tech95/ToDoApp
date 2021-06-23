package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.todoapp.dao.TaskDao
import com.example.todoapp.data.Task
import com.example.todoapp.db.TasksDatabase
import kotlinx.coroutines.*

class TasksRepository(application: Application) {

    private var taskDao: TaskDao

    init {
        val database = TasksDatabase
            .getInstance(application.applicationContext)

        taskDao = database!!.taskDao()
    }

    fun insertTask(task: Task) =
        CoroutineScope(Dispatchers.IO).launch {
            taskDao.insert(task)
        }

    fun getAllTasksAsync(): Deferred<LiveData<List<Task>>> =
            CoroutineScope(Dispatchers.IO).async {
                taskDao.getAllTasks()
            }

    fun deleteAllItems() =
            CoroutineScope(Dispatchers.IO).launch {
                taskDao.deleteAllRows()
            }
}
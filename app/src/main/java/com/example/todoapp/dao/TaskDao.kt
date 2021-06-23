package com.example.todoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapp.data.Task

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Query("SELECT * FROM tasks_table")
    fun getAllTasks() : LiveData<List<Task>>

    @Query("DELETE FROM tasks_table")
    fun deleteAllRows()
}
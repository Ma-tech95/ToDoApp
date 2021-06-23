package com.example.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.dao.TaskDao
import com.example.todoapp.data.Task

@Database(entities = [Task::class], version = 3, exportSchema = false)
abstract class TasksDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object{
        private var instance: TasksDatabase? = null

        fun getInstance(context: Context): TasksDatabase?{
            if(instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    TasksDatabase::class.java,
                    "tasks_table"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }


    }

}
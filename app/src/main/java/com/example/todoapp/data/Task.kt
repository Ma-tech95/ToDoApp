package com.example.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks_table")
data class Task (var category: String,
                 var name: String,
                 var date: String) {

    @PrimaryKey(autoGenerate = true)
    var userId = 0
}
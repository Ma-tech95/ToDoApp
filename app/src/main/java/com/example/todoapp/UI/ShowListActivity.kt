package com.example.todoapp.UI

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.R
import com.example.todoapp.data.Task
import com.example.todoapp.viewmodel.TasksViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_show_list.*
import kotlinx.android.synthetic.main.task_item.*
import java.util.*

class ShowListActivity : AppCompatActivity() {

    private lateinit var viewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(TasksViewModel::class.java)


        //
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        pickDateBtn.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, { view, mYear, mMonth, mDay ->
                et_data.setText(""+ mDay +"/"+ mMonth +"/"+ mYear)
            }, year, month, day)

            datePickerDialog.show()
        }



        add.setOnClickListener {
            val intent1 = Intent(applicationContext, MainActivity::class.java)

            val category = findViewById<Spinner>(R.id.et_category)
            val text = category.selectedItem.toString()

            val name = et_name.text.toString()
            val data = et_data.text.toString()
            val task = Task(text, name, data)

            if (text.trim().isNotEmpty() && data.trim().isNotEmpty() && name.trim().isNotEmpty()){
                Toast.makeText(this,"Zadanie zostało dodane pomyślnie.", Toast.LENGTH_LONG).show()
                viewModel.insertTask(task)
                startActivity(intent1)
            }else{
                Toast.makeText(this,"Proszę wypełnić wszystkie pola.", Toast.LENGTH_LONG).show()
            }
        }


        quit.setOnClickListener {
            val intent2 = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent2)

        }


        button.setOnClickListener {
            viewModel.deleteAllItems()
        }



    }
}
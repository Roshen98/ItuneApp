package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var addictionAdapter: AddictionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addictionAdapter = AddictionAdapter(mutableListOf())

        addictedAppList.adapter = addictionAdapter
        addictedAppList.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val todoTitle = addictedApps.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Addiction(todoTitle)
                addictionAdapter.addApp(todo)
                addictedApps.text.clear()
            }
        }
        btnDelete.setOnClickListener {
            addictionAdapter.deleteApp()
        }
    }
}

package com.example.contact_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //Obter o RecyclerView do Layout
    private val rvList: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.recyclerView_list)
    }
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindOnView()
        updateList()
    }

    private fun bindOnView(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Rafael Fernandes",
                    "(00) 1245-5698",
                    "img.png"
                ),
                Contact(
                    "Maria José",
                    "(00) 1245-5698",
                    "img.png"
                )
            )
        )
    }
}
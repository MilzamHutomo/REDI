package com.project.relawanmengabdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var vacancyViewer: RecyclerView
    private var list: ArrayList< Vacancy > = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vacancyViewer = findViewById( R.id.view_vacancy )
        vacancyViewer.setHasFixedSize( true )

        list.addAll( VacancyData.listData )
        showRecyclerList()

    }

    private fun showRecyclerList(){
        vacancyViewer.layoutManager = LinearLayoutManager( this )
        val vacancyListAdapter = VacancyListViewAdapter( list )
        vacancyViewer.adapter = vacancyListAdapter
    }
}

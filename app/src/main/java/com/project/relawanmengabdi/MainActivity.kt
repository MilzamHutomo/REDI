package com.project.relawanmengabdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var vacancyViewer: RecyclerView
    private var list: ArrayList< Vacancy > = arrayListOf()
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = FirebaseDatabase.getInstance().getReference("Vacancies")

        val vacancyListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for ( postSnapshot: DataSnapshot in dataSnapshot.children ) run {
                    val vacancy: Vacancy? = postSnapshot.getValue(Vacancy::class.java)
                    if (vacancy != null) {
                        list.add( vacancy )
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }

        database.addValueEventListener( vacancyListener )

        vacancyViewer = findViewById( R.id.view_vacancy )
        vacancyViewer.setHasFixedSize( true )

        showRecyclerList()

    }

    private fun showRecyclerList(){
        vacancyViewer.layoutManager = LinearLayoutManager( this )
        val vacancyListAdapter = VacancyListViewAdapter( list )
        vacancyViewer.adapter = vacancyListAdapter
    }
}

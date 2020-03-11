package com.project.relawanmengabdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var vacancyViewer: RecyclerView
    private var listVacancy: ArrayList< Vacancy > = arrayListOf()
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = FirebaseDatabase.getInstance().reference.child("Vacancies")

        vacancyViewer = findViewById( R.id.view_vacancy )

        val vacancyListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var t: GenericTypeIndicator<List<Vacancy>> = object : GenericTypeIndicator<List<Vacancy>>(){
                }
                listVacancy = dataSnapshot.getValue(t) as ArrayList<Vacancy>
//                Toast.makeText(this@MainActivity, listVacancy.size.toString(), Toast.LENGTH_LONG).show()
                for(item in listVacancy){
                    Log.d("Nama event: ", item.name)
                    Log.d("Lokasi event: ", item.location)
                    Log.d("Durasi event: ", item.duration)
                }

                //private fun showRecyclerList()
                val vacancyListAdapter = VacancyListViewAdapter( listVacancy )
                vacancyViewer.layoutManager = LinearLayoutManager( this@MainActivity )
                vacancyViewer.adapter = vacancyListAdapter

            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        database.addValueEventListener( vacancyListener )
    }
}

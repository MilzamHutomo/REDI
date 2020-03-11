package com.project.relawanmengabdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var vacancyViewer: RecyclerView
    private var listVacancy: ArrayList< Vacancy > = arrayListOf()
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = FirebaseDatabase.getInstance().reference.child("Vacancies")

//        val datalist = arrayListOf< Vacancy >()
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

                val vacancyListAdapter = VacancyListViewAdapter( listVacancy )
                vacancyViewer.layoutManager = LinearLayoutManager( this@MainActivity )
                vacancyViewer.adapter = vacancyListAdapter

//                val data = Vacancy()
//                for (uniqueKeySnapShot: DataSnapshot in dataSnapshot.children) {
//                    data.name = uniqueKeySnapShot.key.toString()
//                    val durationSnapShot: DataSnapshot = uniqueKeySnapShot.child("Duration")
//                    val duration: String? = durationSnapShot.getValue(String::class.java)
//                    data.duration = duration.toString()
//                    val locationSnapShot: DataSnapshot = uniqueKeySnapShot.child("Location")
//                    val location: String? = locationSnapShot.getValue(String::class.java)
//                    data.location = location.toString()
//                    datalist.add( data )
//                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }

        database.addValueEventListener( vacancyListener )

        //showRecyclerList()

    }

    private fun showRecyclerList(){
        val vacancyListAdapter = VacancyListViewAdapter( listVacancy )
        vacancyViewer.layoutManager = LinearLayoutManager( this )
        vacancyViewer.adapter = vacancyListAdapter
    }
}

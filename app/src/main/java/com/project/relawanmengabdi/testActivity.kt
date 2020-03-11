package com.project.relawanmengabdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.database.*
import org.w3c.dom.Text

class testActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        database = FirebaseDatabase.getInstance().reference.child("Vacancies")

        val vacancyListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //val datalist = arrayListOf< Vacancy >()
                for (uniqueKeySnapShot: DataSnapshot in dataSnapshot.children) {
                    var viewTitle: TextView = findViewById(R.id.textView)
                    val durationSnapShot: DataSnapshot = uniqueKeySnapShot.child("Duration")
                    val duration: String? = durationSnapShot.getValue(String::class.java)
                    val name: String = duration.toString()
                    viewTitle.text = name
//                    val data = Vacancy()
//                    data.name = uniqueKeySnapShot.key.toString()
//                    val durationSnapShot: DataSnapshot = uniqueKeySnapShot.child("Duration")
//                    val duration: String? = durationSnapShot.getValue(String::class.java)
//                    data.duration = duration.toString()
//                    val locationSnapShot: DataSnapshot = uniqueKeySnapShot.child("Location")
//                    val location: String? = locationSnapShot.getValue(String::class.java)
//                    data.location = location.toString()
//                    datalist.add( data )
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }

        database.addValueEventListener( vacancyListener )
    }
}

package com.project.relawanmengabdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class VacancyDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vacancy_detail)

        val btnApply: Button = findViewById(R.id.apply_btn)

        btnApply.setOnClickListener{
            Toast.makeText(this, "Application Successfull", Toast.LENGTH_SHORT).show()
            val moveToMessage = Intent(this, ApplicationConfirm::class.java)
            startActivity( moveToMessage )
        }

        val title: String? = intent.getStringExtra( "vacancy_title" )
        val titleContainer: TextView = findViewById( R.id.vacancy_title_holder )
        titleContainer.text = title
    }
}

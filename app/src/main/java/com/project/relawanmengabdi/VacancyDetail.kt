package com.project.relawanmengabdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class VacancyDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vacancy_detail)

        val title: String = intent.getStringExtra( "vacancy_title" )
        val titleContainer: TextView = findViewById( R.id.vacancy_title_holder )
        titleContainer.text = title
    }
}

package com.project.relawanmengabdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ApplicationConfirm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_confirm)

        val btnToHome: Button = findViewById( R.id.btn_to_home )

        btnToHome.setOnClickListener{
            val moveToHome = Intent( this, MainActivity::class.java )
            startActivity( moveToHome )
        }

    }
}

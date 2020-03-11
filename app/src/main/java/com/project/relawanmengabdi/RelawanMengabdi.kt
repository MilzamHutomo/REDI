package com.project.relawanmengabdi

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class RelawanMengabdi : Application() {
    override fun onCreate() {
        super.onCreate()

        if( FirebaseApp.getApps( this ).isEmpty() ){
            FirebaseDatabase.getInstance().setPersistenceEnabled( true )
        }
        
    }
}
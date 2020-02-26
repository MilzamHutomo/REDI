package com.project.relawanmengabdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        login_btn.setOnClickListener{
            doLogin()
        }
    }

    private fun doLogin(){
        if( email_field.text.toString().isEmpty() ){
            email_field.error = "Please enter your registered email"
            email_field.requestFocus()
            return
        }

        if( !Patterns.EMAIL_ADDRESS.matcher( email_field.text.toString() ).matches() ){
            email_field.error = "Not a valid email"
            email_field.requestFocus()
            return
        }

        if( pass_field.text.toString().isEmpty() ){
            pass_field.error = "Please enter your password"
            pass_field.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(email_field.text.toString(), pass_field.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }
            }

    }

    fun updateUI(currentUser: FirebaseUser?) {
        if ( currentUser != null ){
            startActivity( Intent(this, MainActivity::class.java) )
        }else {
            Toast.makeText(
                baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

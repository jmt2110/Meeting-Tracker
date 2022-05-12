package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main3.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    var email = "user1@email.com"
    var password = "Password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val LoginBtn = findViewById<Button>(R.id.idLoginBtn)
        LoginBtn.setOnClickListener {
            var userEmail = idEmail.text.toString()
            var userPassword = idPassword.text.toString()

            if (email == userEmail && password == userPassword){
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
            }
            else {

                if(email != userEmail){
                    idEmail.text.clear()
                    idEmail.hint = "Incorrect E-Mail"
                    idEmail.setHintTextColor(Color.parseColor("#FF0000"))
                }

                if(password != userPassword){
                    idPassword.text.clear()
                    idPassword.hint = "Incorrect Password"
                    idPassword.setHintTextColor(Color.parseColor("#FF0000"))
                }

                }

        }




    }
}
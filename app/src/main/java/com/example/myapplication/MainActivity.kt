package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val url = findViewById<EditText>(R.id.url)
       val email = findViewById<EditText>(R.id.email)
       val message = findViewById<EditText>(R.id.msg)
       val btn = findViewById<Button>(R.id.btn)

        var urlUsed = ""
        var emailUsed = ""
        var msgUsed = ""

        btn.setOnClickListener {
            urlUsed = url.text.toString()
            emailUsed = email.text.toString()
            msgUsed = message.text.toString()

            if(urlUsed == "" && emailUsed == "" && msgUsed == ""){
                Toast.makeText(applicationContext,"Kindly provide with url, email and a message", Toast.LENGTH_LONG).show()
            }else{
                var intent = Intent(applicationContext,SecondActivity::class.java)
                intent.putExtra("URL", urlUsed)
                intent.putExtra("EMAIL", emailUsed)
                intent.putExtra("MESSAGE", msgUsed)
                startActivity(intent)
            }
        }

        }
}
package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var tvURL = findViewById<TextView>(R.id.tvURL)
        var tvEmail = findViewById<TextView>(R.id.tvEmail)
        var tvMessage = findViewById<TextView>(R.id.tvMessage)
        var btnURL = findViewById<TextView>(R.id.btnURL)
        var btnURLMessage = findViewById<TextView>(R.id.btnEmailMessage)


        val url = intent.getStringExtra("URL")
        val email = intent.getStringExtra("EMAIL")
        val message = intent.getStringExtra("MESSAGE")

        tvURL.text = "URL LINK: $url"
        tvEmail.text = "Email: $email"
        tvMessage.text = "Message: $message"

        btnURL.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }

        btnURLMessage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Its all about Android")
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose an Email client :"))
        }
    }
}
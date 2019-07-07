package com.flytxt.mainactivity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Success : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        //Get data from intent
        var intent = intent
        val name = intent.getStringExtra("Email")
        val token = intent.getStringExtra("Token")

        //TextView
        val resultTv = findViewById<TextView>(R.id.resultTv)

        //setText
        resultTv.text = "Email : $name\nToken : $token"
    }
}

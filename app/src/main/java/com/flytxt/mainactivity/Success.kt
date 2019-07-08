package com.flytxt.mainactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Success : AppCompatActivity() {
    lateinit var session: SessionManager

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        session  = SessionManager(applicationContext)

        /*
        //Get data from intent
        val intent = intent
        val name = intent.getStringExtra("Email")
        val token = intent.getStringExtra("Token")
        */

        //TextView
        val resultTv = findViewById<TextView>(R.id.resultTv)
        val outBtn = findViewById<Button>(R.id.logout)

        session.checkLogin()

        val user: HashMap<String,String> = session.getUserDetails()

        val email: String = user[SessionManager.KEY_EMAIL]!!
        val token: String = user[SessionManager.KEY_TOKEN]!!

        //setText
        resultTv.text = "Email : $email\nToken : $token"

        outBtn.setOnClickListener{
            session.logoutUser(this)
        }

    }
}

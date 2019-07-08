package com.flytxt.mainactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        session = SessionManager(applicationContext)
        if (session.isLoggedIn())
        {
            var i = Intent(applicationContext,Success::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }

        //Get text from EditText
        val emailEt = findViewById<EditText>(R.id.email101)
        val otp = findViewById<EditText>(R.id.OAuth)
        val subBtn = findViewById<Button>(R.id.submit)

        showRegistration()

        subBtn.setOnClickListener {
            val email = emailEt.text.toString()

            if (email.trim().isNotEmpty() && isEmailValid(email))
            {
                email101.isEnabled = false
                OAuth.visibility = View.VISIBLE
                subBtn.setOnClickListener {
                    val auth = otp.text.toString()

                    if (auth.trim().isNotEmpty()) {
                        //Intent to start activity
                        session.createLoginSession(email, auth)
                        val intent = Intent(this, Success::class.java)

                        intent.putExtra("Email", email)
                        intent.putExtra("Token", auth)

                        startActivity(intent)
                        finish()
                    }

                    else
                    {
                        Toast.makeText(this,"No Credentials...\n Enter OTP",Toast.LENGTH_LONG).show()
                    }
                }
            }

            else
            {
                Toast.makeText(this,"Invalid Credentials.\n Please enter Email",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showRegistration(){
        OAuth.visibility=View.GONE
    }

    private fun isEmailValid(email:String):Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

}

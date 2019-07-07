package com.flytxt.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get text from EditText
        val emailEt = findViewById<EditText>(R.id.email)
        val otp = findViewById<EditText>(R.id.OAuth)
        val subBtn = findViewById<Button>(R.id.submit)

        showRegistration()

        subBtn.setOnClickListener {
            email.isEnabled=false
            val email = emailEt.text.toString()

            OAuth.visibility=View.VISIBLE

            subBtn.setOnClickListener {
                val auth = otp.text.toString()

                //Intent to start activity
                val intent = Intent(this,Success::class.java)

                intent.putExtra("Email",email)
                intent.putExtra("Token",auth)

                startActivity(intent)
            }
        }
    }

    private fun showRegistration(){
        OAuth.visibility=View.GONE
    }

    /*
    private fun isEmailValid(email:String):Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
    */

}

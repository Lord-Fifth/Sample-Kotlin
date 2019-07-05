package com.flytxt.mainactivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showRegistration()

        submit.setOnClickListener {
            OAuth.visibility=View.VISIBLE
            submit.setOnClickListener {
                val intent = Intent(this,Success::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showRegistration(){
        OAuth.visibility=View.GONE
    }

}

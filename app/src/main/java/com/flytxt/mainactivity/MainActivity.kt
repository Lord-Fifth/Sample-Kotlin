package com.flytxt.mainactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showRegistration()

        register.setOnClickListener {
            showAuthorisation()
        }

    }

    private fun showRegistration(){
        authorise_layout.visibility=View.GONE
        start_101.visibility=View.VISIBLE
    }

    private fun showAuthorisation(){
        authorise_layout.visibility=View.VISIBLE
        start_101.visibility=View.VISIBLE
    }
}

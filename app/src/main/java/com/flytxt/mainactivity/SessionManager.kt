package com.flytxt.mainactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.provider.ContactsContract
import kotlin.jvm.internal.PropertyReference0Impl

class SessionManager {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con: Context
    var PRIVATE_MODE: Int = 0

    constructor(con: Context) {
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object {
        val PREF_NAME: String = "Kotlin_Sample"
        val IS_LOGIN: String = "isLoggedIn"
        val KEY_EMAIL: String = "email"
        val KEY_TOKEN: String = "token"
    }

    fun createLoginSession(email: String,token: String)
    {
        editor.putBoolean(IS_LOGIN,true)
        editor.putString(KEY_EMAIL,email)
        editor.putString(KEY_TOKEN,token)
        editor.commit()
    }

    fun checkLogin()
    {
        if (!this.isLoggedIn())
        {
            var i = Intent(con,MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(i)
        }
    }

    fun getUserDetails(): HashMap<String,String>
    {
        var user: Map<String,String> = HashMap<String,String>()
        (user as HashMap).put(KEY_EMAIL, pref.getString(KEY_EMAIL,null).toString())
        (user as HashMap).put(KEY_TOKEN, pref.getString(KEY_TOKEN,null).toString())
        return user
    }

    fun logoutUser(activity: Activity)
    {
        editor.clear()
        editor.commit()

        var i = Intent(activity,MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        activity.startActivity(i)
        activity.finish()
    }

    fun isLoggedIn(): Boolean
    {
        return pref.getBoolean(IS_LOGIN,false)
    }
}
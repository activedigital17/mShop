package com.aplantas.mshop.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aplantas.mshop.R
import com.aplantas.mshop.utilities.FullScreenMode
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        FullScreenMode.enableFullScreen(this)
        backButton()

        tv_login.setOnClickListener {

            val intent = Intent(this@RegisterActivity, LoginActivity::class.java )
            startActivity(intent)
        }

    }




    //kreiramo back tipku koja nas vraća nazad
    private fun backButton(){

        //postavljamo da se toolbar ponaša kao action bar
        setSupportActionBar(toolbar_register_activity)

        //postaljvamo actionBar
        val actionBar = supportActionBar
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_keyboard_backspace_24)
        }

        toolbar_register_activity.setNavigationOnClickListener { onBackPressed() }
    }



}
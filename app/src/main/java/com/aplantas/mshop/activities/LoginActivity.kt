package com.aplantas.mshop.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplantas.mshop.R
import com.aplantas.mshop.utilities.FullScreenMode
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //TODO napraviti options menu gdje se može upaliti/ugasiti Fullscreen

        FullScreenMode.enableFullScreen(this)

        tv_register.setOnClickListener {

            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}
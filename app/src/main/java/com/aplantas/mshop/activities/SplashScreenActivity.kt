package com.aplantas.mshop.activities

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import com.aplantas.mshop.R
import com.aplantas.mshop.utilities.FullScreenMode

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        FullScreenMode.enableFullScreen(this)


        //hidea bottom navigation bar na splash screenu -> nepotreban je
        @Suppress("DEPRECATION")
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }


        //TODO napraviti posebnu klasu za postavljanje full screena +


        //handler koji čeka 2 sekunde te sa splash screena prebacuje na mainActivity
        @Suppress("DEPRECATION")
        Handler().postDelayed({
            //definira se koji Activity se pali, package Context = this odnosno aktivan activity
            startActivity(Intent(this, LoginActivity::class.java))

            //ubija splash screen da se ne može back na njega napraviti
            finish()
        }, 3000)




    }


}
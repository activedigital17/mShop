package com.aplantas.mshop.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import com.aplantas.mshop.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        //TODO napraviti posebnu klasu za postavljanje full screena

        //uklanjamo status bar tj stavljamo activity na full screen i supresa deprecirani kod odnosno fullscreen flag
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }



        //handler koji čeka 2 sekunde te sa splash screena prebacuje na mainActivity

        @Suppress("DEPRECATION")
        Handler().postDelayed({
            //definira se koji Activity se pali, package Context = this odnosno aktivan activity
            startActivity(Intent(this, MainActivity::class.java))

            //ubija splash screen da se ne može back na njega napraviti
            finish()
        }, 3000)




    }


}
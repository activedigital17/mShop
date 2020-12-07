package com.aplantas.mshop.utilities

import android.app.Activity
import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager

class FullScreenMode {

    //static objekt (singleton) koji će se moći koristiti u cijeloj aplikaciji za enable fullscreena
    companion object {
        //uklanjamo status bar tj stavljamo activity na full screen i supresa deprecirani kod odnosno fullscreen flag
        fun enableFullScreen(currentActivity: Activity){
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                currentActivity.window.insetsController?.hide(WindowInsets.Type.statusBars())
            } else {
                currentActivity.window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )

            }
        }
    }
}
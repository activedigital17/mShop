package com.aplantas.mshop.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplantas.mshop.R
import com.aplantas.mshop.utilities.FullScreenMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FullScreenMode.enableFullScreen(this)
    }
}
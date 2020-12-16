package com.aplantas.mshop.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.aplantas.mshop.R
import com.google.android.material.snackbar.Snackbar

open class HelperActivity : AppCompatActivity() {



    fun showErrorSnackBar(message: String, errorMessage: Boolean) {

        val snackBar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)

        val snackBarView = snackBar.view


        if (errorMessage) {
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSnackBarError))

        } else {
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSnackBarSuccess))

        }


        snackBar.show()
    }
}


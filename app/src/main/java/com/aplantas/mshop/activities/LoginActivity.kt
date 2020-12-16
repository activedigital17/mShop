package com.aplantas.mshop.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.constraintlayout.solver.widgets.Helper
import com.aplantas.mshop.R
import com.aplantas.mshop.utilities.FullScreenMode
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : HelperActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //TODO napraviti options menu gdje se može upaliti/ugasiti Fullscreen

        FullScreenMode.enableFullScreen(this)

        btn_login.setOnClickListener {


            loginRegisteredUser()

        }

        tv_register.setOnClickListener {

            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    private fun validateLoginDetails():Boolean {

        return when{
            TextUtils.isEmpty(input_email.text.toString().trim {it <=' '})->{
                showErrorSnackBar("Unesi email!", true)
                false
            }
            TextUtils.isEmpty(input_password.text.toString().trim {it <=' '})->{
                showErrorSnackBar("Unesi lozinku!", true)
                false
            }else ->{
                true
            }

        }


    }

    private fun loginRegisteredUser(){

        if (validateLoginDetails()){


            val email = input_email.text.toString().trim{it<=' '}
            val password = input_password.text.toString().trim { it<=' ' }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener { task->


                if (task.isSuccessful){

                    //TODO dodati dialog koji se vrti

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else {
                    showErrorSnackBar("Korisničko ime ili lozinka nisu ispravni", true)
                }
            }


        }








    }
}
package com.aplantas.mshop.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aplantas.mshop.R
import com.aplantas.mshop.firestore.FirestoreClass
import com.aplantas.mshop.models.User
import com.aplantas.mshop.utilities.FullScreenMode
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


//register activity nasljeđuje helper klasu kako bi mogao koristiti funkciju za snackbar
class RegisterActivity : HelperActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        FullScreenMode.enableFullScreen(this)
        backButton()



        btn_register.setOnClickListener {

            validateRegisterDetails()

        }


        tv_login.setOnClickListener {
            onBackPressed()
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


    //validacija input forme
    private fun validateRegisterDetails(): Boolean {
        return when {
            TextUtils.isEmpty(et_first_name.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_first_name), true)
                false
            }

            TextUtils.isEmpty(et_last_name.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_last_name), true)
                false
            }

            TextUtils.isEmpty(et_email.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(et_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }

            TextUtils.isEmpty(et_confirm_password.text.toString().trim { it <= ' ' }) -> {

                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }

            et_password.text.toString().trim { it <= ' ' } != et_confirm_password.text.toString()
                    .trim { it <= ' ' } -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_and_confirm_password_mismatch), true)
                false
            }
            else -> {

                if (et_password.length()<=6){
                    showErrorSnackBar("Lozinka mora veća od 5 znakova", true)
                }else{

                    registration()
                }

                true
            }
        }
    }

    private fun registration() {

        val email = et_email.text.toString()
        val password = et_password.text.toString()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                        val firebaseUser:FirebaseUser=task.result!!.user!!

                        val user = User(
                            firebaseUser.uid,
                            et_first_name.text.toString().trim{it<=' '},
                            et_last_name.text.toString().trim{it<=' '},
                            et_email.text.toString().trim{it<=' '}
                        )

                        FirestoreClass().registerUser(this@RegisterActivity,user)


                        //FirebaseAuth.getInstance().signOut()
                        //finish()

                    } else {

                        //TODO dodati error u sluačju ako je pass manji od 6 znakoava i email nije u ispravnom formatu
                            //TODO dodati dialog for async tasks

                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }

                }

    }

    fun userRegistresionSuccess(){

        Toast.makeText(this,"Uspješno ste registrirani!", Toast.LENGTH_SHORT).show()
    }


}
package com.aplantas.mshop.firestore

import android.util.Log
import com.aplantas.mshop.activities.RegisterActivity
import com.aplantas.mshop.models.User
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirestoreClass {

    private val db = Firebase.firestore

    fun registerUser(activity:RegisterActivity, userInfo:User){

        db.collection("users")
            .document(userInfo.id)
            .set(userInfo, SetOptions.merge())
            .addOnCompleteListener {
                activity.userRegistresionSuccess()
            }.addOnFailureListener { e->Log.e(activity.javaClass.simpleName, "Greška u registraciji", e) }



    }


}
package com.gaston.jose.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gaston.jose.data.User
import com.google.firebase.firestore.FirebaseFirestore

/**
 * Created by Gastón Saillén on 22 November 2019
 */
class Dao {

    fun postUserToFirebase(nombre:String,numero:Int):LiveData<Boolean>{
        val data = MutableLiveData<Boolean>()
        val user = User(nombre,numero)
        FirebaseFirestore.getInstance()
            .collection("usuario")
            .add(user)
            .addOnSuccessListener {
                data.value = true
            }.addOnFailureListener {
                data.value = false
            }
        return data
    }

}
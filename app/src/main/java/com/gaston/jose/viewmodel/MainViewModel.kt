package com.gaston.jose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaston.jose.repository.Dao

/**
 * Created by Gastón Saillén on 22 November 2019
 */
class MainViewModel: ViewModel() {

    private val dao = Dao()
    fun postData(nombre:String,numero:Int):LiveData<Boolean>{
        val dataPosted = MutableLiveData<Boolean>()
        dao.postUserToFirebase(nombre,numero).observeForever { resultado ->
            dataPosted.value = resultado
        }
        return dataPosted
    }

}
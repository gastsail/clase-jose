package com.gaston.jose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gaston.jose.R
import com.gaston.jose.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        obtenerDatos()
    }

    fun showProgress(){
        progressBar.visibility = View.VISIBLE
        btn_enviar.isEnabled = false
    }

    fun hideProgress(){
        progressBar.visibility = View.GONE
        btn_enviar.isEnabled = true
    }

    fun obtenerDatos(){

        toastbtn.setOnClickListener {
            Toast.makeText(this,"Datos ingresados correctamente",Toast.LENGTH_SHORT).show()
        }

        btn_enviar.setOnClickListener {
            showProgress()
            val nombre = etxt_nombre.text.toString().trim()
            val numero = etxt_telefono.text.toString()
            if(nombre.isNotEmpty()){
                viewModel.postData(nombre,numero.toInt()).observe(this, Observer {
                    if(it){
                        hideProgress()
                        Toast.makeText(this,"Datos ingresados correctamente",Toast.LENGTH_SHORT).show()
                    }else{
                        hideProgress()
                        Toast.makeText(this,"No se pudo ingresar los datos",Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}

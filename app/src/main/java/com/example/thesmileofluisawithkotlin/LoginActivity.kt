package com.example.thesmileofluisawithkotlin

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnCall : Button = findViewById(R.id.btnCall)

        btnLogin.setOnClickListener {

            signUp()
        }

        btnCall.setOnClickListener {

            callPhone()
        }
    }

    fun signUp() {

        val etName: EditText = findViewById(R.id.etName)
        val etPassword: EditText = findViewById(R.id.etPasswd)

        var userName: String = etName.text.toString()
        var userPassword: String = etPassword.text.toString()


        if (userName.equals("usuario") && userPassword.equals("usuario++")) {

            val intent = Intent(this, MainActivity::class.java).apply {

            }
            startActivity(intent)

        } else if (userName.equals("invitado") && userPassword.equals("invitado++")) {
            val intent = Intent(this, MainActivity::class.java).apply {


            }
            startActivity(intent)
        } else if (userName.isEmpty()) {
            etName.setError("Campo vacío")

        } else if (userPassword.isEmpty()) {
            etPassword.setError("Campo vacío")

        } else {
            val alertDialog : AlertDialog = let {
                val builder = AlertDialog.Builder(it)

                builder.apply {
                    builder.setTitle("Error")
                    builder.setMessage("Usuario y contraseña incorrectos. Vuelva a intentarlo")
                    builder.setPositiveButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->
                        // clickeo del botón
                    })
                }

                builder.create()
            }

            alertDialog.show()

            etName.setError("Datos incorrectos")
            etPassword.setError("Datos incorrectos")

        }
    }

    fun callPhone() {
        val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:953602192"))
        startActivity(callIntent)
    }


}
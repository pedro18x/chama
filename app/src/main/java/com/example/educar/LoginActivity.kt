package com.example.educar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var voltarButton: Button

    private lateinit var dbHelper: CadastroDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        voltarButton = findViewById(R.id.voltarButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {

                val usuarioValido = dbHelper.buscarUsuario(username, password)

                if (usuarioValido){
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MateriasActivity::class.java)
                    startActivity(intent)
                    finish()

                } else{
                    Toast.makeText(this, "Usuário ou senha inválidos.", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        voltarButton.setOnClickListener{

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.educar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity(){

    private lateinit var loginButton: Button
    private lateinit var cadastrarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginButton = findViewById(R.id.botaoLogar)
        cadastrarButton = findViewById(R.id.botaoCadrastar)

        loginButton.setOnClickListener{

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        cadastrarButton.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}
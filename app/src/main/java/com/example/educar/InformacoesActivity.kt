package com.example.educar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InformacoesActivity : AppCompatActivity() {

    private lateinit var voltarButton: Button
    private lateinit var listarUsuariosInfoButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_informacoes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.informacoes_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        voltarButton = findViewById(R.id.voltarButton)
        listarUsuariosInfoButton = findViewById(R.id.listarUsuariosInfoButton)


        voltarButton.setOnClickListener {
            finish()
        }

        listarUsuariosInfoButton.setOnClickListener {
            val intent = Intent(this, ListarUsuariosActivity::class.java)
            startActivity(intent)
        }
    }
}
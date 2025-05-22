package com.example.educar // Certifique-se que este é o nome do seu pacote

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MateriasActivity : AppCompatActivity() {

    private lateinit var infoButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_materias) // Define o layout da tela de matérias

        // Ajusta o padding para a tela cheia
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.materias_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        infoButton = findViewById(R.id.infoButton)

        infoButton.setOnClickListener {
            // Cria um Intent para iniciar a InformacoesActivity
            val intent = Intent(this, InformacoesActivity::class.java)
            startActivity(intent)
        }
    }
}
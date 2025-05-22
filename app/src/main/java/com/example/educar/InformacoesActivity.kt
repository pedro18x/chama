package com.example.educar // Certifique-se que este é o nome do seu pacote

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InformacoesActivity : AppCompatActivity() {

    private lateinit var voltarButton: Button // Declaração do botão

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_informacoes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.informacoes_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa o botão
        voltarButton = findViewById(R.id.voltarButton)

        // Define a ação do botão de voltar
        voltarButton.setOnClickListener {
            // Maneira 1: Simplesmente finalizar a activity atual
            // Se a MateriasActivity foi a que chamou InformacoesActivity,
            // finalizar InformacoesActivity naturalmente retornará para MateriasActivity.
            finish()

            // Maneira 2: Se você quiser ser explícito ou se a pilha de atividades for complexa (opcional aqui)
            // val intent = Intent(this, MateriasActivity::class.java)
            // intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Limpa atividades no topo da pilha até MateriasActivity
            // startActivity(intent)
            // finish() // Finaliza a InformacoesActivity
        }
    }
}
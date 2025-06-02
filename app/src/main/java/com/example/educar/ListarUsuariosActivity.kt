package com.example.educar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListarUsuariosActivity : AppCompatActivity() {

    private lateinit var usuariosTextView: TextView
    private lateinit var voltarListarButton: Button
    private lateinit var idExcluirEditText: EditText
    private lateinit var excluirUsuarioButton: Button
    private lateinit var dbHelper: CadastroDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listar_usuarios)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listar_usuarios_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usuariosTextView = findViewById(R.id.usuariosTextView)
        voltarListarButton = findViewById(R.id.voltarListarButton)
        idExcluirEditText = findViewById(R.id.idExcluirEditText)
        excluirUsuarioButton = findViewById(R.id.excluirUsuarioButton)
        dbHelper = CadastroDBHelper(this)

        voltarListarButton.setOnClickListener {
            finish()
        }

        excluirUsuarioButton.setOnClickListener {
            val idText = idExcluirEditText.text.toString()
            if (idText.isNotEmpty()) {
                try {
                    val id = idText.toInt()
                    if (dbHelper.excluir(id)) {
                        Toast.makeText(this, "Usuário excluído com sucesso!", Toast.LENGTH_SHORT).show()
                        idExcluirEditText.text.clear()
                        carregarUsuarios() // Atualiza a lista
                    } else {
                        Toast.makeText(this, "Erro ao excluir usuário. ID não encontrado?", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor, insira um ID numérico válido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, digite o ID do usuário a ser excluído.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        carregarUsuarios()
    }

    private fun carregarUsuarios() {
        val listaUsuarios = dbHelper.listar()
        if (listaUsuarios.isNotEmpty()) {
            usuariosTextView.text = listaUsuarios.joinToString(separator = "\n\n")
        } else {
            usuariosTextView.text = "Nenhum usuário cadastrado."
        }
    }
} 
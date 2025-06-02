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


class CadastroActivity : AppCompatActivity() {

    private lateinit var voltarButton: Button
    private lateinit var nomeCompleto: EditText
    private lateinit var numeroMatricula: EditText
    private lateinit var curso: EditText
    private lateinit var nomeUsuario: EditText
    private lateinit var senha: EditText
    private lateinit var cadastroooButton: Button

    private lateinit var dbHelper: CadastroDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cadastro_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        dbHelper = CadastroDBHelper(this)
    voltarButton = findViewById(R.id.voltarButton)
    nomeCompleto = findViewById(R.id.nomeCompleto)
    numeroMatricula = findViewById(R.id.numeroMatricula)
    curso = findViewById(R.id.curso)
    nomeUsuario = findViewById(R.id.nomeUsuario)
    senha = findViewById(R.id.senha)
    cadastroooButton = findViewById(R.id.cadastroooButton)

    cadastroooButton.setOnClickListener {
        val nome = nomeCompleto.text.toString()
        val matricula = numeroMatricula.text.toString()
        val cursoo = curso.text.toString()
        val usuario = nomeUsuario.text.toString()
        val password = senha.text.toString()

        if(nome.isNotEmpty() && matricula.isNotEmpty() && cursoo.isNotEmpty() && usuario.isNotEmpty() && password.isNotEmpty()){

            val sucessoIncercao = dbHelper.inserir(
                nome_completo = nome,
                numero_matricula = matricula,
                curso = cursoo,
                nome_usuario = usuario,
                senha = password
            )

            if (sucessoIncercao){
                Toast.makeText(this, "Cadastro bem-sucedido!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(this, "Erro no cadastro. O nome de usuário já existe ou outro problema ocorreu.", Toast.LENGTH_LONG).show()
            }

        } else{
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
        }
     }
        voltarButton.setOnClickListener{

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
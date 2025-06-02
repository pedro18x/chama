package com.example.educar

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val TABLE_ALUNO = "Aluno"
const val COLUMN_NOME_USUARIO = "nome_usuario"
const val COLUMN_SENHA = "senha"

class CadastroDBHelper(context: Context): SQLiteOpenHelper(context, "EducarDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_ALUNO(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nome_completo TEXT," +
                " numero_matricula TEXT," +
                " curso TEXT," +
                " nome_usuario TEXT UNIQUE," +
                " senha TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Aluno")
        onCreate(db)
    }

    fun inserir(nome_completo: String, numero_matricula: String, curso: String, nome_usuario: String, senha: String): Boolean{
        val db = writableDatabase
        val valores = ContentValues().apply {
            put("nome_completo", nome_completo)
            put("numero_matricula", numero_matricula)
            put("curso", curso)
            put("nome_usuario", nome_usuario)
            put("senha", senha)
        }
        return db.insert("Aluno", null, valores) != -1L
    }

    fun listar(): List<String>{
        val lista = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM  Aluno", null)
        if (cursor.moveToFirst()){
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val nome_completo = cursor.getString(cursor.getColumnIndexOrThrow("nome_completo"))
                val numero_matricula = cursor.getInt(cursor.getColumnIndexOrThrow("numero_matricula"))
                val curso = cursor.getString(cursor.getColumnIndexOrThrow("curso"))
                val nome_usuario = cursor.getString(cursor.getColumnIndexOrThrow("nome_usuario"))
                val senha = cursor.getString(cursor.getColumnIndexOrThrow("senha"))
                lista.add("ID: $id - $nome_completo - $numero_matricula - $curso - $nome_usuario - $senha") //olhar dps essa linha, n sei se ta certo
            }while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lista
    }

    fun atualizar(id: Int, novoNomeCompleto: String, novoNumeroMatricula: String, novoCurso: String,
                  novoNomeUsuario: String, novaSenha: String): Boolean{
        val db = writableDatabase
        val valores = ContentValues().apply {
            put("nome_completo", novoNomeCompleto)
            put("numero_matricula", novoNumeroMatricula)
            put("curso", novoCurso)
            put("nome_usuario", novoNomeUsuario)
            put("senha", novaSenha)
        }
        val linhasAfetadas = db.update("Aluno", valores, "id = ?", arrayOf(id.toString()))
        db.close()
        return linhasAfetadas > 0
    }

    fun excluir(id: Int): Boolean{
        val db = writableDatabase
        val linhasAfetadas = db.delete("Aluno", "id = ?", arrayOf(toString()))
        db.close()
        return linhasAfetadas > 0
    }

    fun buscarUsuario(nome_usuario: String, senha: String): Boolean {
        val db = this.readableDatabase
        var usuarioEncontrado = false
        val query = "SELECT * FROM $TABLE_ALUNO WHERE $COLUMN_NOME_USUARIO = ? AND $COLUMN_SENHA = ?"
        val cursor = db.rawQuery(query, arrayOf(nome_usuario, senha))

        if (cursor.moveToFirst()) {
            usuarioEncontrado = true
        }
        cursor.close()
        db.close()
        return usuarioEncontrado
    }
}
package br.com.digitalhouse.desafiowebservice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafiowebservice.R
import br.com.digitalhouse.desafiowebservice.helper.AsteriskPasswordTransformationMethod
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.inputPassword

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        inputPassword.transformationMethod =
            AsteriskPasswordTransformationMethod()

        btnFinalizaCadastro.setOnClickListener {
            startActivity(Intent(this, ComicsListActivity::class.java))
        }
    }
}
package com.example.matheus_v_pereira.nutritech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CadastrarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_usuario);
        setTitle("Fazer Cadastro");

        //BOTAO CADASTRAR
        Button btn = (Button) findViewById(R.id.cadastro_btn_confirmar);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //FAZER METODO PARA CHECAR SE EMAIL JA NAO ESTA CADASTRADO
                //FAZER METODO PARA SALVAR DADOS NO BANCO
                //MENSAGEM EM CASO DE SUCESSO
                Toast.makeText(getApplicationContext(), "Cadastro criado", Toast.LENGTH_LONG).show();
                finish(); //finaliza activity
            }
        });
    }
}

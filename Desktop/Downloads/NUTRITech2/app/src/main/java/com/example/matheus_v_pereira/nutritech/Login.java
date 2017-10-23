package com.example.matheus_v_pereira.nutritech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Button mEmailSignInButton = (Button) findViewById(R.id.login_btn_sign_in);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button cadastrar = (Button) findViewById(R.id.login_btn_sign_on);
        cadastrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, CadastrarUsuario.class);
                startActivity(intent);
            }
        });

        Button btn = (Button) findViewById(R.id.recuperarsenha);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, RecuperarSenha.class);
                startActivity(intent);
            }
        });


    }

}
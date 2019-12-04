package com.example.checklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {


    private TextView nomeMenu;
    private Button botaoNovaLista;
    private Button botaoSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nomeMenu = findViewById(R.id.txt_menu_nome_id);
        botaoNovaLista = findViewById(R.id.btn_novalista_id);
        botaoSair = findViewById(R.id.btn_sair_id);

        nomeMenu.setText("Leandro");


        botaoNovaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), ListagemProdutosActivity.class));
            }
        });

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });


    }
}

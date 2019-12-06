package com.example.checklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuActivity extends AppCompatActivity {


    private TextView nomeMenu;
    private Button botaoNovaLista;
    private Button botaoSair;
    private Button botaoHistorico;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    private String nomeBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nomeMenu = findViewById(R.id.txt_menu_nome_id);
        botaoNovaLista = findViewById(R.id.btn_novalista_id);
        botaoSair = findViewById(R.id.btn_sair_id);
        botaoHistorico = findViewById(R.id.btn_vizualizar_historico);

        referencia.child("usuarios").child("001").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                nomeMenu.setText(dataSnapshot.child("nome").getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //nomeMenu.setText(nomeBanco);

        botaoHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HistoricoActivity.class));
            }
        });


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

package com.example.checklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CadastroActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    private Button cadastrarBtn;
    private EditText nomeCadastro;
    private EditText telefoneCadastro;
    private EditText emailCadastro;
    private EditText senhaCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cadastrarBtn = findViewById(R.id.btn_cadastrar_id);
        nomeCadastro = findViewById(R.id.txt_nome_cad_id);
        telefoneCadastro = findViewById(R.id.txt_telefone_cad_id);
        emailCadastro = findViewById(R.id.txt_email_cad_id);
        senhaCadastro = findViewById(R.id.txt_senha_cad_id);

        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference usuarios = referencia.child( "usuarios" );

                    Usuario usuario = new Usuario();

                    usuario.setNome(nomeCadastro.getText().toString());
                    usuario.setTelefone(telefoneCadastro.getText().toString());
                    usuario.setEmail(emailCadastro.getText().toString());
                    usuario.setSenha(senhaCadastro.getText().toString());

                    usuarios.child("001").setValue( usuario );

                    Toast.makeText(CadastroActivity.this, "Cadastro Realizado com sucesso", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();


            }
        });
    }
}

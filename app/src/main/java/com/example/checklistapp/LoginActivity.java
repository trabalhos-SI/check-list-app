package com.example.checklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    private EditText loginCampo;
    private EditText senhaCampo;
    private Button botaoEntrar;

    private String usuarioBuscado;
    private String senhaBuscada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginCampo = findViewById(R.id.txt_login_id);
        senhaCampo = findViewById(R.id.txt_senha_id);
        botaoEntrar = findViewById(R.id.btn_entrar_id);


        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Usuario usuario = new Usuario();
                usuario.setEmail(loginCampo.getText().toString());
                usuario.setSenha(senhaCampo.getText().toString());



                //usuarioBuscado = referencia.child("usuarios").child("001").getKey("email");

                referencia.child("usuarios").child("001").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        usuarioBuscado = dataSnapshot.child("email").getValue().toString();
                        senhaBuscada = dataSnapshot.child("senha").getValue().toString();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                if(usuario.getEmail().equals(usuarioBuscado) && usuario.getSenha().equals(senhaBuscada)){

                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Usuário não encontrado", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

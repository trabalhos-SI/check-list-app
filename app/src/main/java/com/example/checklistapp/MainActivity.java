package com.example.checklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button comecarBtn;
    private Button iniciarBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comecarBtn = findViewById(R.id.btn_comecar_id);
        iniciarBtn = findViewById(R.id.btn_iniciar_id);

        comecarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
                finish();
            }
        });

        iniciarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });


    }
}

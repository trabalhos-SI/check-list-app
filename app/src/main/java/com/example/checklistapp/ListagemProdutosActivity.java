package com.example.checklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class ListagemProdutosActivity extends AppCompatActivity {

    ListAdapter dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_produtos);


        displaylistView();

    }

    private  void displaylistView()
    {
        ArrayList<Produtos> produtosList = new ArrayList<Produtos>();

        // Produtos mercado extra
        Produtos produtos = new Produtos(1, "veja spray", 10.99, "limpeza", "extra", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "sabonete dove", 3.50, "limpeza", "extra", false);
    }
}

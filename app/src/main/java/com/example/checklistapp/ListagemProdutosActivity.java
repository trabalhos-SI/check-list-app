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

        //Produtos mercado extra
        Produtos produtos = new Produtos(1, "veja spray", 10.99, "limpeza", "extra", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "sabonete dove", 3.50, "limpeza", "extra", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "detergente", 4.50, "limpeza", "extra", false);
        produtosList.add(produtos);

        produtos = new Produtos(1, "vinho", 6.50, "bebida", "extra", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "cerveja", 2.50, "bebida", "extra", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "energetico", 7.50, "bebida", "extra", false);
        produtosList.add(produtos);

        produtos = new Produtos(1, "arroz", 6.50, "alimento", "extra", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "feijao", 2.50, "alimento", "extra", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "carne", 27.50, "alimento", "extra", false);
        produtosList.add(produtos);

        ///////// OUTRO MERCADO

        produtos = new Produtos(1, "veja spray", 7.49, "limpeza", "carrefour", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "sabonete dove", 2.80, "limpeza", "carrefour", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "detergente", 6.20, "limpeza", "carrefour", false);
        produtosList.add(produtos);

        produtos = new Produtos(1, "vinho", 8.49, "bebida", "carrefour", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "cerveja", 1.40, "bebida", "carrefour", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "energetico", 5.40, "bebida", "carrefour", false);
        produtosList.add(produtos);

        produtos = new Produtos(1, "arroz", 9.50, "alimento", "carrefour", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "feijao", 3.00, "alimento", "carrefour", false);
        produtosList.add(produtos);
        produtos = new Produtos(1, "carne", 19.90, "alimento", "carrefour", false);
        produtosList.add(produtos);

        ///////// OUTRO MERCADO

        //dataAdapter = new ListAdapter(this, R.layout.activity_listagem_produtos, produtosList);



    }
}

package com.example.checklistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListagemProdutosActivity extends AppCompatActivity {

    //ListAdapter dataAdapter = null;
    MyCustomAdapter dataAdapter = null;
    ArrayList<Produtos> produtosList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        displaylistView();
        checkButtonClick();

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

        dataAdapter = new MyCustomAdapter(this, R.layout.content_main, produtosList);

        ListView listView = (ListView) findViewById(R.id.listView1);

        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produtos produto = (Produtos) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), "clique na linha " + produto.getNome(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Produtos>{

        private ArrayList<Produtos> produtosList;

            public MyCustomAdapter(Context context, int textviewResourceid, ArrayList<Produtos> produtoList){

                super(context, textviewResourceid, produtoList);
                this.produtosList = new ArrayList<Produtos>();
                this.produtosList.addAll(produtoList);
            }
    }

    private class ViewHolder{

        TextView code;
        CheckBox name;

    }

    //@NonNull
    //@Override
    public View getView (int position, View convertView, ViewGroup parent) {
        //return getView(position, convertView, parent);

        ViewHolder holder = null;

        //Log.v("convertView", String.valueOf(position));

        if(convertView == null){

            LayoutInflater  vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.content_main, null);

            holder = new ViewHolder();
            holder.code = (TextView) convertView.findViewById(R.id.code);
            holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);

            convertView.setTag(holder);

            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CheckBox cb = (CheckBox) v;
                    Produtos produto = (Produtos) cb.getTag();
                    Toast.makeText(getApplicationContext(), "cricou no check " + cb.getText(), Toast.LENGTH_SHORT).show();

                    produto.setSelecionado(cb.isChecked());

                }
            });

        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        Produtos produto = produtosList.get(position);
        holder.code.setText(" (" + produto.getId() +  ") ");
        holder.name.setText(produto.getNome());
        holder.name.setChecked(produto.isSelecionado());

        holder.name.setTag(produto);

        return convertView;

    }

    public void checkButtonClick(){

        Button Mybutton = (Button) findViewById(R.id.findselected);

        Mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("Itens selecionados.. \n");

                ArrayList<Produtos> produtoList = dataAdapter.produtosList;

                for(int i = 0; i < produtoList.size(); i++){

                    Produtos produto = produtoList.get(i);

                    if(produto.isSelecionado()){
                        responseText.append("\n" + produto.getNome());
                    }
                }

                Toast.makeText(getApplicationContext(), responseText, Toast.LENGTH_SHORT).show();



            }
        });
    }
}


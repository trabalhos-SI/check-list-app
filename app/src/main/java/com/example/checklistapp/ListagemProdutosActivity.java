package com.example.checklistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.SparseBooleanArray;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;

public class ListagemProdutosActivity extends AppCompatActivity {

    ListView myList;
    Button getChoice, clearAll;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyChoice" ;
    ArrayList<String> selectedItems = new ArrayList<String>();

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    public static int valor = 001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        myList = (ListView)findViewById(R.id.list);
        getChoice = (Button)findViewById(R.id.getchoice);
        clearAll = (Button)findViewById(R.id.clearall);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, getResources().getStringArray(R.array.Indian_States));
        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        myList.setAdapter(adapter);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(sharedpreferences.contains(MyPREFERENCES)){
            LoadSelections();
        }

        getChoice.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                String selected = "";
                int cntChoice = myList.getCount();

                ArrayList<String> produtos = new ArrayList<String>();

                produtos = null;

                SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();

                referencia.child("compras").removeValue();

                for(int i = 0; i < cntChoice; i++){
                    if(sparseBooleanArray.get(i)) {
                        selected += myList.getItemAtPosition(i).toString() + "\n";
                        //System.out.println("checar lista:" + myList.getItemAtPosition(i).toString());
                        SaveSelections();

                        //produtos.add(myList.getItemAtPosition(i).toString());

                        referencia.child("compras").child(Integer.toString(valor)).setValue(myList.getItemAtPosition(i).toString());
                        valor++;


                    }

                }

                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                AbrirAlerta();

            }});

        clearAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ClearSelections();
            }
        });


    }

    public void AbrirAlerta(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Sucesso");
        dialog.setMessage("Lista feita com sucesso.");

        dialog.setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                finish();
            }
        });

        dialog.create();
        dialog.show();
    }

    private void SaveSelections() {

        SharedPreferences.Editor prefEditor = sharedpreferences.edit();
        String savedItems = getSavedItems();
        prefEditor.putString(MyPREFERENCES.toString(), savedItems);
        prefEditor.commit();
    }

    private String getSavedItems() {
        String savedItems = "";
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.myList.isItemChecked(i)) {
                if (savedItems.length() > 0) {
                    savedItems += "," + this.myList.getItemAtPosition(i);
                } else {
                    savedItems += this.myList.getItemAtPosition(i);
                }
            }
        }
        return savedItems;
    }

    private void LoadSelections() {

        if (sharedpreferences.contains(MyPREFERENCES.toString())) {

            String savedItems = sharedpreferences.getString(MyPREFERENCES.toString(), "");
            selectedItems.addAll(Arrays.asList(savedItems.split(",")));

            int count = this.myList.getAdapter().getCount();

            for (int i = 0; i < count; i++) {
                String currentItem = (String) myList.getAdapter()
                        .getItem(i);
                if (selectedItems.contains(currentItem)) {
                    myList.setItemChecked(i, true);
                    Toast.makeText(getApplicationContext(),
                            "Ultima Lista: " + currentItem,
                            Toast.LENGTH_LONG).show();
                } else {
                    myList.setItemChecked(i, false);
                }

            }
        }
    }

    private void ClearSelections() {
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            this.myList.setItemChecked(i, false);
        }
        SaveSelections();
    }


}


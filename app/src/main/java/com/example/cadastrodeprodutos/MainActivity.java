package com.example.cadastrodeprodutos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.cadastrodeprodutos.BDHelper.ProdutosBd;
import com.example.cadastrodeprodutos.model.Produtos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ProdutosBd bdHelper;
    ArrayList<Produtos> listview_produtos;
    Produtos produto;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listview_produtos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Produtos produtoEscolhido = (Produtos) adapter.getItemAtPosition(position);

                Intent i = new  Intent(MainActivity.this, FormularioProdutos.class);
                i.putExtra("produto-escolhido", produtoEscolhido);
            }
        });

        Button btnCadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormularioProdutos.class);
                startActivity(intent);
            }
        });
    }

    public void onResume() {
        super.onResume();
        carregarProdutos();
    }

     public void carregarProdutos() {
        bdHelper = new ProdutosBd(MainActivity.this);
        listview_produtos = bdHelper.getLista();
        bdHelper.close();

        if(listview_produtos != null) {
            adapter = new ArrayAdapter<Produtos>(MainActivity.this, android.R.layout.simple_list_item_1, listview_produtos);
            lista.setAdapter(adapter);
        }
        //finish();
     }
}
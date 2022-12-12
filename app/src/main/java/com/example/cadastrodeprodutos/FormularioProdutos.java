package com.example.cadastrodeprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadastrodeprodutos.model.Produtos;

public class FormularioProdutos extends AppCompatActivity {

    EditText editTextNomeProduto, editTextdescricaoProduto, editTextquantidade;
    Button btn_poliform;
    Produtos editarProduto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produtos);

        Intent intent = getIntent();
        editarProduto = (Produtos) intent.getSerializableExtra("produto-escolhido");


        editTextNomeProduto = (EditText) findViewById(R.id.editTextNomeProduto);
        editTextdescricaoProduto = (EditText) findViewById(R.id.editTextDescricao);
        editTextquantidade = (EditText) findViewById(R.id.editTextQuantidade);
        btn_poliform = (Button) findViewById(R.id.btn_poliform);

        if (editarProduto != null) {
            btn_poliform.setText("Modificar");
        } else {
            btn_poliform.setText("Cadastrar");
        }


    }
}
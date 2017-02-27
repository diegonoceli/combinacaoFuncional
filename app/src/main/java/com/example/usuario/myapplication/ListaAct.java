package com.example.usuario.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaAct extends AppCompatActivity {
    int escolha;
    private ArrayList<String> lista = new ArrayList<>();
    String resp1, resp2, resp3, resp4, qualquer;
    String[] vet0 = new String[4];
    String[] vet1 = new String[4];
    String[] vet2 = new String[4];
    String[] vet3 = new String[4];
    private Button btn;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaact);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        btn = (Button) findViewById(R.id.btnvolta);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (bd != null) {
            qualquer = (String) bd.get("escolha");
            escolha = Integer.valueOf(qualquer);

            resp1 = (String) bd.get("resp1");
            resp2 = (String) bd.get("resp2");
            resp3 = (String) bd.get("resp3");
            resp4 = (String) bd.get("resp4");


        }

        listView = (ListView) findViewById(R.id.lista);
        arrayAdapter = new ArrayAdapter<String>(ListaAct.this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);
        JogaNoVetor();

    }

    private void JogaNoVetor() {
        if (escolha == 0) {
            vet0 = new String[]{resp1, resp2, resp3};
            vet1 = vet0;
            vet2 = vet0;
            JogaAlgor(3);

        } else {
            vet0 = new String[]{resp1, resp2, resp3, resp4};
            vet1 = vet0;
            vet2 = vet0;
            vet3 = vet0;
            JogaAlgor(4);
        }


    }

    private void JogaAlgor(int tam) {
        int cont=1;
        for (int i = 0; i < tam; i++)
            for (int j = 0; j < tam; j++)
                for (int k = 0; k < tam; k++)
                    if (tam == 3) {

                            if (i != j && i != k && k != j) {
                                lista.add(cont+".     "+ vet0[i] + vet1[j] + vet2[k]);
                                cont++;
                            }
                        } else {
                        for (int l = 0; l < tam; l++) {
                            if (i != j && i != k && k != j && l != i && l != k && l != j) {

                                lista.add(cont+".     "+vet0[i] + vet1[j] + vet2[k] + vet3[l]);
                                cont++;
                            }
                        }
                    }
    }

}

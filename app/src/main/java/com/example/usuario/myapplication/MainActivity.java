package com.example.usuario.myapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ArrayList<String> list=new ArrayList<>();
    private EditText edt1, edt2, edt3, edt4;
    private Spinner spinner;
    private int escolha;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);
        edt4 = (EditText) findViewById(R.id.edt4);
        spinner= (Spinner) findViewById(R.id.spinner);
        list.add("3");
        list.add("4");
        arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,list);
        spinner.setAdapter(arrayAdapter);
        VerificaSpinner();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty()==false){
                    Toast.makeText(MainActivity.this,"Existem campos em branco",Toast.LENGTH_LONG).show();
                }else {

                    MudaPage();
                }
            }
        });




    }


    private boolean isEmpty() {
        if (escolha == 0) {
            if ("".equals(edt1.getText().toString()) || "".equals(edt2.getText().toString()) || "".equals(edt3.getText().toString())) {

            return false;
            }else {
                return true;
            }

        } else {
            if ("".equals(edt1.getText().toString()) || "".equals(edt2.getText().toString()) || "".equals(edt3.getText().toString()) || "".equals(edt4.getText().toString())) {
            return false;
            }else{
                return true;
            }

        }
    }

    private void MudaPage(){
        Intent i = new Intent(MainActivity.this, ListaAct.class);
        if(escolha==0){
            i.putExtra("resp1", edt1.getText().toString());
            i.putExtra("resp2", edt2.getText().toString());
            i.putExtra("resp3", edt3.getText().toString());
            i.putExtra("escolha", String.valueOf(escolha));
            startActivity(i);


        }else{
            i.putExtra("resp1", edt1.getText().toString());
            i.putExtra("resp2", edt2.getText().toString());
            i.putExtra("resp3", edt3.getText().toString());
            i.putExtra("resp4", edt4.getText().toString());
            i.putExtra("escolha", String.valueOf(escolha));
            startActivity(i);

        }



    }

    private void VerificaSpinner(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    escolha=parent.getSelectedItemPosition();
                if(escolha==0){
                    edt4.setVisibility(EditText.GONE);

                }else {
                    edt4.setVisibility(EditText.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(0);
                parent.getSelectedItem().toString();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_name) {
            Intent i = new Intent(MainActivity.this,
                    About.class);
            startActivity(i);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}

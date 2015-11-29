package com.example.christopher.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Comprar extends AppCompatActivity {

    EditText txtNombre;
    EditText txtApellido;
    EditText txtDNI;
    Spinner spMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        Spinner lista;
        final String[] datos = {"TOYOTA", "HONDA", "HYUNDAI", "BMW"};
        lista = (Spinner) findViewById(R.id.spMarca);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datos);
        lista.setAdapter(adaptador);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtDNI = (EditText) findViewById(R.id.txtDNI);
        spMarca = (Spinner) findViewById(R.id.spMarca);
        final ImageView  ImageView1 = (ImageView) findViewById(R.id.ImageView1);


        spMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (spMarca.getSelectedItemPosition() == 0) {
                    ImageView1.setImageResource(R.drawable.toyota1);
                } else if (spMarca.getSelectedItemPosition() == 1) {
                    ImageView1.setImageResource(R.drawable.honda1);
                } else if (spMarca.getSelectedItemPosition() == 2) {
                    ImageView1.setImageResource(R.drawable.hyundai1);
                } else if (spMarca.getSelectedItemPosition() == 3) {
                    ImageView1.setImageResource(R.drawable.bmw1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_comprar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void comprar (View view) {
        DatabaseManager dbHandler = new DatabaseManager(this);

        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String marca = spMarca.getSelectedItem().toString();

        if(!(nombre.equals("") || apellido.equals("") || txtDNI.getText().toString().equals(""))){
            int dni = Integer.parseInt(txtDNI.getText().toString());
            Carro carro = new Carro(nombre, apellido, dni, marca);
            dbHandler.comprar1(carro);
            txtNombre.setText("");
            txtApellido.setText("");
            txtDNI.setText("");
            Toast.makeText(Comprar.this, "COMPRA REALIZADA", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(Comprar.this, "FALTA INGRESAR DATOS", Toast.LENGTH_LONG).show();
        }
    }

    public void cancelar(View view){
        Comprar.this.finish();
    }
}
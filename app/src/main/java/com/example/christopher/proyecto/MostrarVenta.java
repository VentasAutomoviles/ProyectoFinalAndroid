package com.example.christopher.proyecto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MostrarVenta extends AppCompatActivity {

    long carroId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_venta);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            carroId = extras.getLong("id");
            DatabaseManager dbMgr = new DatabaseManager(this);
            Carro carro = dbMgr.mostrarVenta(carroId);
            if (carro != null) {
                ((TextView) findViewById(R.id.tvNombre1)).setText(carro.get_nombre());
                ((TextView) findViewById(R.id.tvApellido1)).setText(carro.get_apellido());
                ((TextView) findViewById(R.id.tvDNI1)).setText(String.valueOf(carro.get_dni()));
                ((TextView) findViewById(R.id.tvMarca1)).setText(carro.get_marca());
            } else {
                Log.d("db", "contact null");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_venta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_eliminar:
                eliminarVenta();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void eliminarVenta() {
        new AlertDialog.Builder(this).setTitle("POR FAVOR CONFIRMAR").setMessage("¿ELIMINAR ESTA COMPRA?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        DatabaseManager dbMgr = new DatabaseManager(getApplicationContext());
                        dbMgr.eliminarVenta(carroId);
                        dialog.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}

package com.example.christopher.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NamesFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_comprar:
                startActivity(new Intent(this, Comprar.class));
                return true;
            case R.id.action_ventas:
                startActivity(new Intent(this, Ventas.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //@Override
    public void onItemSelected(String id) {
        DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.FragmentDetails);
        details.showDetails(id);
    }
}

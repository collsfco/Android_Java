package com.collsfco.asteroides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar= findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
    }

    /**
     * Método para llamar a la vista de información
     * @param view
     */

    public void ejecutarInformacion(View view){
        Intent i= new Intent(this,InfoClase.class); //Indicamos la actividad hacia la cual queremos ir.
        startActivity(i);

    }

    /**
     * Método para salir de la app.
     * @param view
     */

    public void exitApp(View view){

        finish();
    }

    //Menú superior de la aplicación.

    /**
     * Hacer el menú visible.
     * @param miMenu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu miMenu){

        getMenuInflater().inflate(R.menu.menu_en_activity, miMenu);
        return true;
    }

    /**
     * Identificamos cuál item es seleccionado
     * @param opcion_menu
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();

        if (id==R.id.configuracion){
            return true;
        }
        if (id==R.id.info){
            ejecutarInformacion(null);
            return true;

        }

        return super.onOptionsItemSelected(opcion_menu); // llamamos al metodo de la clase padre y le pasamos el item de menu

    }


}
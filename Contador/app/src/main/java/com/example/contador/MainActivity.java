package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public int contador;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoResultado=(TextView)findViewById(R.id.txvMuestraNumero);
        contador=0;

        EventoTeclado teclado= new EventoTeclado();
        EditText numResetListener=(EditText) findViewById(R.id.etxNumReset); //Almacenamos la vista etxNumReset
        numResetListener.setOnEditorActionListener(teclado); //Ponemos a la escucha la varible numResetListener.



    }

    //Creamos una clase interna en la cual implementamos la interfaz TextView.OnEditorActionListener.
    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        //onEditorAction metodo de la interfaz.
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
            if(actionId== EditorInfo.IME_ACTION_DONE) { // IME_ACTION_DONE = 6;
                resetContador(null);//pasamos null como parametro para no enviar ninguna vista
            }
            return false;
        }
    }

    public void incrementaContador (View vista){

        contador++;
        textoResultado.setText(""+contador);

    }

    public void decrementaContador (View vista){

        contador--;
        if (contador<0){
            CheckBox negativos =(CheckBox) findViewById(R.id.ckbNegativos);
            if(!negativos.isChecked()){
                contador=0;
            }
        }
        textoResultado.setText(""+contador);

    }

    public void resetContador (View vista){

        EditText numeroReset=(EditText) findViewById(R.id.etxNumReset);
        if(numeroReset.getText().toString().isEmpty()){
            // contador=0;
            contador=Integer.parseInt(numeroReset.getHint().toString());// getHint obtenemos el valor de hint en este caso 0
        }
        else{
            contador= Integer.parseInt(numeroReset.getText().toString()); //getText() devuelve un objeto de tipo Editable.
        }
        numeroReset.setText("");
        textoResultado.setText(""+contador);
        //Ocultar teclado luego de presionar Reset.
        InputMethodManager miTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        miTeclado.hideSoftInputFromWindow(numeroReset.getWindowToken(),0);


    }


}
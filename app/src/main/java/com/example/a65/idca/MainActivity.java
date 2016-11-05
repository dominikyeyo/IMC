package com.example.a65.idca;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

       //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btn_calcular);

    }

    public void calcularIMC(View view) {

        Log.d(TAG, "Entra a calcular IMC con el click");

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        EditText editTextAltura = (EditText) findViewById(R.id.editTextCentimetros);
        EditText editTextPeso = (EditText) findViewById(R.id.editTextKiloGramos);

        String altura = editTextAltura.getText().toString();
        String peso = editTextPeso.getText().toString();

        if(altura.isEmpty() && peso.isEmpty()) return;
        if(altura.matches("\\d+") && peso.matches("\\d+")){

            float cm = Integer.valueOf(altura);
            float kg = Integer.valueOf(peso);

            calcular(cm, kg);


        }

    }

    private void calcular(float cm, float kg ){

        cm = (cm/100);
        float bmi = kg / (cm * cm);

        String resultado;

        if(bmi < 16){
            resultado = "Tu BMI" + bmi + "( severamente bajo )";
        }else if(bmi < 18.5){
            resultado = "Tu BMI" + bmi + "( bajo )";
        }else if(bmi < 25){
            resultado = "Tu BMI" + bmi + "( normal )";
        }else if(bmi < 30){
            resultado = "Tu BMI" + bmi + "( sobrepeso )";
        }else {
            resultado = "Tu BMI" + bmi + "( Obeso )";
        }

        Log.i(TAG,"resultado" + resultado);

        textViewResult.setText( resultado );

    }

    /*@Override
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}

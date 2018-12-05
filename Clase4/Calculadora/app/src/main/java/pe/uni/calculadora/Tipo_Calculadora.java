package pe.uni.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tipo_Calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo__calculadora);
    }

    public void estandar(View view){
        Intent _standar = new Intent(this,Estandar.class);
        startActivity(_standar);
    }
    public void cientifica(View view){
        Intent _cientifica = new Intent(this,Cientifica.class);
        startActivity(_cientifica);
    }
}

package pe.uni.aplicacionventanas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPantalla = (TextView) findViewById(R.id.tvPantalla);
    }
    public void digito(View view){
        Button b = (Button) view;
        String _digito = b.getText().toString();
        String resultado = tvPantalla.getText().toString() + _digito;
        tvPantalla.setText(resultado);
    }
    public void borrar(View view){
        tvPantalla.setText("");
    }
    public void par(View view){
        String numeroText = tvPantalla.getText().toString();
        int numero = Integer.parseInt(numeroText);
        if (numero % 2 == 0){
            tvPantalla.setText("Es Par");
        }else{
            tvPantalla.setText("Es Impar");
        }
    }
}

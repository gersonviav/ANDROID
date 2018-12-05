package com.example.gerson.myapplication9;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Game extends AppCompatActivity {
    private ImageView imgOvni;
    private Button btnDerecha;
    private Button btnIzquierda;
    private Button btnArriba;
    private Button btnAbajo;
    private boolean altoDerecha;
    private boolean altoIzquierda;
    private boolean altoArriba;
    private boolean altoAbajo;
    private double anchoPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Enlazando variables
        imgOvni=(ImageView)findViewById(R.id.imgOvni);
        btnDerecha=(Button) findViewById(R.id.btnDerecha);
        btnIzquierda=(Button) findViewById(R.id.btnIzquierda);
        btnArriba=(Button) findViewById(R.id.btnArriba);
        btnAbajo=(Button) findViewById(R.id.btnAbajo);
        btnDerecha.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        altoDerecha=false;
                        Derecha(v);
                        return true;
                    case MotionEvent.ACTION_UP:
                        altoDerecha=true;
                        return true;
                }
                return false;
            }
        });
        btnIzquierda.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        altoIzquierda=false;
                        Izquierda(v);
                        return true;
                    case MotionEvent.ACTION_UP:
                        altoIzquierda=true;
                        return true;
                }
                return false;
            }
        });
        btnArriba.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        altoArriba=false;
                        Arriba(v);
                        return true;
                    case MotionEvent.ACTION_UP:
                        altoArriba=true;
                        return true;
                }
                return false;
            }
        });
        btnAbajo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        altoAbajo=false;
                        Abajo(v);
                        return true;
                    case MotionEvent.ACTION_UP:
                        altoAbajo=true;
                        return true;
                }
                return false;
            }
        });

        //Calcula el ancho de la pantalla unidades dp
        double anchodp=this.getResources().getConfiguration().screenWidthDp;
//Calcula la densidad que usaremos para convertir a pixeles
        double densidad=this.getResources().getDisplayMetrics().density;
//Convierte a pixeles
        anchoPantalla=anchodp*densidad;

    }
    public void Derecha(View view){
        final Handler actualizar=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if (altoDerecha==false) {
                 if(imgOvni.getX()<=anchoPantalla)
                    imgOvni.setX(imgOvni.getX() + 25);
                 else
                   imgOvni.setX(-imgOvni.getWidth());
                    actualizar.postDelayed(this, 200);

                }
            }
        };
        actualizar.postDelayed(runnable,0000);
    }
    public void Izquierda(View view){
        final Handler actualizar=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if (altoIzquierda==false)
                    imgOvni.setX(imgOvni.getX()-25);
                actualizar.postDelayed(this, 200);
            }
        };
        actualizar.postDelayed(runnable,0000);
    }
    public void Arriba(View view){
        final Handler actualizar=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if (altoArriba==false)
                    imgOvni.setY(imgOvni.getY()-25);
                actualizar.postDelayed(this, 200);
            }
        };
        actualizar.postDelayed(runnable,0000);
    }

    public void Abajo(View view){
        final Handler actualizar=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if (altoAbajo==false)
                    imgOvni.setY(imgOvni.getY()+25);
                actualizar.postDelayed(this, 200);
            }
        };
        actualizar.postDelayed(runnable,0000);
    }
}



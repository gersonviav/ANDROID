package com.example.gerson.carrochocones;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class CarroChocones extends AppCompatActivity {
    private ImageView imgCoche;
    private ImageView imgEdificio;
    private Button btnDerecha;
    private ImageView imgRoca;
    private EditText ptRi;
    private EditText ptdec;
    private EditText ptAng;
    private  int ancho=120;
    //private double altop=0;
    //private double anchop=0;
  private  double q=0;
  private  double w=0;
    private  int alto=100;
   private Button btnIzquierda;
    private Button btnArriba;
    private boolean disparo;
          private double g=9.8;
          private  double t=0;
    private Button btnLanzar;
    private boolean altoDerecha;
    private boolean altoIzquierda;
    private boolean altoArriba;
    private boolean altoAbajo;
    private double anchoPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_chocones);
        //Enlazando variables
        imgCoche=(ImageView)findViewById(R.id.imgCoche);
        ptAng=(EditText) findViewById(R.id.ptAng);
        ptdec=(EditText)findViewById(R.id.ptdec);
        ptRi=(EditText) findViewById(R.id.ptRi);
        imgRoca=(ImageView)findViewById(R.id.imgPiedra);
        imgEdificio=(ImageView)findViewById(R.id.imgEdificio);
        btnDerecha=(Button) findViewById(R.id.btnDerecha);
        btnIzquierda=(Button) findViewById(R.id.btnIzquierda);
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
        //Calcula el ancho de la pantalla unidades dp
        double anchodp=this.getResources().getConfiguration().screenWidthDp;
//Calcula la densidad que usaremos para convertir a pixeles
        double densidad=this.getResources().getDisplayMetrics().density;
//Convierte a pixeles
      //  imgEdificio.getHeight();
        anchoPantalla=anchodp*densidad;
        System.out.println(anchoPantalla);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ancho, alto);
        //imgCoche.setLayoutParams(params);
    }

    public  void anchoImagen (View view){
        ancho = imgCoche.getWidth();
      //  tvMensaje.setText(String.valueOf(ancho));
    }
    public void alturaImagen(View view){
        alto = imgCoche.getHeight();
        //tvMensaje.setText(String.valueOf(altura));
    }
    public void Derecha(View view){
        final Handler actualizar=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if (altoDerecha==false) {
                    if(imgCoche.getX()<=anchoPantalla)
                    {  q=imgCoche.getX()+5;
                        imgCoche.setX(imgCoche.getX() + 5);}
                    else
                        imgCoche.setX(-imgCoche.getWidth());
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
                if (altoIzquierda==false){
                  if (imgCoche.getX()>0)
                  { w=imgCoche.getX()+5;
                    imgCoche.setX(imgCoche.getX()-5);

                  }
                }
                actualizar.postDelayed(this, 200);
            }
        };
        actualizar.postDelayed(runnable,0000);
    }

    public  void  posicion(View v){
        final double pos=Double.parseDouble(ptdec.getText().toString());
        imgCoche.setX(imgEdificio.getWidth()+(float)pos);
    }
    public void Disparar(View view){
        final float posmis=imgRoca.getY();
        Random rand = new Random();

        final double te=0.2 + ( 1 -  0.2) * rand.nextDouble();

        double te2=Math.toDegrees(te);
        //System.out.println("helo");
        //angulo sexa
        System.out.println(te2);
      //  System.out.println(Math.cos(90));
        //Double.parseDouble(ptAng.getText().toString());
         String  tes=""+te2;
        //angulo
           ptAng.setText(tes);
           final double x=imgEdificio.getWidth()+Double.parseDouble(ptdec.getText().toString());
     //   System.out.println(x);
   //     System.out.println("asd");
        System.out.println(imgCoche.getY());
                 double m=(x/Math.cos(te));
                 double b=   Math.abs((Math.tan(te)*x)-imgCoche.getY());

                 double n=Math.sqrt(g/(2*b));

        System.out.println("///");
       // System.out.println(b);
        ///System.out.println(m);
        //System.out.println(g);
        //System.out.println(n);
        //System.out.println("//");
           final double ri=(m*n);
             String ris=""+ri;
            //  ri= Double.parseDouble(ptRi.getText().toString());
                          ptRi.setText(ris);
        disparo=true;
        //   imgCoche.setX(imgEdificio.getWidth()+(float)pos);
        final Handler actualizar=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                imgRoca.setX((float) x);
               imgRoca.setY(imgCoche.getY());
                if (imgRoca.getY()<-300){
                    imgRoca.setY(posmis);
                    disparo=false;
                }
               /* if (disparo==true) {
                    actualizar.postDelayed(this, 10);
                }*/
            }
        };
        actualizar.postDelayed(runnable,300);
    }

}

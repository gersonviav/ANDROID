package pe.uni.clase5juego;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivOvni;
    private ImageView ivMisil;
    private TextView tvMensaje;
    private double anchop=0;
    private  int ancho=0;
    private double altop=0;
    private  int altura=0;
    private int n = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivOvni = (ImageView) findViewById(R.id.imvOvni);
        ivMisil = (ImageView) findViewById(R.id.imgMisil);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);

    }
    public void derecha(View view){
        if(ivOvni.getX()<anchop -ancho) ivOvni.setX(ivOvni.getX()+50);
    }
    public void izquierda(View view){
        if (ivOvni.getX()>0) ivOvni.setX(ivOvni.getX()-50);
    }

    public void abajo(View view){

        ivOvni.setY(ivOvni.getY()+50);
    }

    public void arriba(View view){
        if(ivOvni.getY()>0) ivOvni.setY(ivOvni.getY()-50);
    }
    public void anchoPantalla(View view){
        double anchodp = this.getResources().getConfiguration().screenWidthDp;
        double densidad = this.getResources().getDisplayMetrics().density;
        anchop = anchodp * densidad;
        tvMensaje.setText(String.valueOf(anchop));
    }
    public void altoPantalla(View view){
        double altodp = this.getResources().getConfiguration().screenHeightDp;
        double densidad = this.getResources().getDisplayMetrics().density;
       altop = altodp * densidad;
        tvMensaje.setText(String.valueOf(altop));
    }
    public  void anchoImagen (View view){
       ancho = ivOvni.getWidth();
        tvMensaje.setText(String.valueOf(ancho));
    }
    public void alturaImagen(View view){
        altura = ivOvni.getHeight();
        tvMensaje.setText(String.valueOf(altura));
    }
    public void mueveOvni(View view){
        final Handler actualizar = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(ivOvni.getX()<= anchop -ancho){
                    ivOvni.setX(ivOvni.getX()+25);

                }else {
                    ivOvni.setX(0);
                }
                actualizar.postDelayed(this,50);
            }
        };
        actualizar.postDelayed(runnable,50);

    }

    public void disparar(View view){
       final  float posmis = ivMisil.getY();
        n=1;
        final Handler actualizar = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ivMisil.setY(ivMisil.getY()-25);
                hayColision();
                if(ivMisil.getY()<-1000){
                    ivMisil.setY(posmis);
                    n = 0;
                }
                if(n==1) actualizar.postDelayed(this,20);
            }
        };
        actualizar.postDelayed(runnable,20);

    }
    public boolean interseccionY(){
        if(ivOvni.getY()+altura > ivMisil.getY() &&  -ivMisil.getHeight() +  ivOvni.getY()< ivMisil.getY()) return true;
        return false;
    }
    public boolean interseccionX(){
        if(ivOvni.getX()+ancho>  ivMisil.getX() && ivOvni.getX()-ivMisil.getWidth()/2 <ivMisil.getX() ) return true;
        return false;
    }
    public void hayColision(){
        if (interseccionY() && interseccionX()) tvMensaje.setText("Choco");
        return;
    }
}

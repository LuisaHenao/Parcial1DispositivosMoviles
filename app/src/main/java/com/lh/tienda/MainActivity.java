package com.lh.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import id.ionbit.ionalert.IonAlert;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnCrear;
    private Button btnVer;
    private Button btnCostos;
    private Button btnMenos;
    private Button btnPromedio;
    RegistrarProductos registrarPersona = new RegistrarProductos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btnCrear);
        btnVer = findViewById(R.id.btnVer);
        btnCostos = findViewById(R.id.btnCostos);
        btnMenos = findViewById(R.id.btnMenos);
        btnPromedio = findViewById(R.id.btnPromedio);

        btnCrear.setOnClickListener(this);
        btnVer.setOnClickListener(this);
        btnCostos.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnPromedio.setOnClickListener(this);

    }

    public int obtenerValorPromedio(List<Productos> productos){
        int suma = 0;
        int cant = 0;
        int promedio = 0;
        for (int i=0; i<productos.size(); i++) {
            suma += productos.get(i).getValorProducto();
            cant +=1;
        }
        promedio = suma/cant;
        return promedio;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCrear){
            Intent Myintent = new Intent(this, RegistrarProductos.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnVer  ){
           Intent Myintent = new Intent(this, MostrarProductos.class );

          startActivity(Myintent);
        }
        if ( v.getId() == R.id.btnCostos  ){

            Intent Myintent = new Intent(this, ProductosCostosos.class );
            startActivity(Myintent);

        }
        if (v.getId() == R.id.btnMenos   ){
            Intent Myintent = new Intent(this, ProductosMenos.class );
            startActivity(Myintent);
        }
        if (v.getId() == R.id.btnPromedio   ){


            new IonAlert(this, IonAlert.SUCCESS_TYPE)
                    .setTitleText("Valor promedio de los productos")
                    .setContentText(String.valueOf(obtenerValorPromedio(RegistrarProductos.productos)))
                    .show();

        }
    }

}
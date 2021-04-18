package com.lh.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ib.custom.toast.CustomToastView;
import com.omarshehe.forminputkotlin.FormInputText;

import java.util.ArrayList;
import java.util.List;

public class RegistrarProductos extends AppCompatActivity implements View.OnClickListener {
    private FormInputText txtNombre;
    private FormInputText txtValor;
    private FormInputText txtExencion;
    private FormInputText txtCategoria;
    private Button btnRegistrar;
    private Button btnRegresar;
    public  static List<Productos> productos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_productos);
        txtNombre = findViewById(R.id.txtNombre);
        txtValor = findViewById(R.id.txtValor);
        txtExencion = findViewById(R.id.txtExencion);
        txtCategoria = findViewById(R.id.txtCategoria);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(this);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistrar){
            String nombre = txtNombre.getValue();
            int valor = Integer.parseInt(txtValor.getValue());
            String excencion = txtExencion.getValue();
            String categoria = txtCategoria.getValue();

            Productos producto = new Productos((int) (Math.random() * 10),nombre, valor, excencion, categoria);
            productos.add(producto);
            CustomToastView.makeSuccessToast(this, "Se a creado un nuevo producto ", R.layout.custom_toast).show();



        }

        /*if (v.getId() == R.id.btnRegresar){
            Intent Myintent = new Intent(this, MainActivity.class );
            startActivity(Myintent);

        }*/
    }
}
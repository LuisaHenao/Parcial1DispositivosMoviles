package com.lh.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MostrarProductos extends AppCompatActivity {
    private TextView tvProduc;
    RegistrarProductos registrarPersona = new RegistrarProductos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_productos);
        tvProduc = findViewById(R.id.tvProduc);
        tvProduc.setText(mostrarProductos(registrarPersona.productos));
    }

    public String mostrarProductos(List<Productos> productos){
        String datos= " ";

        for (int i=0; i<productos.size(); i++){
            datos += "Codigo Producto: "+productos.get(i).getCodigoProducto()+ "Producto: "+productos.get(i).getNombreProducto() +" Valor producto: "+ productos.get(i).getValorProducto()+" Categoria: "+productos.get(i).getCategoria()+" Exencion: "+productos.get(i).getExecionIva()+  "\n";
        }
        return datos;
    }
}
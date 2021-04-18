package com.lh.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductosMenos extends AppCompatActivity {
    private TextView tvProdMenos;
    RegistrarProductos registrarPersona = new RegistrarProductos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_menos);
        tvProdMenos = findViewById(R.id.tvProdMenos);
        tvProdMenos.setText(mostrarProductosMenos(obtenerProductosMenos(registrarPersona.productos)));
    }

    public List<Productos> obtenerProductosMenos(List<Productos> productos){
        List<Productos> productosCostos = new ArrayList<>();
        List<Integer> valorProd = new ArrayList<>();
        for(int i=0; i<productos.size(); i++){
            valorProd.add(productos.get(i).getValorProducto());
        }
        Collections.sort(valorProd);

        for(int i=0; i<productos.size(); i++){
            for (int j=0; j<productos.size(); j++){
                if(productos.get(j).getValorProducto() == valorProd.get(i)){
                    Productos productonvo = new Productos(productos.get(j).getCodigoProducto(), productos.get(j).getNombreProducto(),productos.get(j).getValorProducto(), productos.get(j).getExecionIva(), productos.get(j).getCategoria());
                    productosCostos.add(productonvo);
                }
            }

        }
        return productosCostos;

    }

    public String mostrarProductosMenos(List<Productos> productos){
        String datos= " ";
        int finFor = 10;


        if(productos.size()<10){
            finFor = productos.size();
        }
        for (int i=0; i<finFor; i++){
            datos += (i+1)+".Producto: "+productos.get(i).getNombreProducto() +" Valor producto: "+ productos.get(i).getValorProducto()+"\n";
        }
        return datos;
    }
}
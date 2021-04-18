package com.lh.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductosCostosos extends AppCompatActivity {
    private TextView tvProducCostosos;
    RegistrarProductos registrarPersona = new RegistrarProductos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_costosos);
        tvProducCostosos = findViewById(R.id.tvProducCostosos);
       tvProducCostosos.setText(mostrarProductosCostos(obtenerProductosCostos(registrarPersona.productos)));
       // tvProducCostosos.setText(mostrarProductosCostos(registrarPersona.productos));

    }

    public List<Productos> obtenerProductosCostos(List<Productos> productos){
        List<Productos> productosCostos = new ArrayList<>();
        List<Integer> valorProd = new ArrayList<>();
        for(int i=0; i<productos.size(); i++){
            valorProd.add(productos.get(i).getValorProducto());
        }
        Collections.sort(valorProd, Collections.reverseOrder());

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

    public String mostrarProductosCostos(List<Productos> productos){
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
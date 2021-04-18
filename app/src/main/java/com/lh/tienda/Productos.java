package com.lh.tienda;

public class Productos {
    private int codigoProducto;
    private String nombreProducto;
    private int valorProducto;
    private String execionIva;
    private String categoria;

    public Productos(){

    }

    public Productos(int codigoProducto, String nombreProducto, int valorProducto, String execionIva, String categoria){
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.valorProducto = valorProducto;
        this.execionIva = execionIva;
        this.categoria = categoria;

    }
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto() {
        this.nombreProducto = nombreProducto;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }

    public String getExecionIva() {
        return execionIva;
    }

    public void setExecionIva() {
        this.execionIva = execionIva;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        this.categoria = categoria;
    }


}

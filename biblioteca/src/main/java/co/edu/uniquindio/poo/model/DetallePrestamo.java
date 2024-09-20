package co.edu.uniquindio.poo.model;

public class DetallePrestamo {
    
    private double subTotal;
    private int cantidad;
    private String nombre;

    public DetallePrestamo(String nombre ,double subTotal, int cantidad){
        this.nombre = nombre;
        this.subTotal = subTotal;
        this.cantidad = cantidad;

    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public double getSubTotal() {
        return subTotal;
    }



    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }



    public int getCantidad() {
        return cantidad;
    }



    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

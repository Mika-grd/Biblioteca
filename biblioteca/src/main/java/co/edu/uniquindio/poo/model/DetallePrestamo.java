package co.edu.uniquindio.poo.model;

public class DetallePrestamo {
    
    private String subTotal;
    private String cantidad;

    public DetallePrestamo(String subTotal, String cantidad){
        this.subTotal = subTotal;
        this.cantidad = cantidad;

    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}

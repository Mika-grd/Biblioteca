package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Bibliotecario {

    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private double salario;
    private LinkedList<Prestamo> listaPretamos;


    public Bibliotecario(String nombre, String id, String telefono, String correo, double salario){
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.listaPretamos =  new LinkedList<Prestamo>();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LinkedList<Prestamo> getListaPretamos() {
        return listaPretamos;
    }

    public void setListaPretamos(LinkedList<Prestamo> listaPretamos) {
        this.listaPretamos = listaPretamos;
    }
}

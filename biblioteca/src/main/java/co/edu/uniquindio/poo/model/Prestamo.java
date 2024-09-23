package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.HashMap;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private String codigo;
    private double total;
    private HashMap<String, DetallePrestamo> listaDetallePrestamos;
    private LinkedList<Bibliotecario> listaPrestamosBibliotecarios;
    private LinkedList<Estudiante> listaPrestamosEstudiantes;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo, double total) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.codigo = codigo;
        this.total = total;
        this.listaDetallePrestamos = new HashMap<String, DetallePrestamo>();
        this.listaPrestamosBibliotecarios = new LinkedList<Bibliotecario>();
        this.listaPrestamosEstudiantes = new LinkedList<Estudiante>();

    }

    
    // Setters & Getters :D

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LinkedList<Bibliotecario> getListaPrestamosBibliotecarios() {
        return listaPrestamosBibliotecarios;
    }

    public void setListaPrestamosBibliotecarios(LinkedList<Bibliotecario> listaPrestamosBibliotecarios) {
        this.listaPrestamosBibliotecarios = listaPrestamosBibliotecarios;
    }

    public LinkedList<Estudiante> getListaPrestamosEstudiantes() {
        return listaPrestamosEstudiantes;
    }

    public void setListaPrestamosEstudiantes(LinkedList<Estudiante> listaPrestamosEstudiantes) {
        this.listaPrestamosEstudiantes = listaPrestamosEstudiantes;
    }

    public HashMap<String, DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }

    public void setListaDetallePrestamos(HashMap<String, DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }
}

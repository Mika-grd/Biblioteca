package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private String codigo;
    private double total;
    private DetallePrestamo[] listaDetallePrestamos;
    private Bibliotecario[] listaPrestamosBibliotecarios;
    private Estudiante[] listaPrestamosEstudiantes;

    public DetallePrestamo[] getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }

    public void setListaDetallePrestamos(DetallePrestamo[] listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }

    public Bibliotecario[] getListaPrestamosBibliotecarios() {
        return listaPrestamosBibliotecarios;
    }

    public void setListaPrestamosBibliotecarios(Bibliotecario[] listaPrestamosBibliotecarios) {
        this.listaPrestamosBibliotecarios = listaPrestamosBibliotecarios;
    }

    public Estudiante[] getListaPrestamosEstudiantes() {
        return listaPrestamosEstudiantes;
    }

    public void setListaPrestamosEstudiantes(Estudiante[] listaPrestamosEstudiantes) {
        this.listaPrestamosEstudiantes = listaPrestamosEstudiantes;
    }

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo, double total){
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.codigo = codigo;
        this.total = total;

    }

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
}

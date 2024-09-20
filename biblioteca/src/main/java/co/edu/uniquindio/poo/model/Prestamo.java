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


    //CRUD DETALLES PRESTAMO :DDDDD


    /**
     * Añade un nuevo detalle de préstamo si no existe ya un detalle con el mismo
     * nombre de producto.
     * 
     * @param nombreProducto El nombre del producto.
     * @param cantidad       La cantidad del producto.
     * @param subtotal       El subtotal del producto.
     * @return Un mensaje indicando si el detalle fue añadido correctamente o si ya
     *         existía.
     */
    public String añadirDetalleProducto(String nombreProducto, int cantidad, double subtotal) {
        if (listaDetallePrestamos.containsKey(nombreProducto)) {
            return "El producto ya existe en el préstamo";
        }
        listaDetallePrestamos.put(nombreProducto, new DetallePrestamo(nombreProducto, subtotal, cantidad));
        return "Detalle del producto añadido correctamente";
    }

    /**
     * Elimina un detalle de préstamo asociado a un producto por su nombre.
     * 
     * @param nombreProducto El nombre del producto a eliminar.
     * @return Un mensaje indicando si el detalle fue eliminado correctamente o si
     *         no se encontró el producto.
     */
    public String eliminarDetalleProducto(String nombreProducto) {
        if (listaDetallePrestamos.containsKey(nombreProducto)) {
            listaDetallePrestamos.remove(nombreProducto);
            return "Detalle del producto eliminado correctamente";
        }
        return "Producto no encontrado en el préstamo";
    }

    /**
     * Busca un detalle de préstamo por el nombre del producto.
     * 
     * @param nombreProducto El nombre del producto a buscar.
     * @return El detalle de préstamo encontrado o null si no se encuentra en la
     *         lista.
     */
    public DetallePrestamo buscarDetalleProducto(String nombreProducto) {
        return listaDetallePrestamos.get(nombreProducto);
    }

    /**
     * Edita el detalle de un producto en el préstamo.
     * 
     * @param nombreProducto El nombre del producto que se desea editar.
     * @param nuevaCantidad  La nueva cantidad del producto.
     * @param nuevoSubtotal  El nuevo subtotal del producto.
     * @return Un mensaje indicando si el detalle fue editado correctamente o si no
     *         se encontró el producto.
     */
    public String editarDetalleProducto(String nombreProducto, int nuevaCantidad, double nuevoSubtotal) {
        DetallePrestamo detalle = listaDetallePrestamos.get(nombreProducto);

        if (detalle != null) {
            // Actualizamos los valores del detalle existente
            detalle.setCantidad(nuevaCantidad);
            detalle.setSubTotal(nuevoSubtotal);
            return "Detalle del producto editado correctamente";
        } else {
            return "Producto no encontrado en el préstamo";
        }
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

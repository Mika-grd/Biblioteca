package co.edu.uniquindio.poo.model;

import java.util.HashMap;
import java.util.LinkedList;

public class Biblioteca {

    private String nombre;
    private LinkedList<Bibliotecario> listaBibliotecarios;
    private LinkedList<Libro> listaLibros;
    private HashMap<String, Prestamo> listaPrestamos;
    private HashMap<String, Estudiante> listaEstudiantes;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
        this.listaLibros = new LinkedList<Libro>();
        this.listaPrestamos = new HashMap<String, Prestamo>();
        this.listaEstudiantes = new HashMap<String, Estudiante>();
        ;
    }

    // CRUD LIBRO

    /**
     * Añade un libro a la lista de libros si no existe ya.
     * 
     * @param libro El libro a añadir.
     * @return Un mensaje indicando si el libro fue añadido correctamente o si ya
     *         existía.
     */
    public String añadirLibro(Libro libro) {
        String mensaje = "El libro ya existe";
        if (!listaLibros.contains(libro)) {
            listaLibros.add(libro);
            mensaje = "Libro añadido correctamente";
        }
        return mensaje;
    }

    /**
     * Elimina un libro de la lista de libros si existe.
     * 
     * @param libro El libro a eliminar.
     * @return Un mensaje indicando si el libro fue eliminado correctamente o si no
     *         existía.
     */
    public String eliminarLibro(Libro libro) {
        String mensaje = "El libro no existe";
        if (listaLibros.contains(libro)) {
            listaLibros.remove(libro);
            mensaje = "Libro eliminado correctamente";
        }
        return mensaje;
    }

    /**
     * Busca un libro en la lista de libros.
     * 
     * @param libro El libro a buscar.
     * @return El libro encontrado o null si no se encuentra en la lista.
     */
    public Libro buscarLibro(Libro libro) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).equals(libro)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Edita un libro existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param libro      El libro actual que se desea editar.
     * @param nuevoLibro El nuevo libro con la información actualizada.
     * @return Un mensaje indicando si el libro fue encontrado y editado o no.
     */
    public String editarLibro(Libro libro, Libro nuevoLibro) {
        String mensaje = "No se encontró el libro";
        if (buscarLibro(libro) != null) {
            listaLibros.set(listaLibros.indexOf(libro), nuevoLibro);
            mensaje = "Libro editado correctamente";
        }
        return mensaje;
    }

    // CRUD BIBLIOTECARIO

    /**
     * Añade un bibliotecario a la lista si no existe ya.
     * 
     * @param bibliotecario El bibliotecario a añadir.
     * @return Un mensaje indicando si el bibliotecario fue añadido correctamente o
     *         si ya existía.
     */
    public String añadirBibliotecrio(Bibliotecario bibliotecario) {
        String mensaje = "Bibliotecario ya existe";
        if (!listaBibliotecarios.contains(bibliotecario)) {
            listaBibliotecarios.add(bibliotecario);
            mensaje = "Bibliotecario añadido correctamente";
        }
        return mensaje;
    }

    /**
     * Elimina un bibliotecario de la lista si existe.
     * 
     * @param bibliotecario El bibliotecario a eliminar.
     * @return Un mensaje indicando si el bibliotecario fue eliminado correctamente
     *         o si no existía.
     */
    public String eliminarBibliotecrio(Bibliotecario bibliotecario) {
        String mensaje = "Bibliotecario no existe";
        if (listaBibliotecarios.contains(bibliotecario)) {
            listaBibliotecarios.remove(bibliotecario);
            mensaje = "Bibliotecario eliminado correctamente";
        }

        return mensaje;
    }

    /**
     * Busca un bibliotecario en la lista.
     * 
     * @param bibliotecario El bibliotecario a buscar.
     * @return El bibliotecario encontrado o null si no se encuentra en la lista.
     */
    public Bibliotecario buscarBibliotecario(Bibliotecario bibliotecario) {
        for (int i = 0; i < listaBibliotecarios.size(); i++) {
            if (listaBibliotecarios.get(i).equals(bibliotecario)) {
                return bibliotecario;
            }
        }
        return null;
    }

    /**
     * Edita un bibliotecario existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param bibliotecario      El bibliotecario actual que se desea editar.
     * @param nuevoBibliotecario El nuevo bibliotecario con la información
     *                           actualizada.
     * @return Un mensaje indicando si el bibliotecario fue encontrado y editado o
     *         no.
     */
    public String editarBibliotecario(Bibliotecario bibliotecario, Bibliotecario nuevBibliotecario) {
        String mensaje = "No se encontró el elemento";
        if (buscarBibliotecario(bibliotecario) != null) {
            listaBibliotecarios.set(listaBibliotecarios.indexOf(bibliotecario), nuevBibliotecario);
        }
        return mensaje;
    }

    // CRUD ESTUDIANTE

    /**
     * Añade un estudiante a la lista si no existe ya.
     * 
     * @param estudiante El estudiante a añadir.
     * @return Un mensaje indicando si el estudiante fue añadido correctamente o si
     *         ya existía.
     */
    public String añadirEstudiante(Estudiante estudiante) {
        String mensaje = "Estudiante ya existe";
        if (listaEstudiantes.containsValue(estudiante) == false) {
            listaEstudiantes.put(estudiante.getId(), estudiante);
            mensaje = "Estudiante añadido exitosamente";
        }

        return mensaje;
    }

    /**
     * Elimina un estudiante de la lista si existe.
     * 
     * @param id El ID del estudiante a eliminar.
     * @return Un mensaje indicando si el estudiante fue eliminado correctamente o
     *         si no existía.
     */
    public String eliminarEstudiante(String id) {
        String mensaje = "Estudiante no existe";
        if (listaEstudiantes.get(id) != null) {
            listaEstudiantes.remove(id);
            mensaje = "Estudiante eliminado correctamente";
        }

        return mensaje;
    }

    /**
     * Busca un estudiante en la lista por su ID.
     * 
     * @param id El ID del estudiante a buscar.
     * @return El estudiante encontrado o null si no se encuentra en la lista.
     */
    public Estudiante buscarEstudianteId(String id) {
        return listaEstudiantes.get(id);
    }

    /**
     * Edita un estudiante existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param id              El ID del estudiante actual que se desea editar.
     * @param estudianteNuevo El nuevo estudiante con la información actualizada.
     * @return Un mensaje indicando si el estudiante fue encontrado y editado o no.
     */
    public String editarEstudiante(String id, Estudiante estudianteNuevo) {
        String mensaje = "No se encontró";
        if (buscarEstudianteId(id) != null) {
            listaEstudiantes.put(id, estudianteNuevo);
            mensaje = "Elemento editado correctamente";
        }
        return mensaje;
    }

    // CRUD PRESTAMO
    /**
     * Añade un préstamo a la lista si no existe ya.
     * 
     * @param prestamo El préstamo a añadir.
     * @return Un mensaje indicando si el préstamo fue añadido correctamente o si ya
     *         existía.
     */
    public String añadirPrestamo(Prestamo prestamo) {
        String mensaje = "Prestamo ya existe";
        if (!listaPrestamos.containsValue(prestamo)) {
            listaPrestamos.put(prestamo.getCodigo(), prestamo);
            mensaje = "Prestamo añadido exitosamente";
        }

        return mensaje;
    }

    /**
     * Elimina un préstamo de la lista si existe.
     * 
     * @param codigo El código del préstamo a eliminar.
     * @return Un mensaje indicando si el préstamo fue eliminado correctamente o si
     *         no existía.
     */
    public String eliminarPrestamo(String codigo) {
        String mensaje = "Prestamo no existe";
        if (listaPrestamos.get(codigo) == null) {
            listaPrestamos.remove(codigo);
            mensaje = "Prestamo eliminado correctamente";
        }

        return mensaje;
    }

    /**
     * Busca un préstamo en la lista por su código.
     * 
     * @param codigo El código del préstamo a buscar.
     * @return El préstamo encontrado o null si no se encuentra en la lista.
     */
    public Prestamo buscarPrestamoCodigo(String codigo) {
        return listaPrestamos.get(codigo);
    }

    /**
     * Edita un préstamo existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param codigo        El código del préstamo actual que se desea editar.
     * @param prestamoNuevo El nuevo préstamo con la información actualizada.
     * @return Un mensaje indicando si el préstamo fue encontrado y editado o no.
     */

    public String editarPrestamo(String codigo, Prestamo prestamoNuevo) {
        String mensaje = "No se encontró";
        if (buscarEstudianteId(codigo) != null) {
            listaPrestamos.put(codigo, prestamoNuevo);
            mensaje = "Elemento editado correctamente";
        }
        return mensaje;
    }

    // **Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(LinkedList<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public LinkedList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(LinkedList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public HashMap<String, Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(HashMap<String, Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public HashMap<String, Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(HashMap<String, Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}

package co.edu.uniquindio.poo.model;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Biblioteca {

    private String nombre;
    private Bibliotecario[] listaBibliotecarios;
    private Libro[] listaLibros;
    private Prestamo[] listaPretamos;
    private Estudiante[] listaEstudiantes;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }


    //CRUD ESTUDIANTE



    /**
     * Busca un estudiante
     * @param estudiante
     * @return
     */
    public Estudiante buscarEstudiante(Estudiante estudiante){
        for (Estudiante estudianteaux : listaEstudiantes) {
            if (estudianteaux.equals(estudiante)) {
                return estudianteaux;
            } 
        }
        return null;
    }

    /**
     * Busca posicion disponible en listaEstudiantes
     * @param lEstudiantes
     * @return
     */
    public int posDisponibleEst(Estudiante[] listaEstudiantes){
        int disponible = -1;

        for (int i = 0; i < listaEstudiantes.length; i++) {
            if (listaEstudiantes[i] != null) {
                disponible = i;
                break;
            }
        }
        return disponible;
    }


    /**
     * Crea un estudiante con JOption
     */
    public void crearEstudiante(){
        String nombre = null;
        nombre = strNotNull(nombre);
        String id = null;
        id = strNotNull(id);
        String telefono = null;
        telefono = strNotNull(telefono);
        String correo = null;
        correo = strNotNull(correo);

        Estudiante estudiante = new Estudiante(nombre, id, telefono, correo);

        String mensaje = "No se pudo añadir el contacto, es posible que no haya posicion o que ya exista el contacto";
        Estudiante estudianteEncontrado = buscarEstudiante(estudiante);
        int i = posDisponibleEst(listaEstudiantes);
        if (estudianteEncontrado == null && i >= 0) {
            listaEstudiantes[i] = estudiante;
            mensaje = "Contacto añadido exitosamente";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }



    /**
     * elimina un estudiante
     * @param estudiante
     */
    public void eliminarEstudiante(Estudiante estudiante) {
        String mensaje = "No se pudo eliminar el contacto porque no se encontró en la lista";
        for (int index = 0; index < listaEstudiantes.length; index++) {
            if (listaEstudiantes[index] != null) {
                if (listaEstudiantes[index].equals(estudiante)) {
                    listaEstudiantes[index] = null;
                    mensaje = "Contacto eliminado exitosamente";
                }
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }


    /**
     * Edita un espacio de la listaEstudiantes, borra el estudiante existente y permite ingresarlo de nuevo
     * @param estudiante
     */
    public void editarEstudiante(Estudiante estudiante){
        String mensaje = "Estudiante no encontrado";
        Estudiante estudianteaux = buscarEstudiante(estudiante);
        if (estudianteaux != null) {
            eliminarEstudiante(estudiante);
            crearEstudiante();
            mensaje = "Estudiante editado exitosamente";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }





    //CRUD BIBLIOTECARIO 


    /**
     * buscar bibliotecario en listaBibliotecario
     * @param bibliotecario
     * @return
     */
    public Bibliotecario buscarBibliotecario(Bibliotecario bibliotecario) {
        for (Bibliotecario biblioAux : listaBibliotecarios) {
            if (biblioAux != null && biblioAux.equals(bibliotecario)) {
                return biblioAux;
            }
        }
        return null;
    }

    /**
     * pos disponible en listaBibliotecario
     * @return
     */
    public int posDisponibleBibl() {
        for (int i = 0; i < listaBibliotecarios.length; i++) {
            if (listaBibliotecarios[i] == null) {
                return i;
            }
        }
        return -1; // No hay espacio disponible
    }

    /**
     * Crear bibliotecario con Joption
     */
    public void crearBibliotecario() {
        String nombre = null;
        strNotNull(nombre);
        String id = null;
        strNotNull(id);
        String telefono = null;
        strNotNull(telefono);
        String correo = null;
        strNotNull(correo);
        double salario = 0;
        salario = verifDouble(salario);

        Bibliotecario bibliotecario = new Bibliotecario(nombre, id, telefono, correo, salario);

        String mensaje = "No se pudo añadir el bibliotecario, es posible que no haya posición o que ya exista.";
        Bibliotecario bibliotecarioEncontrado = buscarBibliotecario(bibliotecario);
        int i = posDisponibleBibl();
        if (bibliotecarioEncontrado == null && i >= 0) {
            listaBibliotecarios[i] = bibliotecario;
            mensaje = "Bibliotecario añadido exitosamente.";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }


    /**
     * Eliminar bibliotecario
     * @param bibliotecario
     */
    public void eliminarBibliotecario(Bibliotecario bibliotecario) {
        String mensaje = "No se pudo eliminar el bibliotecario porque no se encontró en la lista.";
        for (int index = 0; index < listaBibliotecarios.length; index++) {
            if (listaBibliotecarios[index] != null && listaBibliotecarios[index].equals(bibliotecario)) {
                listaBibliotecarios[index] = null;
                mensaje = "Bibliotecario eliminado exitosamente.";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Editar espacio en listaBibliotecario, elimina el elemento existente y lo reescribe.
     * @param bibliotecario
     */
    public void editarBibliotecario(Bibliotecario bibliotecario) {
        String mensaje = "Bibliotecario no encontrado.";
        Bibliotecario biblioAux = buscarBibliotecario(bibliotecario);
        if (biblioAux != null) {
            eliminarBibliotecario(bibliotecario);
            crearBibliotecario();
            mensaje = "Bibliotecario editado exitosamente.";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }



    //CRUD LIBRO

    /**
     * Busca un libro en listaLibros
     * @param libro
     * @return
     */
    public Libro buscarLibro(Libro libro) {
        for (Libro libroAux : listaLibros) {
            if (libroAux != null && libroAux.equals(libro)) {
                return libroAux;
            }
        }
        return null;
    }

    /**
     * buscar pos disponible en listaLibros
     * @return
     */
    public int posDisponibleLibro() {
        for (int i = 0; i < listaLibros.length; i++) {
            if (listaLibros[i] == null) {
                return i;
            }
        }
        return -1; // No hay espacio disponible
    }

    /**
     * Crea un libro
     */
    public void crearLibro() {
        String codigo = null;
        strNotNull(codigo);
        String isbn = null;
        strNotNull(isbn);
        String autor = null;
        strNotNull(autor);
        String titulo = null;
        strNotNull(titulo);
        String editorial = null;
        strNotNull(editorial);
        int unidadesDisponibles = 0;
        unidadesDisponibles = verifInt(unidadesDisponibles);
        LocalDate fecha = null;
        fecha = verifDate(fecha);


        Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, fecha, unidadesDisponibles);

        String mensaje = "No se pudo añadir el libro, es posible que no haya posición o que ya exista.";
        Libro libroEncontrado = buscarLibro(libro);
        int i = posDisponibleLibro();
        if (libroEncontrado == null && i >= 0) {
            listaLibros[i] = libro;
            mensaje = "Libro añadido exitosamente.";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * elimina un libro
     * @param libro
     */
    public void eliminarLibro(Libro libro) {
        String mensaje = "No se pudo eliminar el libro porque no se encontró en la lista.";
        for (int index = 0; index < listaLibros.length; index++) {
            if (listaLibros[index] != null && listaLibros[index].equals(libro)) {
                listaLibros[index] = null;
                mensaje = "Libro eliminado exitosamente.";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Reescribe un elemento de listaLibros
     * @param libro
     */
    public void editarLibro(Libro libro) {
        String mensaje = "Libro no encontrado.";
        Libro libroAux = buscarLibro(libro);
        if (libroAux != null) {
            eliminarLibro(libro);
            crearLibro();
            mensaje = "Libro editado exitosamente.";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }




    //**Getters & Setters 

    public Bibliotecario[] getListaBibliotecarios() {
        return listaBibliotecarios;
    }
    public void setListaBibliotecarios(Bibliotecario[] listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }
    public Libro[] getListaLibros() {
        return listaLibros;
    }
    public void setListaLibros(Libro[] listaLibros) {
        this.listaLibros = listaLibros;
    }
    public Prestamo[] getListaPretamos() {
        return listaPretamos;
    }
    public void setListaPretamos(Prestamo[] listaPretamos) {
        this.listaPretamos = listaPretamos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Estudiante[] getListaEstudiantes() {
        return listaEstudiantes;
    }
    public void setListaEstudiantes(Estudiante[] listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }


    /**
     * metodo para solicitar y verificar un campo tipo String no esta vacio con Joption
     * @param str
     * @return
     */

    public String strNotNull(String str){

        while (true){
            str = JOptionPane.showInputDialog("Ingrese el nombre del contacto");
            // Validar si el input es null (cuando el usuario cancela) o si está vacío
            if (str == null || str.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío o ser cancelado.");
                
            }else {
                return str;
                
            }
    
            }
    }

    /**
     * metodo para solicitar y verficar que un campo tipo int sea de tipo int con Joption
     * @param n
     * @return
     */
    public int verifInt(int n){
        while (true) {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del contacto"));
                return n;
            } catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "La edad tiene que ser un numero");
        }
    }
    }

    /**
     * metodo para solicitar y verficar que un campo tipo double sea de tipo double con Joption
     * @param n
     * @return
     */
    public double verifDouble(double n){
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese un número (por ejemplo, el salario)");
                n = Double.parseDouble(input);
                return n;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "El valor tiene que ser un número válido");
            }
        }
    }

    /**
     * metodo para solicitar y verficar que un campo tipo LocalDate sea de tipo LocalDate con formato YYYY-MM-DD con Joption
     * @param fecha
     * @return
     */
    public LocalDate verifDate(LocalDate fecha){
        while (true) {
            try{
                String input = JOptionPane.showInputDialog("Ingrese la fecha de publicación (formato: YYYY-MM-DD)");
                fecha = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
                return fecha;
            } catch(DateTimeParseException dtpe){
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Asegúrese de usar YYYY-MM-DD.");
            }
        }
    }
}

package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.Bibliotecario;
import co.edu.uniquindio.poo.model.DetallePrestamo;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;

public class AppTest {

    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario1;
    private Bibliotecario bibliotecario2;
    private Estudiante estudiante1;
    private Estudiante estudiante2;
    private Libro libro1;
    private Prestamo prestamo1;

    @BeforeEach
    public void setUp() {
        // Inicializamos la biblioteca
        biblioteca = new Biblioteca("Biblioteca Central");

        // Inicializamos bibliotecarios
        bibliotecario1 = new Bibliotecario("Juan Pérez",null,null,null,0.0, LocalDate.of(2015, 1, 1));
        bibliotecario2 = new Bibliotecario("Ana Gómez",null,null,null,0.0, LocalDate.of(2020, 5, 15));

        // Añadimos bibliotecarios a la biblioteca
        biblioteca.añadirBibliotecario(bibliotecario1);
        biblioteca.añadirBibliotecario(bibliotecario2);

        // Inicializamos estudiantes
        estudiante1 = new Estudiante("Pedro Fernández","123",null,null);
        estudiante2 = new Estudiante("Luisa Martínez","456",null,null);

        // Añadimos estudiantes a la biblioteca
        biblioteca.añadirEstudiante(estudiante1);
        biblioteca.añadirEstudiante(estudiante2);

        // Inicializamos libros
        libro1 = new Libro("978-3-16-148410-0", "Código01", "Autor1", "Título1", "Editorial1", LocalDate.of(2020, 1, 1), 5);

        // Añadimos libros a la biblioteca
        biblioteca.getListaLibros().add(libro1);

        // Inicializamos préstamo
        prestamo1 = new Prestamo(null, null,"P001", 2983, null, null, estudiante1);

        // Añadimos un detalle de préstamo
        DetallePrestamo detallePrestamo = new DetallePrestamo("398",2134,2);
        prestamo1.getListaDetallePrestamos().put(libro1.getCodigo(), detallePrestamo);

        // Añadimos el préstamo a la biblioteca
        biblioteca.añadirPrestamo(prestamo1, bibliotecario1, estudiante1);
    }

    @Test
    public void testAñadirBibliotecario() {
        // Comprobamos si se añadió correctamente el bibliotecario
        assertEquals("Bibliotecario añadido correctamente", biblioteca.añadirBibliotecario(new Bibliotecario("Juan Pérez",null,null,null,0.0, LocalDate.of(2015, 1, 1))));
    }

    @Test
    public void testEliminarBibliotecario() {
        // Comprobamos si se elimina correctamente el bibliotecario
        assertEquals("Bibliotecario eliminado correctamente", biblioteca.eliminarBibliotecario(bibliotecario1));
    }

    @Test
    public void testBuscarLibroPorIsbn() {
        // Buscamos el libro por su ISBN
        assertNotNull(biblioteca.buscarLibroPorIsbn("978-3-16-148410-0"));
    }

    @Test
    public void testCalcularTotalPrestamo() {
        // Calculamos el total del préstamo
        double total = biblioteca.calcularTotalPrestamo("P001");
        assertEquals(10.0, total);
    }

    @Test
    public void testEstudianteMasPrestamos() {
        // Comprobamos si el estudiante con más préstamos es el esperado
        String estudianteMasPrestamos = biblioteca.estudianteMasPrestamos();
        assertTrue(estudianteMasPrestamos.contains("Pedro Fernández"));
    }

}

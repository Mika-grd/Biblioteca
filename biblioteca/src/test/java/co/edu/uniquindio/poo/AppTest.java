/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.Bibliotecario;
import co.edu.uniquindio.poo.model.Estudiante;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAñadirBibliotecario() {
        LOG.info("Iniciando test testAñadirBibliotecario");
        
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        Bibliotecario bibliotecario1 = new Bibliotecario("Juan Pérez", null, null, null, 0.0, LocalDate.of(2015, 1, 1));

        // Comprobamos si se añadió correctamente el bibliotecario
        assertEquals("Bibliotecario añadido correctamente", biblioteca.añadirBibliotecario(bibliotecario1));
        LOG.info("Finalizando test eliminarBibliotecario");
    }

    @Test
    public void testEliminarBibliotecario() {
        LOG.info("Iniciando test eliminarBibliotecario");

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        Bibliotecario bibliotecario1 = new Bibliotecario("Juan Pérez", null, null, null, 0.0, LocalDate.of(2015, 1, 1));
        biblioteca.añadirBibliotecario(bibliotecario1);

        // Comprobamos si se elimina correctamente el bibliotecario
        assertEquals("Bibliotecario eliminado correctamente", biblioteca.eliminarBibliotecario(bibliotecario1));

        LOG.info("Finalizando test eliminarBibliotecario");
    }

    @Test
    public void testAñadirBibliotecarioNulo() {
        LOG.info("Iniciando test testAñadirBibliotecarioNulo");
    
    Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
    // Se espera que se lance una excepción al intentar añadir un bibliotecario nulo
    assertThrows(IllegalArgumentException.class, () -> 
        biblioteca.añadirBibliotecario(null));

    LOG.info("Finalizando test testAñadirBibliotecarioNulo");
    }

    @Test
    public void testEliminarBibliotecarioNulo() {
        LOG.info("Iniciando test testEliminarBibliotecarioNulo");

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        assertThrows(IllegalArgumentException.class, () -> biblioteca.eliminarBibliotecario(null));

        LOG.info("Finalizando test testEliminarBibliotecarioNulo");
    }

    @Test 
    public void buscarEstudianteId() {
        LOG.info("Iniciando test buscarEstudianteId");

        Biblioteca biblioteca = new Biblioteca("x");

        Estudiante estudiante = new Estudiante("jairo", "9090", "300 445 4545", "j89@ex.com");

        biblioteca.añadirEstudiante(estudiante);

        assertEquals(estudiante, biblioteca.buscarEstudianteId("9090"));

        LOG.info("Finalizando test buscarEstudianteId");
    }

    @Test 
    public void eliminarEstudiante() {
        LOG.info("Iniciando test buscarEstudianteId");

        Biblioteca biblioteca = new Biblioteca("x");

        Estudiante estudiante = new Estudiante("jairo", "9090", "300 445 4545", "j89@ex.com");

        biblioteca.añadirEstudiante(estudiante);

        assertEquals(estudiante, biblioteca.buscarEstudianteId("9090"));

        LOG.info("Finalizando test buscarEstudianteId");
    }

    @Test 
    public void eliminarEstudianteNulo() {
        LOG.info("Iniciando test buscarEstudianteId");

        Biblioteca biblioteca = new Biblioteca("x");


        assertThrows(IllegalArgumentException.class, () -> biblioteca.eliminarEstudiante(null));


        LOG.info("Finalizando test buscarEstudianteId");
    }

}

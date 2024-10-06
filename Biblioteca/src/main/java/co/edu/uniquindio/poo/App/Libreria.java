package co.edu.uniquindio.poo.App;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class Libreria {

    // ---------------- Métodos de Verificación ----------------

    /**
     * Método para solicitar y verificar que un campo sea de tipo int usando JOptionPane.
     * @param n Valor entero por defecto (puede ser 0 si se ignora el parámetro)
     * @return Entero validado ingresado por el usuario.
     */
    public static int verifInt(int n) {
        while (true) {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del contacto"));
                return n;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "La edad tiene que ser un número válido.");
            }
        }
    }

    /**
     * Método para solicitar y verificar que un campo sea de tipo double usando JOptionPane.
     * @param n Valor double por defecto (puede ser 0.0 si se ignora el parámetro)
     * @return Double validado ingresado por el usuario.
     */
    public static double verifDouble(double n) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese un número (por ejemplo, el salario)");
                n = Double.parseDouble(input);
                return n;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "El valor tiene que ser un número válido.");
            }
        }
    }

    /**
     * Método para solicitar y verificar que un campo sea de tipo LocalDate usando el formato YYYY-MM-DD con JOptionPane.
     * @param fecha Fecha por defecto (puede ser null si se ignora el parámetro)
     * @return LocalDate validado ingresado por el usuario.
     */
    public static LocalDate verifDate(LocalDate fecha) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha de publicación (formato: YYYY-MM-DD)");
                fecha = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
                return fecha;
            } catch (DateTimeParseException dtpe) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Asegúrese de usar YYYY-MM-DD.");
            }
        }
    }


    /**
     * metodo para solicitar y verificar un campo tipo String no esta vacio con Joption
     * @param str
     * @return
     */

     public static String strNotNull(String str){

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
    
    // ---------------- Otros Métodos Propios de Libreria (si los tienes) ----------------
    
    // Aquí puedes añadir otros métodos que sean parte de la lógica de negocio de la librería
}
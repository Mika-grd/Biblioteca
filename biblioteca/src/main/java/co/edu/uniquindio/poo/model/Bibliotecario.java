package co.edu.uniquindio.poo.model;


public class Bibliotecario extends Persona{

    private double salario;


    public Bibliotecario(String nombre, String id, String telefono, String correo, double salario){
        super(nombre, id, telefono, correo);
        this.salario = salario;
    }



    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}

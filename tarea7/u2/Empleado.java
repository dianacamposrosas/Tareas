package tarea7.u2;
import java.util.ArrayList;
public class Empleado {

    private String nombre;
    private int edad;
    private double salario;
    private int límiteCuenta=10;
    private ArrayList <cuentaBanco> account = new ArrayList<cuentaBanco>(); 
    private int saldo=0;
    

    public Empleado(String nombre, int edad, double salario, long numCuenta, char tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.account.add(new cuentaBanco(numCuenta, tipo));

    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre ){
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad >= 18 && edad <= 65) {
            this.edad = edad;
        } else {
            System.out.println("Edad inválida");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {  
        if (salario > 0) {
            this.salario = salario;
        } else {
            System.out.println("Invalid salary");
        }
    }


    public int saldo() {
        return saldo;
    }

    public int límiteCuenta() {
        return límiteCuenta;
    }


    public void retirar(double dinero, int i){
        
        if (dinero <= this.account.get(i).getCantidad()) {
            this.account.get(i).setCantidad(this.account.get(i).getCantidad()-dinero);
            System.out.println(String.format("Saldo en cuenta: %f", this.account.get(i).getCantidad()));
        }else{
            System.out.println("Saldo insuficiente");
        }
        
    }
    
    public void deposito (double cantidad, int i){
        this.account.get(i).setCantidad(this.account.get(i).getCantidad()+cantidad);
        System.out.println(String.format("Saldo actual: %f", this.account.get(i).getCantidad()));
    }

    public cuentaBanco getCuentaBanco(int i){
        return account.get(i);
    }
    
    public void addCuentaBanco(long numCuenta, char tipo){
        this.account.add(new cuentaBanco (numCuenta, tipo));
    }
    
    public ArrayList<cuentaBanco> getAccount() {
        return account;
    }
}



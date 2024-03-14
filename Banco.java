package tarea7.u2;
import java.util.ArrayList;

public class Banco {
    private ArrayList <Empleado> empleado = new ArrayList<Empleado>();

    public void addEmpleado(String nombre, int edad, double salario, long accountNumber, char tipo) {
        empleado.add(new Empleado(nombre, edad, salario, accountNumber, tipo));
    }

    public void addCuentaBanco(int i, long cuentaBanco, char tipo) {
        empleado.get(i).addCuentaBanco(cuentaBanco, tipo);
    }
    public ArrayList<Empleado> getEmpleado() {
        return empleado;
    }
}

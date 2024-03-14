package tarea7.u2;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea7U2 {
public static void main(String[] args) {
    boolean main = true;
        int opcion;
        int opciones2; 
        double money;
        Banco banco = new Banco();
        Scanner leer = new Scanner(System.in);
        /*Scanner cuenta = new Scanner(System.in);*/

        banco.getEmpleado().add(new Empleado ("Dana", 20, 15000, 543210, 'A'));
        banco.getEmpleado().add(new Empleado("Diana", 18, 12000, 125874, 'B'));

        while (main) {
            System.out.println("\n Elije una opcion: \n1. Mostrar los datos del usuario \n2. Modificar o mostrar los datos en el banco \n3. Salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n Elije una opcion: \n1. Mostrar toda la informacion de los usuarios \n2. Mostrar informacion de un usuario \n3. Salir ");

                    opcion = leer.nextInt();

                    switch (opcion) {
                        case 1:
                            if (banco.getEmpleado().size() > 0) {
                                for (int i = 0; i < banco.getEmpleado().size(); i++) {
                                    System.out.println(banco.getEmpleado().get(i).getNombre());
                                    for (int j = 0; j < banco.getEmpleado().get(i).getAccount().size(); j++) {
                                        System.out.println(j + 1 + "*"
                                                + banco.getEmpleado().get(i).getAccount().get(j).getNumCuenta()
                                                + " "
                                                + banco.getEmpleado().get(i).getAccount().get(j).getTipo());
                                    }
                                }
                            } else {
                                System.out.println("No se tiene ningun usuario para mostrar \n");
                            }
                            break;
                        case 2:
                            System.out.println("Elija de que empleado mostrar su infomacion");
                            for (int i = 0; i < banco.getEmpleado().size(); i++) {
                                System.out.println(i + "*" + banco.getEmpleado().get(i).getNombre());
                            }
                            opcion = leer.nextInt();

                            for (int j = 0; j < banco.getEmpleado().get(opcion).getAccount().size(); j++) {
                                System.out.println(j + 1 + "*"
                                        + banco.getEmpleado().get(opcion).getAccount().get(j).getNumCuenta()
                                        + " "
                                        + banco.getEmpleado().get(opcion).getAccount().get(j).getTipo());
                            }

                            break;
                    }

                    break;
                case 2:
                    System.out.println("\n Elije una opcion: \n1- Añadir cuenta extra\n2- Retirar \n3- Depositar");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Elija a que empleado agregar ");
                            for (int j = 0; j < banco.getEmpleado().size(); j++) {
                                System.out.println(j + "*" + banco.getEmpleado().get(j).getNombre());
                            }

                            opcion = leer.nextInt();
                            System.out.println("Intruduce nuevo numero de Cuenta");
                            long newAccount = leer.nextLong();
                            System.out.println("Intruduce el tipo de Cuenta");
                            char nType = leer.nextLine().charAt(0);
                            banco.getEmpleado().get(opcion).addCuentaBanco(newAccount, nType);
                            System.out.println("Se ja añadido la cuenta");
                            break;
                  
                        case 2:
                            System.out.println("De que usuario sera el retiro");
                            for (int j = 0; j < banco.getEmpleado().size(); j++) {
                                System.out.println(j + "*" + banco.getEmpleado().get(j).getNombre());
                            }
                            opcion = leer.nextInt();
                            System.out.println("Elejir cuenta");
                            for (int j = 0; j < banco.getEmpleado().get(opcion).getAccount().size(); j++) {
                                System.out.println(j + "*" + banco.getEmpleado().get(opcion).getAccount().get(j));
                            }
                            int opciones = leer.nextInt();
                            System.out.println("El dinero en cuenta es:"
                                    + banco.getEmpleado().get(opcion).getAccount().get(opciones).getCantidad()
                                    + "\nCantidad a retirar");
                            double dinero = leer.nextDouble();
                            banco.getEmpleado().get(opcion).retirar(dinero, opciones);
                            break;
                        case 3:
                            System.out.println("Deposito a:");
                            for (int j = 0; j < banco.getEmpleado().size(); j++) {
                                System.out.println(j + "*" + banco.getEmpleado().get(j).getNombre());
                            }
                            opciones = leer.nextInt();
                            System.out.println("Cuenta:");
                            for (int j = 0; j < banco.getEmpleado().get(opcion).getAccount().size(); j++) {
                                System.out.println(j + "*" + banco.getEmpleado().get(opcion).getAccount().get(j));
                            }
                            opciones = leer.nextInt();
                            System.out.println("El dinero en cuenta es:"
                                    + banco.getEmpleado().get(opcion).getAccount().get(opciones).getCantidad()
                                    + "\nCantidad a depositar");
                            dinero = leer.nextDouble();
                            banco.getEmpleado().get(opcion).deposito(dinero, opciones);
                            break;
                            
                        default:
                            
                            break;
                    }
                  
                    
                case 3:
                    
                    main = false;
                    
                    break;
                    
                default:
                    
                    break;
            }
        }
    }
    
    
}

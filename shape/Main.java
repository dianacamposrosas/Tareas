package shape;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        Triangle myTriangle = new Triangle();
        Square mySquare = new Square();
        Rectangle myRectangle = new Rectangle();
        Circle myCircle= new Circle();
        
        int opcion;
        do{
            
        System.out.println("What do you wanna do?\n\n1. Area and perimeter of the triangle\n"
                + "2. Area and perimeter of the square\n3.Area and perimeter of the rectangle\n"
                + "4. Area and perimeter of the circle\n5. Exit\n\n Choose a number: ");
        
        opcion = leer.nextInt();
        switch(opcion) {
            case 1:
                myTriangle.calcularArea();
                myTriangle.calcularPerimetro();
                break;
            case 2:
                mySquare.calcularArea();
                mySquare.calcularPerimetro();
                break;
            case 3: 
                myRectangle.calcularArea();
                myRectangle.calcularPerimetro();
                break;
            case 4:
                myCircle.calcularArea();
                myCircle.calcularPerimetro();
                break;
                
        }
        } while(opcion!=5);
    }
}

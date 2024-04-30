package shape;
import java.util.Scanner;


public class Triangle extends Shape {
    Scanner leer = new Scanner(System.in);
    
    @Override
    public void calcularPerimetro(){
        System.out.println("Please enter the side 1 of the triangle (int)");
        int side1= leer.nextInt();
        
        System.out.println("Please enter the side 2 of the triangle (int)");
        int side2 = leer.nextInt();
        
        System.out.println("Please enter the side 3 of the triangle (int)");
        int side3 = leer.nextInt();
        
        System.out.println("The perimete is: "+ (side1+side2+side3));
    }
    
    @Override
    public void calcularArea(){
        System.out.println("Please enter the base of the triangle (int)");
        base= leer.nextInt();
        
        System.out.println("Please enter the height of the triangle (int)");
        height = leer.nextInt();
        
        System.out.println("The perimeter is: "+ (base*height/2));
    }
}

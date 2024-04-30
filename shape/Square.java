package shape;
import java.util.Scanner;

public class Square implements ShapeInterface {
    Scanner leer = new Scanner(System.in);
    int side;
    
    public void obtenerLado(){
        System.out.println("Please enter the side of the square (int)");
        side= leer.nextInt();
    }
    @Override
    public void calcularPerimetro(){
        
        System.out.println("The perimeter is: "+ (side*4)+"cm");
    }
    
    @Override
    public void calcularArea(){
        System.out.println("The area is: "+ Math.pow(side, 2)+"cm2");
    }
}

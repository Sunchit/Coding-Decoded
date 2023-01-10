import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the radius of the circle(in m): ");
            float r = sc.nextFloat();
            float area = 3.14f *r *r;

            System.out.println("The area of the circle is: "+area+" m^2");


        }
    }
}

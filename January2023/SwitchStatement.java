import java.util.Scanner;
public class SwitchStatement {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Enter your choice: ");

            int number = sc.nextInt();

            switch(number){

                case 1: System.out.println("I Love You");
                        break;
                case 2: System.out.println("I Miss You");
                        break;
                case 3: System.out.println("I Kiss You");
                        break;
                default: System.out.println("I Hug You");
                        break;

            }

        }
    }
}

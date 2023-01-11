import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            if(age>=18){
                System.out.println("You are adult, so you can vote..");
            }else if(age>=13 && age<18){
                System.out.println("You are teenager, you can not vote");
            }else{
                System.out.println("You are a child...");
            }

        }
    }
}

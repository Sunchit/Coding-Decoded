import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            System.out.println("The Name is "+str);
            System.out.println("The length of the string is "+str.length());
            
        }
    }
}

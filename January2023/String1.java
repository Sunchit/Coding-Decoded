import java.util.Scanner;

public class String1 {

    public static void printLetters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the First Name: ");
            String str1 = sc.next();
            System.out.print("Enter the Last Name: ");
            String str2 = sc.next();
            System.out.println("The Full Name is: "+str1+" "+str2);
            printLetters(str1+str2);
        }
    }
}

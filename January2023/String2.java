import java.util.Scanner;

public class String2 {

    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)==str.charAt(str.length()-1-i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the String: ");
            String str = sc.nextLine();
            if(isPalindrome(str)==true){
                System.out.println("Yes, It is a Palindrome");
            }
            if(isPalindrome(str)==false){
                System.out.println("It is not a Palindrome");
            }
        }
    }
}

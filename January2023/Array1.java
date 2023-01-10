import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int marks[] = new int[5];
            marks[0] = sc.nextInt();
            marks[1] = sc.nextInt();
            marks[2] = sc.nextInt();
            marks[3] = sc.nextInt();
            marks[4] = sc.nextInt();

           for(int i=0;i<marks.length;i++){
            System.out.print(marks[i]+" ");
           }
           System.out.println();
        }
    }
}

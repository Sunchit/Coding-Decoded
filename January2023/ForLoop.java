import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the range: ");
            int range = sc.nextInt();
            
            for(int i=0;i<=range;i++){

                if(i%10==0){
                    continue;
                }
                System.out.println(i);

            }
        }

    }
}

import java.util.Scanner;

public class Pattern10 {
        
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the number of rows: ");
            int row = sc.nextInt();

            for(int i=0;i<row;i++){
                for(int j=0;j<=i;j++){
                    if((i+j)%2==0){
                        System.out.print(1+" ");
                    }else{
                        System.out.print(0+" ");
                    }
                }
                System.out.println();
            }


        }
    }

}

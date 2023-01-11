public class Array8 {

    public static void printSubarrays(int numbers[]){
        int ts = 0;

        for(int i=0;i<numbers.length;i++){
          
            for(int j=i;j<numbers.length;j++){
               
                for(int k=i;k<=j;k++){
                    System.out.print(numbers[k]+" ");
                    ts++;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Sub Arrays = "+ts);

    }

    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5,6,7,8,9,0};
        printSubarrays(numbers);
    }
}

public class Bit1 {

    public static void OddOrEven(int n){
        int bitmask = 1;
        if((n & bitmask)==0){
            //even number
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }


    }

    public static void main(String[] args) {

        OddOrEven(3);
        OddOrEven(14);
         
    }
}

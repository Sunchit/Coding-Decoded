public class Functions {
    public static int calculateSum(int a, int b){
        
        return a+b;
    }

    public static void print(){
        System.out.println("Hello World");
    }

    public static void swap(int a, int b){

        int temp;
        temp = a;
        a = b;
        b = temp;


    }
    public static int product(int a, int b){

        return a*b;
    }

    public static void main(String[] args) {
       System.out.println(calculateSum(12, 23));
        print();
        int a = 12;
        int b = 13;
      swap(a, b);
       System.out.println(a);
       System.out.println(b);

       System.out.println(product(12, 13));
    }
}

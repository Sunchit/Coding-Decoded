public class DoWhile {
    public static void main(String[] args) {
        int n = 1;

        do{

                if(n%10==0){
                    break;
                }

            System.out.println("Hello World");
            System.out.println(n);
            n++;
        }while(n<100);
    }
}

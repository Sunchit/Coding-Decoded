public class Polymorphism1 {
    public static void main(String[] args) {

        System.out.println(sum(10,20,30));
        System.out.println(sum(10, 20));
        System.out.println(sum(2.5, 5.0));
        
    }

    public static int sum(int a, int b){
        return a+b;
    }
    public static double sum(Double d, Double e){
        return d+e;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    }

}



public class Array4 {

    public static int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;

        for(int i=0;i<numbers.length;i++){

            if(largest<numbers[i]){
                largest = numbers[i];
            }

        }
        return largest;
    }
    public static int getSmallest(int[] numbers){
        int smallest = Integer.MAX_VALUE;

        for(int i=0;i<numbers.length;i++){
            if(smallest>numbers[i]){
                smallest = numbers[i];
            }
        }
        return smallest;

    }
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5,6,7,8};
        System.out.println("The largest number is: "+getLargest(numbers));
        System.out.println("The smallest number is: "+getSmallest(numbers));
    }
}

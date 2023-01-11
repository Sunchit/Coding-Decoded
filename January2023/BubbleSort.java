
public class BubbleSort {

    public static void bubbleSort(int[] numbers){

        for(int i=0;i<numbers.length-1;i++){
            for(int j=0;j<numbers.length-1-i;j++){

                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }

            }
        }

    
    }

    public static void main(String[] args) {

       int numbers[] = {2,4,6,8,0,1,3,5,7,9};

     bubbleSort(numbers);
     for(int i=0;i<numbers.length;i++){
        System.out.print(numbers[i]+" ");
     }
        
    }
}

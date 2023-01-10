public class Array3 {

    public static int linearSearch(int numbers[], int key){

        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
     int numbers[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
     int key = 9;
     int index = linearSearch(numbers, key);

     if(index==-1){
        System.out.println("Not Found");
     }else{
        System.out.println("The Key is found at "+index+"th index.");
     }
        
    }
}

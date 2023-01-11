public class Recursion5 {
    
    public static boolean checkSorted(int arr[], int n){

        if(n == arr.length-1){
            return true;
        }
        if(arr[n]>arr[n+1]){
            return false;
        }
        return checkSorted(arr, n+1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        if(checkSorted(arr, 0)==true){
            System.out.println("Yes, the array is sorted....");
        }else{
            System.out.println("No, the array is not sorted....");
        }
    }

}

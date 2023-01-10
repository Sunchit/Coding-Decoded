public class Recursion7 {
    public static int findKeyFromLast(int arr[], int i, int key){
        if(i<0){
           return -1;
        }

        if(arr[i]==key){
            return i;
        }

        return findKeyFromLast(arr, i-1, key);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,3,4,4,5};
        int key =4;
        if(findKeyFromLast(arr, arr.length-1, key)==-1){
            System.out.println("The element is not present in the array.");
        }
        System.out.println("The key "+key+" is found at "+findKeyFromLast(arr, arr.length-1, key)+" position.");
    }
}

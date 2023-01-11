public class Recursion6 {
    public static int findKey(int arr[],int n, int key){
      
        if(n>arr.length-1){
            return -1;
        }
        if(arr[n]==key){
            return n;
        }
        return findKey(arr, n+1, key);

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,0};
        int key = 0;

        if(findKey(arr, 0, key)==-1){
            System.out.println("The key is not present in the array");
        }else{
        System.out.println("The key "+key+" is find in the array at "+findKey(arr, 0, key)+"th position");
        }
    }

}

public class DAC1 {

    public static int search(int arr[], int targert, int si, int ei){

        int mid = si + (ei-si)/2;

        // case found
        if(arr[mid]==targert){
            return mid;
        }
        // mid on line 1
        if(arr[si]<=mid){

        }
        // mid on line 2
        else{

        }

        return mid;

    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        search(arr, target, 0, arr.length-1);

    }
}

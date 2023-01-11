/**
 * SelectionSort
 */
public class SelectionSort {

    public static void selectionSort(int arr[]){

        for(int i=0;i<arr.length;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){

                            minPos = j;
                }

            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;

        }

    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,7,9,2,4,6,8,0};
        selectionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
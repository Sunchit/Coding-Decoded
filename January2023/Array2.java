public class Array2 {

    public static void update(int marks[]){

        for(int i=0;i<marks.length;i++){
            marks[i] +=1;
        }

    }

    public static void main(String[] args) {
        int marks[] = {99,98,97,96,95};
        update(marks);
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println();
    }
}

public class String4 {
    public static void main(String[] args) {
        String s1 = "Ankit";
        String s2 = "Sharma";
        String s3 = new String("AnkitSharma");

        if(s3.equals(s1+s2)){
            System.out.println("Equal String");
        }
       else if(s1==s2){
            System.out.println("Strings are equal");
        }else{
            System.out.println("String are not equal");
        }

    }
}

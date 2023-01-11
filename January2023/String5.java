public class String5 {
    
    public static String subString(String str, int startIndex, int endIndex){
        String substr = "";
        for(int i=startIndex;i<=endIndex;i++){
            substr+=str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        String str = "Ankit Sharma";
        System.out.println(subString(str, 0, 6));
    }

}

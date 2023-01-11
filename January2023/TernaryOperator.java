public class TernaryOperator {
    public static void main(String[] args) {
        int number = 1;

      String type = (number%2==0)?"even":"odd";

      System.out.println(type);

      int age = 20;

      String type2 = (age>18)?"You can vote":"You can not vote";

      System.out.println(type2);

      int marks = 90;
      String type3 = (marks>33)?"You Pass":"You Fail";

      System.out.println(type3);

    }
}

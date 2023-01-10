public class Static {
    public static void main(String[] args) {
          Student5 s1 = new Student5();
          s1.name  = "Ankit Sharma";
          System.out.println(s1.name);
    }
}

class Student5{
    String name;
    int roll;

  static  String schoolName;

    void setName(String name){
        this.name = name;
    }

    String getName(String name){
        return this.name;
    }

}
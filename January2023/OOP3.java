

class Student3{
    String name;
    int roll;
    Student3(String name){
        this.name = name;
    }
}
public class OOP3 {
    public static void main(String[] args) {
        Student3 student = new Student3("Ankit Sharma");
        System.out.println(student.name);
    }
}

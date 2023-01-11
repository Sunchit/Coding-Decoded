public class OOP4 {
    public static void main(String[] args) {
        Student4 s4 = new Student4();
       System.out.println(s4.name);
        Student4 s5 = new Student4("Ankit Sharma");
        System.out.println(s5.name);
        Student4 s6 = new Student4(20);
        System.out.println(s6.roll);
        Student4 s7 = new Student4("Ankit Sharma",20);
        System.out.println(s7.name+" "+s7.roll);
    }
}
class Student4{
    String name;
    int roll;
    Student4(){
        System.out.println("Constructor called");
    }
    Student4(String name){
        this.name = name;
    }
    Student4(int roll){
        this.roll = roll;
    }
    Student4(String name, int roll){
        this.name = name;
        this.roll = roll;
    }
}
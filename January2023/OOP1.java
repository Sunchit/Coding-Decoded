
class Pen1{
        // properties and functions
        String color;
        int tip;

    void setColor(String newColor){
        color = newColor;
    }
    void setTip(int newTip){
        tip = newTip;
    }

}

class Student{
    String name;
    int age;
    float percentage;

    void calculatePercentage(int physics, int chemistry, int mathematics){
        percentage = (physics+chemistry+mathematics)/3;

    }

}

class BankAccount{

    public String username;
     String password;
    public void setPassword(String pwd){
        password = pwd;
    }

}

public class OOP1 {
    public static void main(String[] args) {
        Pen1 p1 = new Pen1();
        p1.setColor("Red");
        p1.setTip(5);
        System.out.println(p1.color);
        System.out.println(p1.tip);
        BankAccount account = new BankAccount();
        account.username = "Ankit Sharma";
        account.setPassword("123456");
    }
}



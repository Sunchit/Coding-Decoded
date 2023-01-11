public class OOP5 {
    public static void main(String[] args) {
        User user = new User();
        user.name = "Ankit Sharma";
        user.email = "ankit.sharma722327@gmail.com";
        user.roll = 20;
        user.password = "Ankit@2002";

        user.marks[0] = 95;
        user.marks[1] = 96;
        user.marks[2] = 97;
        user.marks[3] = 98;
        user.marks[4] = 99;


        

        User user2 = new User(user);
        user2.password = "Yo Yo Honey Singh";

        // for(int i=0;i<5;i++){
        //     System.out.println(user2.marks[i]);
        // }
        
        System.out.println("The name of the User is: "+user2.name);
        System.out.println("The email of the User is: "+user2.email);
        System.out.println("The roll no. of the User is: "+user2.roll);
        System.out.println("The password of the User is: "+user2.password);
        System.out.println("The marks in Physics is: "+user2.marks[0]);
        System.out.println("The marks in Chemistry is: "+user2.marks[1]);
        System.out.println("The marks in Mathematics is: "+user2.marks[2]);
        System.out.println("The marks in English is: "+user2.marks[3]);
        System.out.println("The marks in Physical Education is: "+user2.marks[4]);
    
       



    }
}
class User{
    String name;
    int roll;
    String email;
    String password;
    int marks[];

    User(){
       marks = new int[5];
    }

    // Shallow Copy Constructor
    User(User user1){
        marks = new int[5];
        this.name = user1.name;
        this.roll = user1.roll;
        this.email = user1.email;
        this.password = user1.password;
        this.marks = user1.marks;
    }

    // Deep Copy Constructor
    

}

public class OOP6 {
   
   User1 user1 = new User1();
    
    
    

   
   
}
class User1{
    String name;
    int roll;
    String email;
    String password;
    int marks[];

    User1(){
       marks = new int[5];
    }

    // Deep Copy Constructor
    User1(User1 user1){
        marks = new int[5];
        this.name = user1.name;
        this.roll = user1.roll;
        this.email = user1.email;
        this.password = user1.password;
        for(int i=0;i<marks.length;i++){
            this.marks[i] = user1.marks[i];
        }
    }

   
    

}


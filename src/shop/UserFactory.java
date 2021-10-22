package shop;


public class UserFactory {
   public void AddNewUser(){};
   
   public static user getInstance(String email,String Password){
       DB_Operations db = new DB_Operations();
       int result = db.login(email, Password);
       if(result == 1)
           return new buyer();
       else if(result == 2){
           return new Seller();
       }
       return null;
   }

}

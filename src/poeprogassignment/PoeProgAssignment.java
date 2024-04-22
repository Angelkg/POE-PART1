package poeprogassignment;

import java.util.Scanner;

public class PoeProgAssignment 
{

    public static void main(String[] args) 
    {
       Scanner pp = new Scanner(System.in);
       ProperInfo pI = new ProperInfo();
       
       String FirstName;
       String LastName;
       String username;
       String password;
       
       boolean username1;
       boolean specialChar;
       boolean passwordlng;
       boolean capitalLr;
       
       username1 = false;
       specialChar = false;
       passwordlng = false;
       capitalLr = false;
       
        System.out.print("Enter first name :");
        FirstName = pp.next();
        System.out.print("Enter last name :");
        LastName = pp.next();
       
       while(username1 == false )
       {
        System.out.print("Enter Username : ");
        username = pp.next();
        
        username1 = pI.ProperUsername(username);
       }
       
       while(specialChar == false || passwordlng == false || capitalLr == false)
       {
        System.out.print("Enter Password : ");
        password = pp.next();
       
        specialChar = pI.ProperPassword(password);
        passwordlng = pI.ProperLength(password);
        capitalLr = pI.ProperCapitalLetter(password);
        
            if(specialChar == false && passwordlng == false && capitalLr == false )
            {
                System.out.println("password is in incorrect format, make sure your password has a capital letter, special character and a length of at least 7 characters!");
            }
            
       }
       
       if(username1 == true &&  specialChar== true && passwordlng == true && capitalLr == true)
        {
            System.out.println("Password succefully saved!!\n");
            
            String loginuser;
            String loginpassword;
            System.out.print("\nEnter your login Username : ");
            loginuser = pp.next();
            System.out.print("Enter your login Password : ");
            loginpassword = pp.next();
             
            System.out.println("Welcome back " + FirstName + " " + LastName + ", it is great to see you again!" );
        }
         
    }
    
}

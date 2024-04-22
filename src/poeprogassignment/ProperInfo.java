package poeprogassignment;

public class ProperInfo 
{
      public boolean ProperUsername(String username)
    {
        boolean CheckUsern = false;
        if(username.contains("_") && username.length()<=5)
        {
            System.out.println("Username Succecfully Captured!\n");
            CheckUsern = true;
        }
        else
        {
            System.out.println("Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length\n");
        }
        return CheckUsern;
    }
    public boolean ProperPassword(String password)
    {
        boolean correctFormat = false;
        String SpecialChar[] = {"@","#","!","$","%","&","*","-","_",">","<","?",":",";","(",")","'",","};
        int count = 0;
        while(count < SpecialChar.length)
        {
            if (password.contains(SpecialChar[count]))
            {
                correctFormat = true;
                count = SpecialChar.length;
            }
             count++;
           
        }
        return correctFormat;
    }
    
    public boolean ProperLength(String password)
    {
        boolean lng = false;
        if (password.length()>7)
        {
            lng = true;
        }
        return lng;
        
    }
    
    public boolean ProperCapitalLetter(String password)
    {
        boolean CapLetter = false;
        String CAPITAL[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int count = 0;
        while (count < CAPITAL.length)
            {
            if (password.contains(CAPITAL[count]))
                {
                    CapLetter = true;
                    count = CAPITAL.length;
                }
            
            count++;
            }
            return CapLetter;
    }
    
}

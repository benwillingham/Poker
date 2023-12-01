package org.example;

public class CreateAccount {
    private String userID;
    private String useID;
    private String password;
    private String email;
    private boolean isvalid;

    public static String[]existingIDs={"abc1234","qwe12345","idfg098d"};
    public static String[]existingEmails={"aYHa234@rg.com","qwrg@ys.com","id@098d.com"};
    public CreatAccount(String userID, String password, String email, boolean isvalid)
    {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.isvalid = false;
    }

    public boolean isuserID(String userID,boolean isvalid)
    {   if(userID.length() =< 7 && userID.length() >= 12 )
        {
            return isvalid;
        }
        else
            isvalid = true;
            return isvalid;


    }
    public boolean ispassword(String password,boolean isvalid)
    {   if(password.length() =< 8 && userID.length() >= 12 )
        {
            return isvalid;
        }
        else
            isvalid = true;
            return isvalid;

    }
    public boolean isemail(String email,boolean isvalid)
    {   if(email.length() =< 0)
        {
            return isvalid;
        }
        else
            isvalid = true;
            return isvalid;

    }
    public boolean checkExistingID(String userID){
        for(String id:existingIDs){
            if(userID.equals(id)){
                return true;
            }
        }


    }
    public boolean checkExistingEmail(String email){
        for(String emails:existingEmails){
            if(email.equals(emails)){
                return true;
            }
        }


    }

public static String Account(String userID,String password,String email)
{
    if(!isuserID(userID))
    {
        return "Invalid User ID!"
    }

    if(!ispassword(password)){
        return"Invalid password!"
    }
    if(!isemail(email)){
        return "Invalid email address!"
    }
    if(!checkExistingID(userID)){
        return"User ID already exists!"
    }
    if(!checkExistingEmail(email)){
        return"Email address already exists!"
    }

    return "Create Account Successfully!"

}

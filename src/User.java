public class User {
    private String userID;
    private String password;
    private String email;

    public User(String userID, String password, String email){
        if (validId(userID) && validPassword(password) && validEmail(email)){
            this.userID = userID;
            this.password = password;
            this.email = email;
        }
    }

    public boolean validId(String userID){
        return true;
    }

    public boolean validPassword(String password){
        return true;
    }

    public boolean validEmail(String email){
        return true;
    }

    public boolean  login(String userID, String password){
        return true;
    }

}

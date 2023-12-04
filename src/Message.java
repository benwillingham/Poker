public class Message {
    private String message;
    private User author;

    public Message(String message, User author){
        this.message = message;
        this.author = author;
    }

    public String getMessage(){
        return this.message;
    }

    public User getAuthor(){
        return this.author;
    }
}

import java.util.*;

public class Game {
    private List<Player> players;
    private int playerCount;
    private float bigBlind;
    private float smallBlind;

    private List<Message> messages;

    public Game(float bigBlind, float smallBlind){
        this.bigBlind = bigBlind;
        this.smallBlind = smallBlind;
        this.playerCount = 0;
        this.players = new ArrayList<Player>();
        this.messages = new ArrayList<Message>();
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public List<Message> getMessages(){
        return this.messages;
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public float getBigBlind(){
        return this.bigBlind;
    }

    public float getSmallBlind(){
        return this.smallBlind;
    }

    public int getPlayerCount(){
        return this.playerCount;
    }

    public void addPlayer(Player player){
        this.players.add(player);
        this.playerCount++;
    }



    public static void main(String[] args) {
        Game game = new Game(2.0f, 1.0f);
        game.addPlayer(new Player(100.0f, "Player 1"));
        game.addPlayer(new Player(100.0f, "Player 2"));
        if(game.getPlayerCount() > 1){
            Hand hand = new Hand(game.getPlayers(), game.getBigBlind(), game.getSmallBlind());
        }

    }

}

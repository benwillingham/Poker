public class Player {
    private String name;
    private float stack;
    private Card[] cards;
    public boolean acted;

    private float lastWager;

    public Player(float stack, String name){
        this.cards = new Card[2];
        cards[0] = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        cards[1] = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        this.stack = stack;
    }

    public void add(float amount){
        this.stack += amount;
    }

    public void subtract(float amount){
        this.stack -= amount;
    }

    public float getStack(){
        return this.stack;
    }

    public void setCards(Card[] cards){
        this.cards = cards;
    }

    public Card[] getCards(){
        return this.cards;
    }

    public void setLastWager(float amount){
        this.lastWager = amount;
    }

    public float getLastWager(){
        return this.lastWager;
    }

    public String getName(){
        return this.name;
    }




}

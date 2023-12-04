import java.util.*;

import static java.util.Collections.shuffle;

public class Hand {

    private float pot;
    private float wager;
    private List<Player> players;
    public Player toAct;
    private List<Player> out;
    private List<Card> board;

    private List<Card> deck;
    private boolean roundComplete;

    public Hand(List<Player> players, float bigBlind, float smallBlind) {
        roundComplete = false;
        this.players = players;
        this.pot = bigBlind + smallBlind;
        players.get(0).subtract(smallBlind);
        players.get(1).subtract(bigBlind);
        this.toAct = players.get(0);
        wager = bigBlind;
        this.board = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            board.add(null);
        }
        this.deck = initializeDeck();


        deal();
        act();


        flop();
        act();

        turn();
        act();

        river();
        act();

    }

    private ArrayList<Card> initializeDeck(){
        ArrayList<Card> deck = new ArrayList<Card>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        shuffle(deck);
        return deck;
    }

    private void deal(){
        for (Player player : players) {
            player.setCards(new Card[]{deck.remove(0), deck.remove(0)});
        }
    }

    public void fold(Player player){
        players.remove(player);
    }

    public void wager(float amount){
        toAct.subtract(amount);
        pot += amount;
        wager = amount;
    }

    public void flop(){
        board.set(0, deck.remove(0));
        board.set(1, deck.remove(0));
        board.set(2, deck.remove(0));
    }

    public void turn(){
        board.set(3, deck.remove(0));
    }

    public void river(){
        board.set(4, deck.remove(0));
    }

    public List<Card> getBoard(){
        return this.board;
    }

    public void act() {
        ArrayList<Float> lastWagers = new ArrayList<Float>();
        for (Player player : players) {player.setLastWager(-1.0f);}
        while (players.size() > 1 || !roundComplete) {
            new GameGUI(toAct, (ArrayList<Card>) board, wager, pot, this);
            do {} while (!toAct.acted);
            for (Player player : players) {
                lastWagers.add(player.getLastWager());
            }
            if (lastWagers.stream().distinct().count() == 1) {
                roundComplete = true;
            } else {
                if (toAct == players.get(players.size() - 1)) {
                    toAct = players.get(0);
                } else {
                    toAct = players.get(players.indexOf(toAct) + 1);
                }
            }
        }
    }



}

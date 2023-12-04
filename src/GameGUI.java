import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGUI implements ActionListener, ChangeListener {
    private Player player;
    private JLabel playerLabel;
    private Hand hand;
    private JFrame frame;
    private JPanel panel;
    private JButton checkOrCall;
    private JButton fold;
    private JButton betOrRaise;
    private JSlider slider;
    private JLabel label;
    private JLabel card1;
    private JLabel card2;

    private float pot;
    private float wager;
    public float raise;
    private float playerStack;
    private float playerLastWager;
    private JLabel potLabel;
    private JLabel wagerLabel;
    private JLabel playerStackLabel;
    private JLabel playerLastWagerLabel;
    private ArrayList<Card> board;
    private JLabel board1;
    private JLabel board2;
    private JLabel board3;
    private JLabel board4;
    private JLabel board5;

    private JLabel boardTitle;
    private JLabel handLabel;


    public GameGUI(Player player, ArrayList<Card> board, float wager, float pot, Hand hand) {
        this.player = player;
        this.board = board;
        this.wager = wager;
        this.hand = hand;

        this.pot = pot;
        this.playerLastWager = player.getLastWager();
        this.playerStack = player.getStack();
        slider = new JSlider(JSlider.HORIZONTAL, (int) wager * 2, (int) player.getStack(), (int) wager * 2);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        playerLabel = new JLabel(player.getName());

        potLabel = new JLabel("Pot: " + pot);
        if(player.getLastWager() == -1.0f){
            wagerLabel = new JLabel("To call: " + (wager));
        } else {
            wagerLabel = new JLabel("To call: " + (wager - player.getLastWager()));
        }
        playerStackLabel = new JLabel("Stack: " + player.getStack());

        card1 = new JLabel(player.getCards()[0].getCard().get(1).name() + " of " + player.getCards()[0].getCard().get(0).name());
        card2 = new JLabel(player.getCards()[1].getCard().get(1).name() + " of " + player.getCards()[1].getCard().get(0).name());

        slider.addChangeListener(this);
        if (board.get(0) != null) {
            board1 = new JLabel(board.get(0).getCard().get(1).name() + " of " + board.get(0).getCard().get(0).name());
        } else {
            board1 = new JLabel("-");
        }
        if (board.get(1) != null) {
            board2 = new JLabel(board.get(1).getCard().get(1).name() + " of " + board.get(1).getCard().get(0).name());
        } else {
            board2 = new JLabel("-");
        }
        if (board.get(2) != null) {
            board3 = new JLabel(board.get(2).getCard().get(1).name() + " of " + board.get(2).getCard().get(0).name());
        } else {
            board3 = new JLabel("-");
        }
        if (board.get(3) != null) {
            board4 = new JLabel(board.get(3).getCard().get(1).name() + " of " + board.get(3).getCard().get(0).name());
        } else {
            board4 = new JLabel("-");
        }
        if (board.get(4) != null) {
            board5 = new JLabel(board.get(4).getCard().get(1).name() + " of " + board.get(4).getCard().get(0).name());
        } else {
            board5 = new JLabel("-");
        }

        boardTitle = new JLabel("Board:");
        handLabel = new JLabel("Hand:");


        frame = new JFrame();
        panel = new JPanel();
        if (wager == 0.0f) {
            checkOrCall = new JButton("Check");
            betOrRaise = new JButton("Bet");
        } else {
            checkOrCall = new JButton("Call");
            betOrRaise = new JButton("Raise");
        }
        fold = new JButton("Fold");
        label = new JLabel("Welcome to the game");
        checkOrCall.addActionListener(this);
        fold.addActionListener(this);
        betOrRaise.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(playerLabel);
        panel.add(potLabel);
        panel.add(boardTitle);
        panel.add(board1);
        panel.add(board2);
        panel.add(board3);
        panel.add(board4);
        panel.add(board5);
        panel.add(wagerLabel);
        panel.add(handLabel);
        panel.add(card1);
        panel.add(card2);
        panel.add(checkOrCall);
        panel.add(fold);
        panel.add(betOrRaise);
        panel.add(slider);
        panel.add(playerStackLabel);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Poker");
        frame.pack();
        frame.setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkOrCall) {
            potLabel.setText("Pot: " + (pot + wager));
            label.setText("You called");
            playerStackLabel.setText("Stack: " + (playerStack - wager));
            if (player.getLastWager() == -1.0f) { player.setLastWager(0.0f); }
            if (wager != 0.0f) {hand.wager(wager - player.getLastWager());}
        } else if (e.getSource() == fold) {
            label.setText("You folded");
            hand.fold(player);
        } else if (e.getSource() == betOrRaise) {
            playerStackLabel.setText("Stack: " + (playerStack - raise));
            potLabel.setText("Pot: " + (pot + raise - wager));
            label.setText("You raised to " + raise);
            if (player.getLastWager() == -1.0f) { player.setLastWager(0.0f); }
            hand.wager(raise - player.getLastWager());
        }
        player.acted = true;
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            this.raise = source.getValue();
        }
    }

    public static void main(String[] args) {
        Player player = new Player(100.0f, "ben");
        ArrayList<Card> board = new ArrayList<Card>();
        board.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        board.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        board.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        board.add(null);
        board.add(null);
        //new GameGUI(player, board, 10.0f, 20.0f);

    }
}

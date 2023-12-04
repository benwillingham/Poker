import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private List<String> friends;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.friends = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public List<String> getFriends() {
        return friends;
    }

    public void addFriend(String friendUsername) {
        friends.add(friendUsername);
    }
}

class PokerGame {
    private List<String> players;

    public PokerGame() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(String username) {
        players.add(username);
    }

    public List<String> getPlayers() {
        return players;
    }
}

class PokerGameManager {
    private Map<String, User> users;
    private List<PokerGame> activeGames;

    public PokerGameManager() {
        this.users = new HashMap<>();
        this.activeGames = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }

    public void createGame(User user) {
        PokerGame game = new PokerGame();
        game.addPlayer(user.getUsername());
        activeGames.add(game);
    }

    public void inviteFriend(User user, String friendUsername, PokerGame game) {
        if (user.getFriends().contains(friendUsername)) {
            User friend = users.get(friendUsername);
            if (friend != null) {
                game.addPlayer(friend.getUsername());
                System.out.println(user.getUsername() + " invited " + friend.getUsername() + " to the game.");
            }
        } else {
            System.out.println("Error: " + friendUsername + " is not in your friends list.");
        }
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

// User class
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }
}

// UserManager class
class UserManager {
    private Map<String, User> users = new HashMap<>();

    public void createUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public User getUser(String username) {
        return users.get(username);
    }
}

// LoginUI class
public class LoginUI extends JFrame {

    private UserManager userManager = new UserManager();

    public LoginUI() {
        setTitle("Login or Create Account");
        setSize(300, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        add(inputPanel, BorderLayout.CENTER);

        JButton createButton = new JButton("Create Account");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                userManager.createUser(username, password);
                JOptionPane.showMessageDialog(LoginUI.this, "Account created for " + username);
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                User user = userManager.getUser(username);
                if (user != null && user.checkPassword(password)) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Login successful for " + username);
                } else {
                    JOptionPane.showMessageDialog(LoginUI.this, "Invalid username or password");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(loginButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginUI();
            }
        });
    }
}


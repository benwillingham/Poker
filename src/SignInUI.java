import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignInUI {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signInButton;
    private JPanel panel1;

    // Update the path to the Accounts.txt file
    private static final String ACCOUNTS_FILE = "C:/Users/jranj/Documents/Accounts.txt";
    private Map<String, String> accountMap;

    public SignInUI() {
        initializeAccountMap();

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = textField1.getText();
                char[] enteredPasswordChars = passwordField1.getPassword();
                String enteredPassword = new String(enteredPasswordChars);

                if (isValidLogin(enteredUsername, enteredPassword)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Clear the input fields after checking credentials
                textField1.setText("");
                passwordField1.setText("");
            }
        });
    }

    private void initializeAccountMap() {
        accountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    accountMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidLogin(String enteredUsername, String enteredPassword) {
        return accountMap.containsKey(enteredUsername) && accountMap.get(enteredUsername).equals(enteredPassword);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SignInUI");
        frame.setContentPane(new SignInUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

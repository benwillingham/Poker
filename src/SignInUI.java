import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInUI {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signInButton;
    private JPanel panel1;

    private static final String CORRECT_USERNAME = "your_username";
    private static final String CORRECT_PASSWORD = "your_password";

    public SignInUI() {
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

    private boolean isValidLogin(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(CORRECT_USERNAME) && enteredPassword.equals(CORRECT_PASSWORD);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SignInUI");
        frame.setContentPane(new SignInUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

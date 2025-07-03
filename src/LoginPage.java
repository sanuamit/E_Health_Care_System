import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginPage extends JFrame {
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton btnLogin, btnRegister;

    public LoginPage() {
        setTitle("Login");
        setLayout(new GridLayout(3, 2));
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Username:"));
        tfUsername = new JTextField();
        add(tfUsername);

        add(new JLabel("Password:"));
        pfPassword = new JPasswordField();
        add(pfPassword);

        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");
        add(btnLogin);
        add(btnRegister);

        btnLogin.addActionListener(e -> {
            String user = tfUsername.getText().trim();
            String pass = new String(pfPassword.getPassword()).trim();

            if (authenticate(user, pass)) {
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        btnRegister.addActionListener(e -> new Register());

        setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) return true;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "User file not found.");
        }
        return false;
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

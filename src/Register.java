import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Register extends JFrame {
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton btnRegister;

    public Register() {
        setTitle("User Registration");
        setLayout(new GridLayout(3, 2));
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("New Username:"));
        tfUsername = new JTextField();
        add(tfUsername);

        add(new JLabel("New Password:"));
        pfPassword = new JPasswordField();
        add(pfPassword);

        btnRegister = new JButton("Register");
        add(new JLabel());
        add(btnRegister);

        btnRegister.addActionListener(e -> {
            String username = tfUsername.getText().trim();
            String password = new String(pfPassword.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            try (FileWriter fw = new FileWriter("users.txt", true)) {
                fw.write(username + "," + password + "\n");
                JOptionPane.showMessageDialog(this, "User registered!");
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error registering user.");
            }
        });

        setVisible(true);
    }
}

import javax.swing.*;
import java.io.*;

public class Doctor extends JFrame {
    JTextField tfName, tfSpecial, tfContact;
    JButton btnAdd, btnView;

    public Doctor() {
        setTitle("Doctor Management");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(350, 250);

        tfName = new JTextField(); tfSpecial = new JTextField(); tfContact = new JTextField();
        btnAdd = new JButton("Add Doctor"); btnView = new JButton("View Doctors");

        add(new JLabel("Name:")); add(tfName);
        add(new JLabel("Specialization:")); add(tfSpecial);
        add(new JLabel("Contact:")); add(tfContact);
        add(btnAdd); add(btnView);

        btnAdd.addActionListener(e -> {
            try (FileWriter fw = new FileWriter("DoctorData.txt", true)) {
                fw.write(tfName.getText() + "," + tfSpecial.getText() + "," + tfContact.getText() + "\n");
                JOptionPane.showMessageDialog(this, "Doctor added.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        btnView.addActionListener(e -> {
            try (BufferedReader br = new BufferedReader(new FileReader("DoctorData.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) sb.append(line).append("\n");
                JTextArea ta = new JTextArea(sb.toString());
                JScrollPane sp = new JScrollPane(ta);
                JOptionPane.showMessageDialog(this, sp, "Doctors", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        setVisible(true);
    }
}

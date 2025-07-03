import javax.swing.*;
import java.io.*;

public class Patient extends JFrame {
    JTextField tfName, tfAge, tfGender, tfIssue;
    JButton btnAdd, btnView;

    public Patient() {
        setTitle("Patient Management");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(350, 300);

        tfName = new JTextField(); tfAge = new JTextField();
        tfGender = new JTextField(); tfIssue = new JTextField();
        btnAdd = new JButton("Add Patient");
        btnView = new JButton("View Patients");

        add(new JLabel("Name:")); add(tfName);
        add(new JLabel("Age:")); add(tfAge);
        add(new JLabel("Gender:")); add(tfGender);
        add(new JLabel("Issue:")); add(tfIssue);
        add(btnAdd); add(btnView);

        btnAdd.addActionListener(e -> {
            try (FileWriter fw = new FileWriter("PatientData.txt", true)) {
                fw.write(tfName.getText() + "," + tfAge.getText() + "," + tfGender.getText() + "," + tfIssue.getText() + "\n");
                JOptionPane.showMessageDialog(this, "Patient added.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        btnView.addActionListener(e -> {
            try (BufferedReader br = new BufferedReader(new FileReader("PatientData.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) sb.append(line).append("\n");
                JTextArea ta = new JTextArea(sb.toString());
                JScrollPane sp = new JScrollPane(ta);
                JOptionPane.showMessageDialog(this, sp, "Patients", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        setVisible(true);
    }
}

import javax.swing.*;
import java.io.*;

public class Billing extends JFrame {
    JTextField tfPatientName, tfDoctor, tfAmount;
    JButton btnGenerate, btnView;

    public Billing() {
        setTitle("Billing System");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Optional

        tfPatientName = new JTextField();
        tfDoctor = new JTextField();
        tfAmount = new JTextField();

        btnGenerate = new JButton("Generate Bill");
        btnView = new JButton("View Bills");

        add(new JLabel("Patient Name:"));
        add(tfPatientName);

        add(new JLabel("Doctor:"));
        add(tfDoctor);

        add(new JLabel("Amount:"));
        add(tfAmount);

        add(btnGenerate);
        add(btnView);

        btnGenerate.addActionListener(e -> {
            try (FileWriter fw = new FileWriter("BillData.txt", true)) {
                fw.write(tfPatientName.getText() + "," + tfDoctor.getText() + "," + tfAmount.getText() + "\n");
                JOptionPane.showMessageDialog(this, "Bill Generated.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        btnView.addActionListener(e -> {
            try (BufferedReader br = new BufferedReader(new FileReader("BillData.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null)
                    sb.append(line).append("\n");

                JTextArea ta = new JTextArea(sb.toString());
                JScrollPane sp = new JScrollPane(ta);
                sp.setPreferredSize(new java.awt.Dimension(350, 200));

                JOptionPane.showMessageDialog(this, sp, "Bills", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        setVisible(true);
    }
}

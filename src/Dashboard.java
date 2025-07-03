import javax.swing.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("E-Health Care Dashboard");
        setSize(400, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnPatient = new JButton("Manage Patients");
        JButton btnDoctor = new JButton("Manage Doctors");
        JButton btnBilling = new JButton("Generate Bill");
        JButton btnLogout = new JButton("Logout");

        btnPatient.addActionListener(e -> new Patient());
        btnDoctor.addActionListener(e -> new Doctor());
        btnBilling.addActionListener(e -> new Billing());
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginPage();
        });

        add(btnPatient);
        add(btnDoctor);
        add(btnBilling);
        add(btnLogout);
        setVisible(true);
    }
}

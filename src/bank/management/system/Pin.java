package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JButton b1, b2;
    JPasswordField p1, p2;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1366, 768);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(370, 180, 400, 35);
        label1.setForeground(Color.white);
        l3.add(label1);


        JLabel label2 = new JLabel("NEW PIN: ");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(370, 220, 150, 35);
        label2.setForeground(Color.white);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65, 125, 120));
        p1.setForeground(Color.WHITE);
        p1.setBounds(530, 225, 180, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p1);

        JLabel label3 = new JLabel("RE-ENTER NEW PIN: ");
        label3.setFont(new Font("System", Font.BOLD, 15));
        label3.setBounds(370, 270, 400, 35);
        label3.setForeground(Color.white);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65, 125, 120));
        p2.setForeground(Color.WHITE);
        p2.setBounds(530, 275, 180, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(600, 335, 150, 35);
        b1.setBackground(new Color(65, 125, 120));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this); // Add action listener
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(600, 375, 150, 35);
        b2.setBackground(new Color(65, 125, 120));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this); // Add action listener
        l3.add(b2);


        setSize(1366, 768);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = new String(p1.getPassword());
            String pin2 = new String(p2.getPassword());

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (e.getSource() == b1) {
                if (pin1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (pin2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Con c = new Con();
                String q1 = "update bank set pin = '" + pin1 + "' where pin = '" + pin + "'";
                String q2 = "update login set pin = '" + pin1 + "' where pin = '" + pin + "'";
                String q3 = "update signupthree set pin = '" + pin1 + "' where pin = '" + pin + "'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new main_Class(pin1);

            } else if (e.getSource() == b2) {
                new main_Class(pin);
                setVisible(false);
            }

        } catch (Exception E) {
            E.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while changing the PIN.");
        }


     }


    public static void main(String[] args) {
        new Pin("");

    }


}

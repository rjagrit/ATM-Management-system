import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    String pinnumber;

    JButton back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmimage = new JLabel(i3);
        atmimage.setBounds(0,0,900,900);
        add(atmimage);

        back = new JButton("Back");
        back.setBounds(450,470,90,30);
        back.setForeground(Color.RED);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(this);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        atmimage.add(back);

        Conn objc = new Conn();
        int balance = 0;
        try {
            ResultSet s = objc.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (s.next()) {
                if (s.getString("type").equals("Deposite")) {
                    balance += Integer.parseInt(s.getString("amount"));
                } else {
                    balance -= Integer.parseInt(s.getString("amount"));
                }
            }
        }
                catch(Exception ae){
                System.out.println(ae);
            }

        JLabel text = new JLabel("Your Current Balance is Rs "+ balance);
        text.setForeground(Color.WHITE);
        text.setBounds(168,320,400,30);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        atmimage.add(text);

        setSize(900,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}

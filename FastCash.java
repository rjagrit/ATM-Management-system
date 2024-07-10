import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class FastCash extends JFrame implements ActionListener
{
    JLabel atmimage,text;
    JButton cash1,cash2,cash3,cash4,cash5,cash6,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmimage = new JLabel(i3);
        atmimage.setBounds(0,0,900,800);
        add(atmimage);

        text = new JLabel("Select Withdrawl Amount");
        text.setBounds(240,230,700,35);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        atmimage.add(text);

        cash1 = new JButton("Rs 100");
        cash1.setBounds(130,365,100,30);
        cash1.setForeground(Color.GREEN);
        cash1.setBorderPainted(false);
        cash1.setFocusPainted(false);
        cash1.setContentAreaFilled(false);
        cash1.addActionListener(this);
        cash1.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(cash1);

        cash2 = new JButton("Rs 500");
        cash2.setBounds(400,365,180,30);
        cash2.setForeground(Color.GREEN);
        cash2.setBorderPainted(false);
        cash2.setFocusPainted(false);
        cash2.setContentAreaFilled(false);
        cash2.addActionListener(this);
        cash2.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(cash2);

        cash3 = new JButton("Rs 1000");
        cash3.setBounds(130,400,110,30);
        cash3.setForeground(Color.GREEN);
        cash3.setBorderPainted(false);
        cash3.setFocusPainted(false);
        cash3.setContentAreaFilled(false);
        cash3.addActionListener(this);
        cash3.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(cash3);

        cash4 = new JButton("Rs 2000");
        cash4.setBounds(400,400,180,30);
        cash4.setForeground(Color.GREEN);
        cash4.setBorderPainted(false);
        cash4.setFocusPainted(false);
        cash4.setContentAreaFilled(false);
        cash4.addActionListener(this);
        cash4.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(cash4);

        cash5 = new JButton("Rs 5000");
        cash5.setBounds(125,435,120,30);
        cash5.setForeground(Color.GREEN);
        cash5.setBorderPainted(false);
        cash5.setFocusPainted(false);
        cash5.setContentAreaFilled(false);
        cash5.addActionListener(this);
        cash5.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(cash5);

        cash6 = new JButton("Rs 10000");
        cash6.setBounds(405,435,160,30);
        cash6.setForeground(Color.GREEN);
        cash6.setBorderPainted(false);
        cash6.setFocusPainted(false);
        cash6.setContentAreaFilled(false);
        cash6.addActionListener(this);
        cash6.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(cash6);

        back = new JButton("Back");
        back.setBounds(450,465,90,30);
        back.setForeground(Color.RED);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(this);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        atmimage.add(back);

        setSize(900,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ex) {
        if(ex.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ex.getSource()).getText().substring(3); // use substring because we get text as Rs 100 and we only want amount
            Conn objc = new Conn();
            try {
                ResultSet s = objc.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(s.next()){
                    if(s.getString("type").equals("Deposite")){
                        balance+=Integer.parseInt(s.getString("amount"));
                    }
                    else {
                        balance-= Integer.parseInt(s.getString("amount"));
                    }
                }
                if(ex.getSource()!= back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                objc.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount + " Debited Successfuly");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception ae){
                System.out.println(ae);

            }
        }
    }
}

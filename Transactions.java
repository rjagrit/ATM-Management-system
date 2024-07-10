import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener
{
    JLabel atmimage,text;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balancequery,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmimage = new JLabel(i3);
        atmimage.setBounds(0,0,900,800);
        add(atmimage);

        text = new JLabel("Please select your transactions");
        text.setBounds(200,230,700,35);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        atmimage.add(text);

        deposit = new JButton("Deposite");
        deposit.setBounds(150,365,100,30);
        deposit.setForeground(Color.GREEN);
        deposit.setBorderPainted(false);
        deposit.setFocusPainted(false);
        deposit.setContentAreaFilled(false);
        deposit.addActionListener(this);
        deposit.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(deposit);

        withdrawl = new JButton("Cash Withdraw");
        withdrawl.setBounds(360,365,180,30);
        withdrawl.setForeground(Color.GREEN);
        withdrawl.setBorderPainted(false);
        withdrawl.setFocusPainted(false);
        withdrawl.setContentAreaFilled(false);
        withdrawl.addActionListener(this);
        withdrawl.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(148,400,110,30);
        fastcash.setForeground(Color.GREEN);
        fastcash.setBorderPainted(false);
        fastcash.setFocusPainted(false);
        fastcash.setContentAreaFilled(false);
        fastcash.addActionListener(this);
        fastcash.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(360,400,180,30);
        ministatement.setForeground(Color.GREEN);
        ministatement.setBorderPainted(false);
        ministatement.setFocusPainted(false);
        ministatement.setContentAreaFilled(false);
        ministatement.addActionListener(this);
        ministatement.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(148,435,120,30);
        pinchange.setForeground(Color.GREEN);
        pinchange.setBorderPainted(false);
        pinchange.setFocusPainted(false);
        pinchange.setContentAreaFilled(false);
        pinchange.addActionListener(this);
        pinchange.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(pinchange);

        balancequery = new JButton("Balance Query");
        balancequery.setBounds(370,435,160,30);
        balancequery.setForeground(Color.GREEN);
        balancequery.setBorderPainted(false);
        balancequery.setFocusPainted(false);
        balancequery.setContentAreaFilled(false);
        balancequery.addActionListener(this);
        balancequery.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(balancequery);

        exit = new JButton("EXIT");
        exit.setBounds(405,465,90,30);
        exit.setForeground(Color.RED);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        exit.setFont(new Font("Raleway",Font.BOLD,15));
        atmimage.add(exit);

        setSize(900,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
    new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ex) {
        if(ex.getSource()==exit){
            System.exit(0);
        }
        else if(ex.getSource()==deposit){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }
        else if(ex.getSource()==withdrawl){
            setVisible(false);
            new WithdrawlFromBank(pinnumber).setVisible(true);
        }
        else if(ex.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
    }
}

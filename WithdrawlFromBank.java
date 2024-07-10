import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WithdrawlFromBank extends JFrame implements ActionListener
{
    JLabel atmimage,text;
    JTextField amount;
    JButton withdrawl,back;
    String pinnum;
    WithdrawlFromBank(String pinnumber){
        this.pinnum = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmimage = new JLabel(i3);
        atmimage.setBounds(0,0,900,800);
        add(atmimage);

        text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.GREEN);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,240,400,20);
        atmimage.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(178,280,320,25);
        atmimage.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(410,435,150,30);
        withdrawl.setForeground(Color.GREEN);
        withdrawl.setBorderPainted(false);
        withdrawl.setFocusPainted(false);
        withdrawl.setContentAreaFilled(false);
        withdrawl.addActionListener(this);
        withdrawl.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(420,465,150,30);
        back.setForeground(Color.GREEN);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(this);
        back.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add( back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new WithdrawlFromBank("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            }
            else
            {
                try{
                    Conn conObj = new Conn();
                    String query = "insert into bank values('" + pinnum + "','" + date + "','Withdrawl','" + number + "')";
                    conObj.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully!!");
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }
                catch(Exception je){
                    System.out.println(je);
                }
            }
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }
    }
}

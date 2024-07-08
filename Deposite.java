import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener
{
    JLabel atmimage,text;
    JTextField amount;
    JButton deposite,back;
    String pinnum;
    Deposite(String pinnumber){
        this.pinnum = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmimage = new JLabel(i3);
        atmimage.setBounds(0,0,900,800);
        add(atmimage);

        text = new JLabel("Enter the amount you want to deposite");
        text.setForeground(Color.GREEN);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,240,400,20);
        atmimage.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(178,280,320,25);
        atmimage.add(amount);

        deposite = new JButton("Deposite");
        deposite.setBounds(410,435,150,30);
        deposite.setForeground(Color.GREEN);
        deposite.setBorderPainted(false);
        deposite.setFocusPainted(false);
        deposite.setContentAreaFilled(false);
        deposite.addActionListener(this);
        deposite.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(deposite);

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
    new Deposite("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposite){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");
            }
            else
            {
                try{
                    Conn conObj = new Conn();
                    String query = "insert into bank values('" + pinnum + "','" + date + "','Deposite','" + number + "')";
                    conObj.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully!!");
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

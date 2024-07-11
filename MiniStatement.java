import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener
{
//    String pinnumber;

    JLabel bank,ministmt,card,balance;
    MiniStatement(String pinnumber){
        setLayout(null);
//        this.pinnumber = pinnumber;


        bank = new JLabel("INDIAN BANK");
        bank.setBounds(130,10,150,20);
        bank.setFont(new Font("Raleway",Font.BOLD,20));
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        //Fetching the card Number

        try{
            Conn conobj = new Conn();
            ResultSet rs = conobj.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,6) + "XXXXXX" + rs.getString("cardnumber").substring(12)); // 2024930594918561 with substring we get number 202493
            }
        }catch(Exception ae){
            System.out.println(ae);
        }
        ministmt = new JLabel();
        add(ministmt);
        try{
            Conn conobj1 = new Conn();
            int bal = 0;
            ResultSet rs1 = conobj1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs1.next()){
            ministmt.setText(ministmt.getText() + "<html>" +rs1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount") + "<br><br><html>"); //&nbsp; is for spaces

            if(rs1.getString("type").equals("Deposite")){
                bal+=Integer.parseInt(rs1.getString("amount"));
            }
            else {
                bal-= Integer.parseInt(rs1.getString("amount"));
            }
            }
            balance.setText("Your current Account balance is Rs "+bal);
        }catch(Exception de) {
            System.out.println(de);
        }

        ministmt.setBounds(20,140,400,200);

        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(350,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

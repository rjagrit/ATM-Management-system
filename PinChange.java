import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener
{
    String pinnumber;
    JLabel text,newpin,renternewpin;

    JPasswordField newpintf,renternewpintf;

    JButton change,exit;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmimage = new JLabel(i3);
        atmimage.setBounds(0,0,900,900);
        add(atmimage);

        text = new JLabel("Change Your PIN Number");
        text.setBounds(225,300,700,35);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        atmimage.add(text);

        newpin = new JLabel("New PIN :");
        newpin.setBounds(156,340,100,30);
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(newpin);

        newpintf = new JPasswordField();
        newpintf.setFont(new Font("Raleway",Font.BOLD,16));
        newpintf.setBounds(305,345,200,22);
        atmimage.add(newpintf);

        renternewpin = new JLabel("Re-Enter New PIN :");
        renternewpin.setBounds(156,380,150,30);
        renternewpin.setForeground(Color.WHITE);
        renternewpin.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(renternewpin);

        renternewpintf = new JPasswordField();
        renternewpintf.setFont(new Font("Raleway",Font.BOLD,16));
        renternewpintf.setBounds(305,380,200,22);
        atmimage.add(renternewpintf);

        change = new JButton("CHANGE");
        change.setBounds(405,480,160,30);
        change.setForeground(Color.GREEN);
        change.setBorderPainted(false);
        change.setFocusPainted(false);
        change.setContentAreaFilled(false);
        change.addActionListener(this);
        change.setFont(new Font("Raleway",Font.PLAIN,15));
        atmimage.add(change);

        exit = new JButton("EXIT");
        exit.setBounds(435,510,90,30);
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
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change){
            try{
                String npin = newpintf.getText();
                String repin = renternewpintf.getText();

                if(!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter enter PIN");
                    return;
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-enter the PIN");
                    return;
                }

                Conn conobj =  new Conn();
                String query1= "update bank pin set pin = '"+repin+"' where pin='"+pinnumber+"'";
                String query2 = "update login pin set pin = '"+repin+"' where pin='"+pinnumber+"'";
                String query3 = "update signupthree pin set pin = '"+repin+"' where pin='"+pinnumber+"'";

                conobj.s.executeUpdate(query1);
                conobj.s.executeUpdate(query2);
                conobj.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully!!");

                setVisible(false);
                new Transactions(repin).setVisible(true);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

        if(e.getSource()==exit){
            System.exit(0);
        }
    }
}

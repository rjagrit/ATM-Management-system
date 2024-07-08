import javax.swing.*;// using javax (x stands for extended and Swing comes from this pacakage
import java.awt.*; //contains the Image class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JButton loginbtn,signupbtn,clearbtn;
    JTextField f1,f2;
    //class constructor
    Login()
    {
        setLayout(null);//so that it will not use its predefined layouts
        setTitle(" BANK MANAGEMENT SYSTEM");
        ImageIcon imgiconobj= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // Class used to put image on Frame giving path
        Image imgobj= imgiconobj.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT); //for resizing the image
        ImageIcon imgiconobj1= new ImageIcon(imgobj);

        JLabel label1= new JLabel(imgiconobj1); // we use label so to place image first on label
        label1.setBounds(70,10,100,100);//dimensions of image
        add(label1); //using add function to place anything on the frame

        JLabel text= new JLabel("Welcome to BMS");
        text.setFont(new Font("Osward",Font.BOLD,20));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardnum= new JLabel("User Card Number:");
        cardnum.setFont(new Font("Raleway",Font.BOLD,20));
        cardnum.setBounds(120,100,200,40);
        add(cardnum);

        f1= new JTextField();
        f1.setBounds(350,103,250,30);//200+120=  means we have to start textfield after 320
        f1.setFont(new Font("Arial",Font.BOLD,14));
        add(f1);

        JLabel pin= new JLabel("User PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(120,160,400,40);
        add(pin);

        f2= new JTextField();
        f2.setBounds(350,166,250,30);//400+120=  means we have to start textfield after 620
        f2.setFont(new Font("Arial",Font.BOLD,14));
        add(f2);

        loginbtn= new JButton("SIGN IN");
        loginbtn.setBounds(350,230,100,30);
        loginbtn.setBackground(Color.DARK_GRAY);
        loginbtn.setForeground(Color.WHITE);
        loginbtn.addActionListener(this);
        add(loginbtn);

        clearbtn= new JButton("CLEAR");
        clearbtn.setBounds(500,230,100,30);
        clearbtn.setBackground(Color.DARK_GRAY);
        clearbtn.setForeground(Color.WHITE);
        clearbtn.addActionListener(this);
        add(clearbtn);

        signupbtn= new JButton("SIGN UP");
        signupbtn.setBounds(350,290,250,30);
        signupbtn.setBackground(Color.DARK_GRAY);
        signupbtn.setForeground(Color.WHITE);
        signupbtn.addActionListener(this);
        add(signupbtn);

        getContentPane().setBackground(Color.white); // for selecting whole frame we use getContentPane()
        setSize(800,480); //frame size
        setVisible(true); //make frame visible
        setLocation(350,200); //frame location

    }
    public static void main(String [] args)
    {
        new Login();// making a class object and with help of this, frame automatically opened cuz class object bante hi
        // constructor automatically calls up thats why we have to write our whole code inside constructor
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== clearbtn){
            f1.setText("");
            f2.setText("");
        }
        else if(e.getSource()==loginbtn)
        {
            Conn connobj = new Conn();
            String cardnumber = f1.getText();
            String pinnumber = f2.getText();
            String query = "select * from login where cardnumber = '"+ cardnumber +"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs =connobj.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Details");
                    f1.setText("");
                    f2.setText("");
                }
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }
        else if(e.getSource()==signupbtn)
        {
            setVisible(false);
            new SignUp().setVisible(true); // to make frame visible
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {
    JLabel formnum,personalDetails,name,fathername,dob,gender,email,martial,address,city,state,pincode;
    JTextField nametf,fathernametf,gendertf,emailtf,martialtf,addresstf,citytf,statetf,pincodetf;
    JDateChooser dobDc;
    JRadioButton male,female,married,unmarried,other;

    JButton next;

    long random;
    SignUp()
    {
        setLayout(null);
        ImageIcon imgiconobj= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // Class used to put image on Frame giving path
        Image imgobj= imgiconobj.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT); //for resizing the image
        ImageIcon imgiconobj1= new ImageIcon(imgobj);
        JLabel label1= new JLabel(imgiconobj1); // we use label so to place image first on label
        label1.setBounds(10,-10,100,100);//dimensions of image
        add(label1); //using add function to place anything on the frame
        Random ran= new Random();
        random= Math.abs(ran.nextLong() % 9000L + 1000L);

        formnum= new JLabel("Application Form Numbers "+ random);
        formnum.setFont(new Font("Raleway",Font.BOLD,38));
        formnum.setBounds(140,20,600,40);
        add(formnum);

        personalDetails= new JLabel("Page 1: Personal Details");
        personalDetails.setBounds(290,80,400,40);
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(personalDetails);

        name= new JLabel("Name");
        name.setBounds(100,150,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,19));
        add(name);
        nametf= new JTextField();
        nametf.setFont(new Font("Raleway",Font.BOLD,15));
        nametf.setBounds(350,150,300,25);
        add(nametf);

        fathername= new JLabel("Father's Name");
        fathername.setBounds(100,200,200,30);
        fathername.setFont(new Font("Raleway",Font.BOLD,19));
        add(fathername);
        fathernametf= new JTextField();
        fathernametf.setFont(new Font("Raleway",Font.BOLD,15));
        fathernametf.setBounds(350,200,300,25);
        add(fathernametf);

        dob= new JLabel("Date of Birth");
        dob.setBounds(100,250,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,19));
        add(dob);
        dobDc= new JDateChooser();
        dobDc.setFont(new Font("Raleway",Font.BOLD,15));
        dobDc.setForeground(new Color(105,105,105));
        dobDc.setBounds(350,250,300,25);
        add(dobDc);

        gender= new JLabel("Gender");
        gender.setBounds(100,300,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,19));
        add(gender);
        male= new JRadioButton("Male");
        male.setBounds(350,300,60,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.BOLD, 15));
        female= new JRadioButton("Female");
        female.setBounds(450,300,100,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway",Font.BOLD, 15));
        add(male);
        add(female);

        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        email= new JLabel("Email ID");
        email.setBounds(100,350,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,19));
        add(email);
        emailtf= new JTextField();
        emailtf.setFont(new Font("Raleway",Font.BOLD,15));
        emailtf.setBounds(350,350,300,25);
        add(emailtf);

        martial= new JLabel("Marital Status");
        martial.setBounds(100,400,200,30);
        martial.setFont(new Font("Raleway",Font.BOLD,19));
        add(martial);

        married= new JRadioButton("Married");
        married.setBounds(350,400,100,30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Raleway",Font.BOLD, 15));
        add(married);

        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(450,400,120,30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("Raleway",Font.BOLD, 15));
        add(unmarried);

        other= new JRadioButton("Other");
        other.setBounds(580,400,100,30);
        other.setBackground(Color.WHITE);
        other.setFont(new Font("Raleway",Font.BOLD, 15));
        add(other);

        ButtonGroup maritalstsgroup= new ButtonGroup();
        maritalstsgroup.add(married);
        maritalstsgroup.add(unmarried);
        maritalstsgroup.add(other);

        address= new JLabel("Address");
        address.setBounds(100,450,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,19));
        add(address);
        addresstf= new JTextField();
        addresstf.setFont(new Font("Raleway",Font.BOLD,15));
        addresstf.setBounds(350,450,300,25);
        add(addresstf);

        city= new JLabel("City");
        city.setBounds(100,500,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,19));
        add(city);
        citytf= new JTextField();
        citytf.setFont(new Font("Raleway",Font.BOLD,15));
        citytf.setBounds(350,500,300,25);
        add(citytf);

        state= new JLabel("State");
        state.setBounds(100,550,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,19));
        add(state);
        statetf= new JTextField();
        statetf.setFont(new Font("Raleway",Font.BOLD,15));
        statetf.setBounds(350,550,300,25);
        add(statetf);

        pincode= new JLabel("PinCode");
        pincode.setBounds(100,600,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,19));
        add(pincode);
        pincodetf= new JTextField();
        pincodetf.setFont(new Font("Raleway",Font.BOLD,15));
        pincodetf.setBounds(350,600,300,25);
        add(pincodetf);

        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(550,650,100,30);
        next.addActionListener(this);// is button ke click par action listener lgana h toh this pass karna padega
        add(next);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);//so that it will not use its predefined layouts
        setTitle(" BANK MANAGEMENT SYSTEM");
        getContentPane().setBackground(Color.white); // for selecting whole frame we use getContentPane()
        setSize(800,750); //frame size
        setVisible(true); //make frame visible
        setLocation(400,10); //frame location
    }
    public static void main(String [] args)
    {
        new SignUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno= ""+random; // use "" + to make literal as a string
        String apname= nametf.getText(); //getText() value will take out the value from textfield
        String fname= fathernametf.getText();
        String dob= ((JTextField)dobDc.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected())
            gender= "Male";
        else if(female.isSelected())
            gender= "Female";

        String email= emailtf.getText();
        String marital= null;
        if(married.isSelected())
            marital= "Married";
        else if(unmarried.isSelected())
            marital= "Unmarried";
        else if(other.isSelected())
            marital= "Other";

        String address= addresstf.getText();
        String city= citytf.getText();
        String state= statetf.getText();
        String pin= pincodetf.getText();

        try
        {
            if((apname.equals("") || fname.equals("") || dob.equals("") || address.equals("") || city.equals("") || state.equals("") || pin.equals(""))
                    || (!male.isSelected() && !female.isSelected()) || (!married.isSelected() && !unmarried.isSelected() && !other.isSelected())) {
                JOptionPane.showMessageDialog(null, "All Fields are required to be filled");
            }
            else
            {
                Conn c= new Conn();
                String query="insert into signup values('"+formno+"','"+apname+"', '"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                //signup2 class object
                setVisible(false); // make first frame invisible
                new SignupTwo(formno).setVisible(true); // make second frame visible by making its object
            }
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}

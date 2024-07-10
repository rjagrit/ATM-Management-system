import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JLabel additionalDetails,rel,cat,incm,edu,qf,occup,panum,adhaarc,seniocz,existac;
    JTextField pantf,adhaartf;
    String formno;
    JComboBox religion, category,income,education,occupation;

    JRadioButton senioryes,seniorno,existacyes,existacno;
    JButton next;

    long random;

    SignupTwo(String formno) {
        this.formno= formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");
        ImageIcon imgiconobj = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // Class used to put image on Frame giving path
        Image imgobj = imgiconobj.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //for resizing the image
        ImageIcon imgiconobj1 = new ImageIcon(imgobj);

        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(290, 80, 400, 40);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(additionalDetails);

        rel = new JLabel("Religion");
        rel.setBounds(100, 150, 100, 30);
        rel.setFont(new Font("Raleway", Font.BOLD, 18));
        add(rel);
        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valreligion);
        religion.setFont(new Font("Raleway", Font.BOLD, 14));
        religion.setBounds(350, 150, 300, 25);
        religion.setBackground(Color.WHITE);
        add(religion);

        cat = new JLabel("Category");
        cat.setBounds(100, 200, 200, 30);
        cat.setFont(new Font("Raleway", Font.BOLD, 18));
        add(cat);
        String valcat[] = {"General", "SC","ST","OBC", "Others"};
        category = new JComboBox(valcat);
        category.setFont(new Font("Raleway", Font.BOLD, 14));
        category.setBounds(350, 200, 300, 25);
        add(category);

        incm = new JLabel("Income");
        incm.setBounds(100, 250, 200, 30);
        incm.setFont(new Font("Raleway", Font.BOLD, 18));
        add(incm);
        String valinc[] = {"Null", "< 1,50,500","< 2,50,000","< 5,00,000", "upto 10,00,000"};
        income = new JComboBox(valinc);
        income.setFont(new Font("Raleway", Font.BOLD, 14));
        income.setForeground(new Color(105, 105, 105));
        income.setBounds(350, 250, 300, 25);
        add(income);

        edu = new JLabel("Education");
        edu.setBounds(100, 300, 200, 30);
        edu.setFont(new Font("Raleway", Font.BOLD, 18));
        add(edu);
        String valedu[] = {"Non-Graduate","Graduate","Post-Graduate","PhD","Others"};
        education = new JComboBox(valedu);
        education.setBounds(350, 320, 300, 25);
        education.setFont(new Font("Raleway", Font.BOLD, 14));
        education.setBackground(Color.WHITE);
        add(education);

        qf = new JLabel("Qualification");
        qf.setBounds(100, 320, 200, 30);
        qf.setFont(new Font("Raleway", Font.BOLD, 18));
        add(qf);

        occup = new JLabel("Occupation");
        occup.setBounds(100, 400, 200, 30);
        occup.setFont(new Font("Raleway", Font.BOLD, 18));
        add(occup);
        String valoccup[] = {"Job","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(valoccup);
        occupation.setBounds(350, 400, 300, 25);
        occupation.setFont(new Font("Raleway", Font.BOLD, 14));
        occupation.setBackground(Color.WHITE);
        add(occupation);


        panum = new JLabel("PAN Number");
        panum.setBounds(100, 450, 200, 30);
        panum.setFont(new Font("Raleway", Font.BOLD, 18));
        add(panum);
        pantf = new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD, 14));
        pantf.setBounds(350, 455, 300, 25);
        add(pantf);

        adhaarc = new JLabel("Adhaar Number");
        adhaarc.setBounds(100, 500, 200, 30);
        adhaarc.setFont(new Font("Raleway", Font.BOLD, 18));
        add(adhaarc);
        adhaartf = new JTextField();
        adhaartf.setFont(new Font("Raleway", Font.BOLD, 14));
        adhaartf.setBounds(350, 505, 300, 25);
        add(adhaartf);

        seniocz = new JLabel("Senior Citizen");
        seniocz.setBounds(100, 550, 200, 30);
        seniocz.setFont(new Font("Raleway", Font.BOLD, 18));
        add(seniocz);

        senioryes= new JRadioButton("Yes");
        senioryes.setBounds(350,550,100,30);
        senioryes.setBackground(Color.WHITE);
        senioryes.setFont(new Font("Raleway",Font.BOLD, 15));
        add(senioryes);

        seniorno= new JRadioButton("No");
        seniorno.setBounds(450,550,120,30);
        seniorno.setBackground(Color.WHITE);
        seniorno.setFont(new Font("Raleway",Font.BOLD, 15));
        add(seniorno);

        ButtonGroup sz= new ButtonGroup();
        sz.add(senioryes);
        sz.add(seniorno);

        existac = new JLabel("Existing Account");
        existac.setBounds(100, 600, 200, 30);
        existac.setFont(new Font("Raleway", Font.BOLD, 18));
        add(existac);

        existacyes= new JRadioButton("Yes");
        existacyes.setBounds(350,600,100,30);
        existacyes.setBackground(Color.WHITE);
        existacyes.setFont(new Font("Raleway",Font.BOLD, 15));
        add(existacyes);

        existacno= new JRadioButton("No");
        existacno.setBounds(450,600,120,30);
        existacno.setBackground(Color.WHITE);
        existacno.setFont(new Font("Raleway",Font.BOLD, 15));
        add(existacno);

        ButtonGroup eac= new ButtonGroup();
        eac.add(existacyes);
        eac.add(existacyes);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(550, 650, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setLayout(null);//so that it will not use its predefined layouts
        setTitle(" BANK MANAGEMENT SYSTEM");
        getContentPane().setBackground(Color.white); // for selecting whole frame we use getContentPane()
        setSize(800, 750); //frame size
        setVisible(true); //make frame visible
        setLocation(400, 10); //frame location
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String formno= ""+random; // use "" + to make literal as a string
        String sreligion= (String)religion.getSelectedItem(); // we do typecasting because it will return the object and we have to convert it into string
        String scategory= (String)category.getSelectedItem();
//        System.out.println(category.getSelectedItem());
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String issenior= null;

        if(senioryes.isSelected())
            issenior= "Yes";
        else if(seniorno.isSelected())
            issenior= "No";

        String isexistac= null;
        if(existacyes.isSelected())
            isexistac= "Yes";
        else if(existacno.isSelected())
            isexistac= "No";

        String span= pantf.getText();
        String sadhaar= adhaartf.getText();

        try
        {
            if(pantf.equals("") || adhaartf.equals("") || (!senioryes.isSelected() && !seniorno.isSelected()) || (!existacyes.isSelected() && !existacno.isSelected())) {
                JOptionPane.showMessageDialog(null, "All Fields are required to be filled");
            }
            else{
                Conn c= new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"', '"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhaar+"','"+isexistac+"','"+issenior+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
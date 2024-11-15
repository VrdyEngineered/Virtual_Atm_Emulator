package Bank_management_system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;
//import java.util.jar.JarEntry;
// We are using java Swing for creating desktop Frames

//JFrame is one of the swing functions for creating frames
public class Login extends JFrame implements ActionListener {
    // define them globally for accessing thruout the package
    JButton login , clear, new_user;
    JTextField cardtxtfield;
    JPasswordField pintxtfield;
    // Define a constructor for dimensions and other functionality
    Login(){
        setSize(800,480);// geometry of frame
        setTitle("Banking services");
        setLayout(null);
//..................................................................................................................................................
        // for accessing the image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Bank_management_system/icons/logo.jpg"));
        // for resizing image
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        // For adding image , create a object and use add function
        JLabel label = new JLabel(i3);
        label.setBounds(200,10,100,100);
        add(label);
//.....................................................................................................................
        // Title of the frame
        // Adding text , create a object using JLabel
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        // after using setbounds then only text will be visible on the frame
        text.setBounds(300,40,400,40);
        add(text);
        // New user txt label for new registration
        JLabel txt= new JLabel("New User?");
        txt.setFont(new Font("Arial",Font.PLAIN,10));
        txt.setBounds(200,360,300,30);
        add(txt);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

//.........................................................................................................
        // Card number text label
        JLabel card= new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        // after using setbounds then only text will be visible on the frame
        card.setBounds(120,150,400,30);
        add(card);
        //adding input or entry grid for card_number
        cardtxtfield = new JTextField();
        cardtxtfield.setFont(new Font("Arial",Font.PLAIN,14));
        cardtxtfield.setBounds(260,150,250,30);
        add(cardtxtfield);
//.............................................................................................................................
        // Pin number text label
        JLabel pin_num= new JLabel("Pin Number:");
        pin_num.setFont(new Font("Raleway",Font.BOLD,20));
        // after using setbounds then only text will be visible on the frame
        pin_num.setBounds(120,220,400,30);
        add(pin_num);
        //adding input or entry grid for pin_number
        pintxtfield = new JPasswordField();
        pintxtfield.setFont(new Font("Arial",Font.PLAIN,14));
        pintxtfield.setBounds(260,220,250,30);
        add(pintxtfield);
//..................................................................................................................
        // Creating buttons for different functionality
        // Sign in button
         login=new JButton("SIGN IN");
        login.setBounds(260,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        // clear button
        clear=new JButton("CLEAR");
        clear.setBounds(410,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        // Sign up button
         new_user=new JButton("SIGN UP");
        new_user.setBounds(260,360,250,30);
        new_user.setBackground(Color.BLACK);
        new_user.setForeground(Color.WHITE);
        new_user.addActionListener(this);
        add(new_user);
//........................................................................................
        getContentPane().setBackground(Color.WHITE);
        setVisible(true); // For showing the frame
        setLocation(350,200); // when open where it needs to be placed
    }
    // For avoiding error of Actionlisterner and defining actions
    public void actionPerformed(ActionEvent ac){
        // Actionevent ac tells us which button is pressed\
        if(ac.getSource()== login)
        {
            Connectn c = new Connectn();
            String cardnumber= cardtxtfield.getText().trim();
            String pinnumber= pintxtfield.getText().trim();
            String query = "select * from login where cardnumber= '"+cardnumber+"' and pin_number= '"+pinnumber+"' ";
            try{
                ResultSet rs= c.s.executeQuery(query); // use execute query for select statements
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin" );
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(ac.getSource()==clear)
        {
            // whenever clear button is pressed txtfield should be empty
            cardtxtfield.setText("");
            pintxtfield.setText("");

        }
        else if(ac.getSource()==new_user)
        {
            setVisible(false);
            new SignUpOne().setVisible(true);

        }
    }

    public static void main(String[] args) {
        //creating object for opening frame
         new Login(); // whenever we open or run the program "The login console should open that is the frame should be open"
    }
}

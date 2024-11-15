package Bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinfield,re_pinfield;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Bank_management_system/icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,890,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        //.....................................................................................................................
        JLabel txt=new JLabel("Change Your PIN");
        txt.setBounds(270,300,500,35);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("System",Font.BOLD,16));
        image.add(txt);
        //.......................................................................................................
        // txt label and txt field for entering new pin
        JLabel pintxt=new JLabel("New PIN:");
        pintxt.setBounds(165,350,180,25);
        pintxt.setForeground(Color.WHITE);
        pintxt.setFont(new Font("System",Font.BOLD,16));
        image.add(pintxt);
        pinfield=new  JPasswordField();
        pinfield.setBounds(330,350,180,25);
        pinfield.setFont(new Font("Arial",Font.BOLD,25));
        image.add(pinfield);
        //...........................................................................................
        // txt label and txt field for entering new pin again (re-enter)
        JLabel re_pintxt=new JLabel("Re-Enter New PIN:");
        re_pintxt.setBounds(165,390,180,25);
        re_pintxt.setForeground(Color.WHITE);
        re_pintxt.setFont(new Font("System",Font.BOLD,16));
        image.add(re_pintxt);
        re_pinfield=new  JPasswordField();
        re_pinfield.setBounds(330,390,180,25);
        re_pinfield.setFont(new Font("Arial",Font.BOLD,25));
        image.add(re_pinfield);
        //..............................................................................................
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("back");
        back .setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back );

        //......................................................................................................................
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else if (ae.getSource()==change) {
            //JOptionPane.showMessageDialog(null,"Are You Sure You want to change Your Pin");
            try{
                String npin= pinfield.getText(); // take the input of txt fields and compare them with original pin
                String rpin=re_pinfield.getText();
                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                    return;
                }
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Enter New pin");
                     return;
                }
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
                    return;
                }
                Connectn c= new Connectn();
                String query2="update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
                String query3="update login set pin_number='"+rpin+"'where pin_number='"+pinnumber+"'";
                String query4="update signupthree set pin_number='"+rpin+"'where pin_number='"+pinnumber+"'";

                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                c.s.executeUpdate(query4 );
                JOptionPane.showMessageDialog(null,"Pin changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}

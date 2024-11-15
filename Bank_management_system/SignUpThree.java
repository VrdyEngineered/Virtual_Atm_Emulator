package Bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;// r1= savings account,
    // r2= Fd account
    // r3= current account
    // r4= recurring deposit account
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    // c1= Atm card,c2=internet banking, c3=Mobile banking , c4=Email & SMS sevices
    // c5=cheque book c6= e-statements , c7= consent
    String formno;
    JButton submit , cancel;
    SignUpThree( String formno){
        this.formno=formno;
        setLayout(null); // for initialization of set bounds functions
        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        //..............................................................................
        JLabel acoount_type= new JLabel("Account Type:");
        acoount_type.setFont(new Font("Raleway",Font.BOLD,22));
        acoount_type.setBounds(100,140,400,40);
        add( acoount_type);
        r1= new JRadioButton("Savings Account");
        r1.setFont(new Font("Arial",Font.PLAIN,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,190,150,20);
        add(r1);
        r2= new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Arial",Font.PLAIN,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,190,250,20);
        add(r2);
        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Arial",Font.PLAIN,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Arial",Font.PLAIN,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup account_grp= new ButtonGroup();
        account_grp.add(r1);
        account_grp.add(r2);
        account_grp.add(r3);
        account_grp.add(r4);
        //......................................................................................

        JLabel card= new JLabel("Card Number: ");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel cardd= new JLabel("(16 Digit Card Number)");
        cardd.setFont(new Font("Raleway",Font.PLAIN,12));
        cardd.setBounds(100,330,200,30);
        add(cardd);

        JLabel card_num= new JLabel("XXXX-XXXX-XXXX-4184");
        card_num.setFont(new Font("Arial",Font.PLAIN,22));
        card_num.setBounds(280,300,300,30);
        add(card_num);
        //..............................................................................................
        JLabel pin= new JLabel("PIN Number: ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pinn= new JLabel("(4 Digit ATM Pin)");
        pinn.setFont(new Font("Raleway",Font.PLAIN,12));
        pinn.setBounds(100,400,200,30);
        add(pinn);
        JLabel pin_num= new JLabel("XXXX");
        pin_num.setFont(new Font("Arial",Font.PLAIN,22));
        pin_num.setBounds(280,370,300,30);
        add(pin_num);
        //..............................................................................................

        JLabel services= new JLabel("Services Required: ");
        services.setFont(new Font("Arial",Font.BOLD,22));
        services.setBounds(100,450,400,30);
        add(services);
         c1= new JCheckBox("ATM CARD");
         c1.setBackground(Color.WHITE);
         c1.setFont(new Font("Arial",Font.PLAIN,16));
         c1.setBounds(100,500,200,30);
         add(c1);
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Arial",Font.PLAIN,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Arial",Font.PLAIN,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        c4= new JCheckBox("Email & SMS Services");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Arial",Font.PLAIN,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Arial",Font.PLAIN,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        c6= new JCheckBox("e-Statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Arial",Font.PLAIN,16));
        c6.setBounds(350,500,200,30);
        add(c6);
        c7= new JCheckBox("I Hereby declare that above details entered are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Arial",Font.PLAIN,12));
        c7.setBounds(100,680,600,30);
        add(c7);
        //.................................................................................
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial",Font.BOLD,14));
        submit.setBounds(420,720,100,30);
        submit.addActionListener(this);
        add(submit);
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial",Font.BOLD,14));
        cancel.setBounds(250,720,100,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);// setting background as white
        setSize(850,800); // dimensions of frame
        setTitle("Banking Services- New Registration ");
        setLocation(350,10);// where frame should appear when it runs
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accounttype=null;
            if(r1.isSelected())
            {
                accounttype="Savings Account";
            }
            else if(r2.isSelected())
            {
                accounttype="Fixed Deposit Account";
            }
            else if(r3.isSelected())
            {
                accounttype="Current Account";
            }
            else if(r4.isSelected())
            {
                accounttype="Reccuring Deposit Account";
            }
            Random ran=new Random();
            String cardnumber=""+ Math.abs((ran.nextLong()%90000000L) + 5040936000000000L);
            String pinnumber=""+ Math.abs((ran.nextLong()%9000L)+1000L) ;
            String facility="";
            if(c1.isSelected())
            {
                facility+="ATM Card";
            } else if (c2.isSelected()) {
                facility+="Internet Banking";

            }
            else if(c3.isSelected())
            {
                facility+="Mobile Banking";
            } else if (c4.isSelected()) {
                facility+="Email & SMS Services";

            }
            else if(c5.isSelected())
            {
                facility+="Cheque Book";
            }
            else if(c6.isSelected())
            {
                facility+="e-Statement";
            }
            try{
                if(accounttype.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account Type Required");
                }

                else if (!c7.isSelected()) {  // Check if consent box is ticked
                    JOptionPane.showMessageDialog(null, "Tick the consent box");
                }
                else
                {
                    Connectn c= new Connectn();
                    String query1= "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2= "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n Pin Number:"+ pinnumber);

                    setVisible(false);
                   // new SignUpThree(formno).setVisible(true);
                    new Deposit(pinnumber).setVisible(true);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);

        }
    }
    public static void main(String[] args) {
        new SignUpThree("");

    }
}

package Bank_management_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton one,five,onek,twok, fivek, tenk,exit;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        // Adding image of atm machine
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Bank_management_system/icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,890,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        //....................................................................................................
        JLabel txt=new JLabel("Select Withdrawl Amount");
        txt.setBounds(210,320,700,35);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("System",Font.BOLD,16));
        image.add(txt);
        //.........................................................................................
        // creating buttons for various actions in ATM
        one = new JButton("Rs 100");
        one.setBounds(170,415,150,30);
        one.addActionListener(this);
        image.add(one);

        five = new JButton("Rs 500");
        five.setBounds(355,415,150,30);
        five.addActionListener(this);
        image.add(five);

        onek = new JButton("Rs 1000");
        onek.setBounds(170,450,150,30);
        onek.addActionListener(this);
        image.add(onek);

        twok = new JButton("Rs 2000");
        twok.setBounds(355,450,150,30);
        twok.addActionListener(this);
        image.add(twok);

        fivek= new JButton("Rs 5000");
        fivek.setBounds(170,485,150,30);
        fivek.addActionListener(this);
        image.add( fivek);

        tenk= new JButton("Rs 10000");
        tenk.setBounds(355,485,150,30);
        tenk.addActionListener(this);
        image.add(tenk);

        exit= new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); // helps us to remove upper taskbar like part of the frame which contains -,x
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else  {
            // when any amount button is clicked ,pick the text written on the button and debit it

            String amnt=((JButton)ae.getSource()).getText().substring(3);
            Connectn c = new Connectn();
            try
            {
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                // this loop will u to retrieve data from bank table and traverse it
                while(rs.next())
                {
                    //this will help us to traverse to particular data
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amnt"));
                    }
                    else
                    {
                        balance-=Integer.parseInt(rs.getString("amnt"));

                    }
                }
                // check for insufficient balance
                if(ae.getSource()!=exit && balance < Integer.parseInt(amnt))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return; // Return back bro u cannot go for withdrawl with low balance
                }
                Date date= new Date();
                String query= "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amnt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amnt+"Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch (Exception e)
            {
                System.out.println(e);
            }


        }

    }
    public static void main(String[] args) {
        new FastCash("");

    }
}


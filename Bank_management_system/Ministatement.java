package Bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Ministatement extends JFrame {
    String pinnumber;
    Ministatement(String pinnumber)
    {
        setTitle("Mini statements");
        setLayout(null);

        JLabel mini= new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank_title= new JLabel("ABC bank");
        bank_title.setBounds(150,20,100,20);
        add(bank_title);

        JLabel cardnum = new JLabel();
        cardnum.setBounds(20,80,300,20);
        add(cardnum);

        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);



        try{
            Connectn c= new Connectn();
            ResultSet rs=c.s.executeQuery("select * from login where pin_number='"+pinnumber+"'");
            while(rs.next())
            {
                cardnum.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+" XXXX "+" XXXX "+rs.getString("cardnumber").substring(12));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        try{
            Connectn c= new Connectn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+ "<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amnt")+"<br><br><html>");
                //cardnum.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+" XXXX "+" XXXX "+rs.getString("cardnumber").substring(12));
                if(rs.getString("type").equals("Deposit"))
                {
                    bal+=Integer.parseInt(rs.getString("amnt"));
                }
                else
                {
                    bal-=Integer.parseInt(rs.getString("amnt"));

                }
            }
            balance.setText("Your current Balance is Rs "+ bal);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //....................................................................
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ministatement("");
    }
}

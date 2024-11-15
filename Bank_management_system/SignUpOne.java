package Bank_management_system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.awt.event.ActionListener;
// After clicking Signup button , for asking user details
public class SignUpOne extends JFrame implements ActionListener {

      int randomFourDigit;
      JTextField nametxtfield,fnametxtfield,mailtxtfield;
      JTextField addrsstxtfield , citytxtfield , statetxtfield, pincodetxtfield;
      JRadioButton male , female,married,unmarried ,other;
      JButton next,back;
      JDateChooser dateChooser;
      SignUpOne(){
          setLayout(null); // for precise alignment of text
          Random ran= new Random();
          // Generate a random four-digit number
           randomFourDigit = ran.nextInt(9000) + 1000; // 1000 to 9999
          System.out.println(randomFourDigit);
          //.................................................................................
          JLabel form_no= new JLabel("APPLICATION FORM NO. "+randomFourDigit);
          form_no.setFont(new Font("Arial",Font.BOLD,38) );
          form_no.setBounds(140,20,600,40);
          add(form_no);
          //................................................................................
          //Text label for personal details
          JLabel personalDetails= new JLabel("Page1 : Personal Details");
          personalDetails.setFont(new Font("Arial",Font.BOLD,22) );
          personalDetails.setBounds(290,80,400,30);
          add(personalDetails);
          //........................................................................................
          JLabel name= new JLabel("Name: ");
          name.setFont(new Font("Arial",Font.BOLD,20) );
          name.setBounds(100,140,100,30);
          add(name);
          nametxtfield= new JTextField();
          nametxtfield.setFont(new Font("Arial",Font.PLAIN,16));
          nametxtfield.setBounds(250,140,400,30);
          add(nametxtfield);
          //..................................................................................
          JLabel fname= new JLabel("Father's Name: ");
          fname.setFont(new Font("Arial",Font.BOLD,20) );
          fname.setBounds(100,190,200,30);
          add(fname);
          fnametxtfield= new JTextField();
          fnametxtfield.setFont(new Font("Arial",Font.PLAIN,16));
          fnametxtfield.setBounds(250,190,400,30);
          add(fnametxtfield);
          //...........................................................................
          JLabel dob= new JLabel("Date of Birth: ");
          dob.setFont(new Font("Arial",Font.BOLD,20) );
          dob.setBounds(100,240,200,30);
          add(dob);
           dateChooser=new JDateChooser(); // for showing calendar
          dateChooser.setBounds(250,240,400,30);
          dateChooser.setForeground(Color.black);
          add(dateChooser);
          //............................................................................
          JLabel gender= new JLabel("Gender: ");
          gender.setFont(new Font("Arial",Font.BOLD,20) );
          gender.setBounds(100,290,200,30);
          add(gender);
           male= new JRadioButton("Male");// creating dropdown options for selecting male or female
          male.setBackground(Color.WHITE);
          male.setBounds(250,290,60,30);
          add(male);
           female= new JRadioButton("Female");// creating dropdown options for selecting male or female
          female.setBackground(Color.WHITE);
          female.setBounds(370,290,120,30);
          add(female);
          ButtonGroup gendergroup= new ButtonGroup();
          gendergroup.add(male);
          gendergroup.add(female);

          //............................................................................
          JLabel gmail= new JLabel("Email Address: ");
          gmail.setFont(new Font("Arial",Font.BOLD,20) );
          gmail.setBounds(100,340,200,30);
          add(gmail);
          mailtxtfield= new JTextField();
          mailtxtfield.setFont(new Font("Arial",Font.PLAIN,16));
          mailtxtfield.setBounds(250,340,400,30);
          add(mailtxtfield);
          //..............................................................................
          JLabel martial= new JLabel("Martial Status: ");
          martial.setFont(new Font("Arial",Font.BOLD,20) );
          martial.setBounds(100,390,200,30);
          add(martial);
          married= new JRadioButton("Married");// creating dropdown options
          married.setBackground(Color.WHITE);
          married.setBounds(250,390,120,30);
          add(married);
          unmarried= new JRadioButton("Unmarried");// creating dropdown options
          unmarried.setBackground(Color.WHITE);
          unmarried.setBounds(370,390,120,30);
          add(unmarried);
          other= new JRadioButton("Other");// creating dropdown options
          other.setBackground(Color.WHITE);
          other.setBounds(490,390,120,30);
          add(other);
          ButtonGroup martialgroup= new ButtonGroup();
          martialgroup.add(married);
          martialgroup.add(unmarried);
          martialgroup.add(other);
          //......................................................................................
          JLabel address= new JLabel("Address: ");
          address.setFont(new Font("Arial",Font.BOLD,20) );
          address.setBounds(100,440,200,30);
          add(address);
          addrsstxtfield= new JTextField();
          addrsstxtfield.setFont(new Font("Arial",Font.PLAIN,16));
          addrsstxtfield.setBounds(250,440,400,30);
          add( addrsstxtfield);
          //.............................................................................
          JLabel city= new JLabel("City: ");
          city.setFont(new Font("Arial",Font.BOLD,20) );
          city.setBounds(100,490,200,30);
          add(city);
          citytxtfield= new JTextField();
          citytxtfield.setFont(new Font("Arial",Font.PLAIN,16));
          citytxtfield.setBounds(250,490,400,30);
          add(citytxtfield);
          //.........................................................................
          JLabel state= new JLabel("State: ");
          state.setFont(new Font("Arial",Font.BOLD,20) );
          state.setBounds(100,540,200,30);
          add(state);
          statetxtfield= new JTextField();
          statetxtfield.setFont(new Font("Arial",Font.PLAIN,16));
          statetxtfield.setBounds(250,540,400,30);
          add(statetxtfield);
          //...................................................................................
          JLabel pincode= new JLabel("Pincode: ");
          pincode.setFont(new Font("Arial",Font.BOLD,20) );
          pincode.setBounds(100,590,200,30);
          add(pincode);
          pincodetxtfield= new JTextField();
          pincodetxtfield.setFont(new Font("Arial",Font.PLAIN,16));
          pincodetxtfield.setBounds(250,590,400,30);
          add( pincodetxtfield);
          //................................................................................
          next= new JButton("Next");
          next.setForeground(Color.WHITE);
          next.setBackground(Color.black);
          next.setBounds(620,660,80,30);
          next.addActionListener(this);
          add(next);
          back= new JButton("Back");
          back.setForeground(Color.WHITE);
          back.setBackground(Color.black);
          back.setBounds(100,660,80,30);
          back.addActionListener(this);
          add(back);
          // Creating Frame
          getContentPane().setBackground(Color.WHITE);// setting background as white
          setSize(850,800); // dimensions of frame
          setTitle("Banking Services- New Registration FormNo-1 ");
          setLocation(350,10);// where frame should appear when it runs
          setVisible(true);

      }
      public void actionPerformed(ActionEvent ae) {
          if(ae.getSource()==next){
          // Storing info to send it to sql database
          String formNo = " " + randomFourDigit;
          String name = nametxtfield.getText();
          String fname = fnametxtfield.getText();
          String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
          String gender = null;
          if (male.isSelected()) {
              gender = "Male";
          } else if (female.isSelected()) {
              gender = "Female";
          }
          String email = mailtxtfield.getText();
          String martial = null;
          if (married.isSelected()) {
              martial = "Married";
          } else if (unmarried.isSelected()) {
              martial = "Unmarried";
          } else if (other.isSelected()) {
              martial = "Other";

          }
          String address = addrsstxtfield.getText();
          String city = citytxtfield.getText();
          String state = statetxtfield.getText();
          String pin = pincodetxtfield.getText();

          // Exception handling , to avoid run time errors
          try {
              if (name.equals("")) {
                  JOptionPane.showMessageDialog(null, "Name is Required");
              } else {
                  Connectn c = new Connectn();
                  String query = "insert into signup values('" + formNo + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + martial + "','" + address + "','" + city + "','" + state + "','" + pin + "')";
                  c.s.executeUpdate(query);

                  setVisible(false);
                  new SignUpTwo(formNo).setVisible(true);

              }

          } catch (Exception e) {
              System.out.println(e);
          }
      }
          else if(ae.getSource()==back){
              setVisible(false);
              new Login().setVisible(true);  // Navigate back to login page
          }

      }
    public static void main(String[] args) {
        new SignUpOne();
    }
}

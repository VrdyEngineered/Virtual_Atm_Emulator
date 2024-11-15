package Bank_management_system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpTwo extends JFrame  implements ActionListener{


    JTextField pantxtfield , aadhartxtfield ;
    JRadioButton snryes,snrno,pre_account_yes,pre_account_no;
    JButton next ;
    JComboBox religon,dcaste,dincome,dqualification,doccupation;
     String formno;

    SignUpTwo(String formno ){
        this.formno=formno;
        setLayout(null); // for precise alignment of text
        //................................................................................
        //Text label for personal details
        JLabel additionalDetails= new JLabel("Page2 : Additional Details");
        additionalDetails.setFont(new Font("Arial",Font.BOLD,22) );
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        //........................................................................................
        JLabel religion= new JLabel("Religion: ");
        religion.setFont(new Font("Arial",Font.BOLD,20) );
        religion.setBounds(100,140,100,30);
        add(religion);
        // Adding dropdown for selecting from various options
        String varreligion[] ={" ","Hindu","Muslim","Sikh","christian","Other"};
         religon=new JComboBox(varreligion);
        religon.setBounds(280,140,400,30);
        religon.setBackground(Color.WHITE);
        add(religon);

        //..................................................................................
        JLabel caste= new JLabel("Category: ");
        caste.setFont(new Font("Arial",Font.BOLD,20) );
        caste.setBounds(100,190,200,30);
        add(caste);

        String varcaste[] ={" ","General","OBC","SC","ST","Other"};
         dcaste=new JComboBox(varcaste);
        dcaste.setBounds(280,190,400,30);
        dcaste.setBackground(Color.WHITE);
        add(dcaste);

        //...........................................................................
        JLabel income= new JLabel("Income: ");
        income.setFont(new Font("Arial",Font.BOLD,20) );
        income.setBounds(100,240,200,30);
        add(income);

        String varincome[] ={" ","< 1,00,000","< 3,00,000","< 6,00,000","upto 10,00,000","More than 10,00,000","No Income"};
        dincome=new JComboBox(varincome);
        dincome.setBounds(280,240,400,30);
        dincome.setBackground(Color.WHITE);
        add(dincome);
        //............................................................................
        JLabel education= new JLabel("Education ");
        education.setFont(new Font("Arial",Font.BOLD,20) );
        education.setBounds(100,310,200,30);
        add(education);
        JLabel qualification= new JLabel("Qualification: ");
        qualification.setFont(new Font("Arial",Font.BOLD,20) );
        qualification.setBounds(100,340,200,30);
        add(qualification);
        String varqualification[] ={" ","Doctrate","Post-Graduate","Graduate","Matriculation","Other"};
        dqualification=new JComboBox(varqualification);
        dqualification.setBounds(280,340,400,30);
        dqualification.setBackground(Color.WHITE);
        add(dqualification);

        //..............................................................................
        JLabel occupation= new JLabel("Occupation: ");
        occupation.setFont(new Font("Arial",Font.BOLD,20) );
        occupation.setBounds(100,390,200,30);
        add(occupation);
        String varoccupation[] ={" ","Salaried","Self-Employed","Business","Student","Other"};
       doccupation=new JComboBox(varoccupation);
        doccupation.setBounds(280,390,400,30);
        doccupation.setBackground(Color.WHITE);
        add(doccupation);
        //......................................................................................
        JLabel pan_num= new JLabel("PAN Number: ");
        pan_num.setFont(new Font("Arial",Font.BOLD,20) );
        pan_num.setBounds(100,440,200,30);
        add(pan_num);
        pantxtfield= new JTextField();
        pantxtfield.setFont(new Font("Arial",Font.PLAIN,16));
        pantxtfield.setBounds(280,440,400,30);
        add(pantxtfield);
        //.............................................................................
        JLabel aadhar= new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Arial",Font.BOLD,20) );
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        aadhartxtfield= new JTextField();
        aadhartxtfield.setFont(new Font("Arial",Font.PLAIN,16));
        aadhartxtfield.setBounds(280,490,400,30);
        add(aadhartxtfield);
        //.........................................................................
        JLabel snr= new JLabel("Senior Citizen: ");
        snr.setFont(new Font("Arial",Font.BOLD,20) );
        snr.setBounds(100,540,200,30);
        add(snr);
        snryes= new JRadioButton("Yes");
        snryes.setBackground(Color.WHITE);
        snryes.setBounds(280,540,120,30);
        add(snryes);
        snrno= new JRadioButton("No");
        snrno.setBackground(Color.WHITE);
        snrno.setBounds(400,540,120,30);
        add(snrno);
        ButtonGroup snrgroup= new ButtonGroup();
        snrgroup.add(snryes);
        snrgroup.add(snrno);
        //...................................................................................
        JLabel pre_account= new JLabel("Existing Account: ");
        pre_account.setFont(new Font("Arial",Font.BOLD,20) );
        pre_account.setBounds(100,590,200,30);
        add(pre_account);
        pre_account_yes= new JRadioButton("Yes");
        pre_account_yes.setBackground(Color.WHITE);
        pre_account_yes.setBounds(280,590,120,30);
        add(pre_account_yes);
        pre_account_no= new JRadioButton("No");
        pre_account_no.setBackground(Color.WHITE);
        pre_account_no.setBounds(400,590,120,30);
        add( pre_account_no);
        ButtonGroup pre_account_group= new ButtonGroup();
        pre_account_group.add(pre_account_yes);
        pre_account_group.add(pre_account_no);

        //................................................................................
        next= new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.black);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        // Creating Frame
        getContentPane().setBackground(Color.WHITE);// setting background as white
        setSize(850,800); // dimensions of frame
        setTitle("Banking Services- New Registration FormNo-2");
        setLocation(350,10);// where frame should appear when it runs
        setVisible(true);

    }
    // ActionListener is must important for identify the action performed
    // and taking action for particular action
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next){
        // Storing info to send it to sql database
        String sreligon = (String) religon.getSelectedItem(); // store the value as string which is selsected from the dropdown
        String scaste = (String) dcaste.getSelectedItem();
        String sincome = (String) dincome.getSelectedItem();
        String seducation = (String) dqualification.getSelectedItem();
        String soccupation = (String) doccupation.getSelectedItem();
        // For Normal Text fields to store info
        String span = pantxtfield.getText();
        String saadhar = aadhartxtfield.getText();
        // For radio button we use if-else logic for storing value
        String ssenior = null;
        if (snryes.isSelected()) {
            ssenior = "Yes";
        } else if (snrno.isSelected()) {
            ssenior = "No";
        }
        String spre_account = null;
        if (pre_account_yes.isSelected()) {
            spre_account = "Yes";
        } else if (pre_account_no.isSelected()) {
            spre_account = "No";
        }

        // Exception handling , to avoid run time errors
        try {
//            if(span.equals("")){
//                JOptionPane.showMessageDialog(null,"PAN Number is Required");
//            }
            if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            } else {
                Connectn c = new Connectn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligon + "','" + scaste + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + ssenior + "','" + spre_account + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }


    }
    public static void main(String[] args) {
        new SignUpTwo(" ");
    }
}

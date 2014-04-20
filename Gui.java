import javax.swing.*;
import java.awt.event.*;
public class Gui extends JFrame implements ActionListener
{
  int i = 0;
  Io io = new Io();
  String[] aryContacts = io.getRecordsArray("javaCSV.csv");
  String x = aryContacts[i];
  String[] s = x.split(",");
  
  JPanel pnlBack = new JPanel();
  JPanel pnlButtons = new JPanel();
  
  JPanel pnlLname = new JPanel();
  JPanel pnlFname = new JPanel();
  JPanel pnlPhone = new JPanel();
  JPanel pnlEmail = new JPanel();
  
  JLabel lblLname = new JLabel("Last Name: ");
  JLabel lblFname = new JLabel("First Name: ");
  JLabel lblPhone = new JLabel("Phone:         ");
  JLabel lblEmail = new JLabel("Email:         ");
  
  JTextField txtLname = new JTextField(s[0]);
  JTextField txtFname = new JTextField(s[1]);
  JTextField txtPhone = new JTextField(s[2]);
  JTextField txtEmail = new JTextField(s[3]);
  
  JButton btnForward = new JButton("Forward");
  JButton btnReverse = new JButton("Reverse");
  
  Gui(String s)
  {
    super(s);
    btnForward.addActionListener(this);
    btnReverse.addActionListener(this);
    buildGui();
    this.setSize(200,225);
    this.setLocation(500,200);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  
  void buildGui()
  {
    this.add(pnlBack);
    
    pnlBack.add(pnlLname);
    pnlLname.add(lblLname);
    pnlLname.add(txtLname);
    
    pnlBack.add(pnlFname);
    pnlFname.add(lblFname);
    pnlFname.add(txtFname);
    
    pnlBack.add(pnlPhone);
    pnlPhone.add(lblPhone);
    pnlPhone.add(txtPhone);
    
    pnlBack.add(pnlEmail);
    pnlEmail.add(lblEmail);
    pnlEmail.add(txtEmail);
    
    pnlButtons.add(btnReverse);
    pnlButtons.add(btnForward);
    pnlBack.add(pnlButtons);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == btnForward)
    {
      forward();
    }
    if(e.getSource() == btnReverse)
    {
      reverse();
    }
  }
  
  void forward()
  {
    this.i++;
    if (this.i > (this.aryContacts.length-1))
    {
      this.i = this.aryContacts.length-1;
      return;
    }
    this.x = this.aryContacts[i];
    this.s = this.x.split(",");
    
    this.txtLname.setText(this.s[0]);
    this.txtFname.setText(this.s[1]);
    this.txtPhone.setText(this.s[2]);
    this.txtEmail.setText(this.s[3]);
  }
  
  void reverse()
  {
    this.i--;
    if (this.i < 0)
    {
      this.i = 0;
      return;
    }
    this.x = this.aryContacts[i];
    this.s = this.x.split(",");
    
    this.txtLname.setText(this.s[0]);
    this.txtFname.setText(this.s[1]);
    this.txtPhone.setText(this.s[2]);
    this.txtEmail.setText(this.s[3]);
  }
}
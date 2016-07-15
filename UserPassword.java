package Railway;

import java.util.Date;
import java.util.logging.Handler;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class UserPassword extends JFrame implements ActionListener {

	JLabel l,l1,l2,l6,l5;
	JButton b1,b2,b3;
    JTextField t1,t4,t3;

	JPasswordField t2;
	JPanel p1,p3;
	JPanel p2;
	Handler h;
    Image I1;
    sigindatabase db;
	UserPassword()
	{
		


	 l=new JLabel("WELCOME TO THE RAILWAY RESERVATION");
	 add(l);
	 db=new sigindatabase();
	p1=new JPanel(new FlowLayout());
	add(p1);
	
	 l1=new JLabel("USER_NAME"); 
	p1.add(l1);

	
	 
     t1=new JTextField(10);
	 add(t1);
	// p1.setVisible(true);
	 
	 l2=new JLabel("PASSWORD");
	 add(l2);
	 t2=new JPasswordField(10);
     add(t2);
  
     
  
     
     b1=new JButton("login");
     add(b1);
     b1.addActionListener(this);
  
     p2=new JPanel(new GridLayout(1,4));
 	add(p2);
     b2=new JButton("Sign_up");
     p2.add(b2);
     b2.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO Auto-generated method stub
    			setVisible(false);
    			new SignUp();
    			
    		}});
	
   
     b3=new JButton("Adminlogin");
     add(b3);
     b3.addActionListener(this);
	 setVisible(true);
	 ImageIcon ii=new ImageIcon("F:\\train1.png");
	
		l6 =new JLabel(ii);
		add(l6);
		l5 =new JLabel();
		add(l5);
	
	    setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	setSize(1000,650);
		 setTitle("Log_in");
	//pack();
		 
	setVisible(true);
	setResizable(false);
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String a = t1.getText();
	
		//String b= t2.getText();
	String c="Invalid Username or password plz sign up";
	
		if(e.getSource()==b1)
		{
			char[] tpswd=t2.getPassword();
			String pwsd=null;
			pwsd=String.copyValueOf(tpswd);
		if(db.checkLogin(t1.getText(),pwsd))
		{
			
			setVisible(false);
			new Welcome(t1.getText());
		}
		else
		{
			l5.setText(c);
			JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                    JOptionPane.ERROR_MESSAGE);
		
		}
		
	}
		
		
		

	if(e.getSource()==b3)
	{
		String a = t1.getText();
		char[] tpswd=t2.getPassword();
		String pwsd=null;
		pwsd=String.copyValueOf(tpswd);
		if(a.equals("gaurav")&&pwsd.equals("joshi"))
		{
			setVisible(false);
			new AdminWelcome();
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                    JOptionPane.ERROR_MESSAGE);
		
		}
	}

	}
	public static void main(String args[])
	{
	new UserPassword();
	}
}
	

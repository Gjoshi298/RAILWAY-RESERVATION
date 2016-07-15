package Railway;



import java.awt.List;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookingHistory extends JFrame implements ActionListener {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	Statement st;
	JLabel imgL,l1,l2,l3;
	ImageIcon img;
	JFrame f;
	List li;
	JButton b1,b2;
	JTextField t;
BookingHistory()
	{
	l1=new JLabel("Welcome to Booking History Area");	
	ImageIcon img=new ImageIcon("F:\\a4045a91042cbb3e9bb1adbfda069e35.jpg");
	
	imgL=new JLabel(img);
	imgL.setBounds(0,0,800,900);
	f=new JFrame("main");
	f.getContentPane().setLayout(null);
	l2=new JLabel("PNR_No.");
	l2.setBounds(30,110,100,30);
	t=new JTextField(10);

	t.addActionListener(this);

	t.setBounds(120,110,100,30);
	b1=new JButton("Main Menu");

	b1.addActionListener(this);
	b1.setBounds(170,650,100,30);
	b2=new JButton("Check History");

	b2.addActionListener(this);
	b2.setBounds(130,150,100,30);
	li=new List();
	li.setBounds(150,300,500,250);
	f.getContentPane().add(b1);
	
	f.getContentPane().add(li);
	f.getContentPane().add(l2);
	f.getContentPane().add(t);
	f.getContentPane().add(b2);
	f.getContentPane().add(b1);
	f.getContentPane().add(li);
	f.getContentPane().add(imgL);
	f.setVisible(true);
	f.setSize(800,1000);

	


	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==b1)
	{
		f.setVisible(false);
		new Welcome(null);
	}
	if(e.getSource()==b2)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayreservation","root","root");
		ps=con.prepareStatement("select * from passenger where PNR_No=?");

		ps.setString(1,t.getText());
		
		rs=ps.executeQuery();
		rs.next();

		li.add("PID: "+rs.getString(1));
		li.add("Name of Passenger: "+rs.getString(2));

		li.add("Age "+rs.getString(3));
		li.add("Gender "+rs.getString(4));
		li.add("Address "+rs.getString(5));
		li.add("Category "+rs.getString(6));
		li.add("PNR-NO."+rs.getString(7));
		
		li.add("------------------------------------");

		rs=ps.executeQuery();
	}
		catch(Exception e1)
		{
		System.out.println("connection failed:"+e1);
		}
		}
	}
	public static void main(String args[])
	{
		

	new BookingHistory();
	}

	}



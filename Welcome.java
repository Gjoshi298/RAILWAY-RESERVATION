package Railway;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
class Welcome implements ActionListener
{
	Choice ch1,ch2;
JFrame f;
JButton b1,b2,b3,b4,b5,b6,b7,b8;
Reservation r;
PreparedStatement ps;
ResultSet rs;
Connection con;
Statement st;

Cancellation c;
List li;
int x;
JTextField t,t2,t3,t4;
JLabel imgL,l1,lb,l3,l4,l5,l6,l7;
ImageIcon img;
Welcome(String st)
{
	lb=new JLabel("WELCOME TO THE RAILWAY RESERVATION:");

	ImageIcon img=new ImageIcon("F:\\Trains HD Wallpaper %2812%29.jpg");
imgL=new JLabel(img);
imgL.setBounds(0,0,1300,1000);
lb=new JLabel("WELCOME TO THE RAILWAY RESERVATION:");
lb.setBounds(550,100,300,80);
f=new JFrame("Main");
f.getContentPane().setLayout(null);

b1=new JButton("Reservation Form");
b1.addActionListener(this);
b1.setBounds(150,160,200,40);
b2=new JButton("Booking History");
b2.addActionListener(this);
b2.setBounds(350,160,200,40);
b3=new JButton("Cancellation Form");
b3.addActionListener(this);
b3.setBounds(550,160,200,40);
b4=new JButton("PNR_Status");
b4.addActionListener(this);
b4.setBounds(740,160,200,40);
b8=new JButton("Sign_Out");
b8.addActionListener(this);
b8.setBounds(940,160,200,40);
l1=new JLabel("Source");
l1.setBounds(50,300,60,30);
l6=new JLabel("user name-");

l6.setBounds(950,120,90,20);
t3=new JTextField("",20);

t3.addActionListener(this);

t3.setBounds(1015,120,90,20);
t3.setEditable(false);
l7=new JLabel("user_id-");

l7.setBounds(950,100,90,20);
t4=new JTextField("",20);

t4.addActionListener(this);

t4.setBounds(1000,100,90,20);
t4.setEditable(false);
Choice ch1=new Choice();
ch1.add("dehradun");
ch1.add("haridwar");
ch1.add("muzaafarpur");
ch1.add("meerut");
ch1.add("kolkata");
ch1.add("kathgodam");
ch1.add("haldwani");
ch1.add("rudrpur");
ch1.add("gorakhpur");
ch1.add("allahabad");
ch1.add("amritsar");
ch1.add("okha");
ch1.setBounds(300,300,100,100);
l3=new JLabel("Destination");
l3.setBounds(50,340,100,30);
t=new JTextField(ch1.getSelectedItem(),10);

t.addActionListener(this);
t.setBounds(150,300,90,20);

Choice ch2=new Choice();



ch2.add("haridwar");
ch2.add("muzaafarpur");
ch2.add("meerut");
ch2.add("kolkata");
ch2.add("kathgodam");
ch2.add("haldwani");
ch2.add("rudrpur");
ch2.add("gorakhpur");
ch2.add("allahabad");
ch2.add("amritsar");
ch2.add("okha");
ch2.add("delhi");
ch2.setBounds(300,340,100,100);


t2=new JTextField(ch2.getSelectedItem(),10);

t2.addActionListener(this);

t2.setBounds(150,340,90,20);

t2.setEditable(true);
li=new List();
li.setBounds(150,500,500,180);

b5=new JButton("Check");


b5.addActionListener(this);
b5.setBounds(150,400,100,30);

f.getContentPane().add(lb);

f.getContentPane().add(b1);
f.getContentPane().add(b2);
f.getContentPane().add(b3);
f.getContentPane().add(b4);
f.getContentPane().add(b8);
f.getContentPane().add(l3);
f.getContentPane().add(li);
f.getContentPane().add(b5);
f.getContentPane().add(l3);
f.getContentPane().add(t3);
f.getContentPane().add(t4);
f.getContentPane().add(l1);
f.getContentPane().add(l6);
f.getContentPane().add(l7);
f.getContentPane().add(t);
f.getContentPane().add(t2);
f.getContentPane().add(ch1);
f.getContentPane().add(ch2);
f.getContentPane().add(imgL);
f.setSize(1300,1000);
f.setVisible(true);






t3.setText(String.valueOf(st));


}
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e)
{

	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	Statement st;
	if(e.getSource()==b2)
	{
		f.setVisible(false);
		new BookingHistory();
	}
if(e.getSource()==b4)
{
	f.setVisible(false);
	new PnrStatus();
}
	
if(e.getSource()==b8)
{
	f.setVisible(false);
	new UserPassword();
}


if(e.getSource()==b3)
{
f.setVisible(false);
c=new Cancellation();
}

if(e.getSource()==b5)
{
try
{
	Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayreservation","root","root");
ps=con.prepareStatement("select * from train where Source=? and Destination=? ");

ps.setString(1,t.getText());
ps.setString(2,t2.getText());
rs=ps.executeQuery();
rs.next();

li.add("Train No.: "+rs.getString(1));
li.add("Train Name: "+rs.getString(2));

li.add("Source: "+rs.getString(3));
li.add("Destination: "+rs.getString(4));
li.add("Departure Time "+rs.getString(5));
li.add("Arrival Time "+rs.getString(6));
li.add("Available seats "+rs.getString(7));
li.add("------------------------------------");

rs=ps.executeQuery();


}

catch(Exception e1)
{
System.out.println("connection failed:"+e1);
}
}

if(e.getSource()==b1)
{
f.setVisible(false);
r=new Reservation();
}


}
public static void main(String args[])
{
	

new Welcome(null);
}
}
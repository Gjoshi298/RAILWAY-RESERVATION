package Railway;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class NewFeature extends JFrame implements ActionListener,FocusListener {

	
	

	JFrame f;
	JLabel l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	Choice h;
	JTextArea ta;
	JButton b1,b2,b3,b7;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	int x;
	JLabel imgL;
	ImageIcon img;

	NewFeature()
	{
		ImageIcon img=new ImageIcon("F:\\Trains HD Wallpaper %2812%29.jpg");
		imgL=new JLabel(img);
		imgL.setBounds(0,0,1300,1000);
		f=new JFrame("New Feature to add");
		f.getContentPane().setLayout(null);

	
	l2=new JLabel("AddTrain No");
	l2.setBounds(50,80,100,30);
	l3=new JLabel("AddTrain Name");
	l3.setBounds(50,110,100,30);
	l4=new JLabel("Add Source");
	l4.setBounds(50,140,100,30);
	l5=new JLabel("Add Destination");
	l5.setBounds(50,170,100,30);
	l6=new JLabel("Add Departure time");
	l6.setBounds(50,200,100,30);
	l7=new JLabel("Add arrival time");
	l7.setBounds(250,200,50,30);
	l8=new JLabel("Add available births");
	l8.setBounds(50,230,100,30);
	t1=new JTextField(10);
	t1.setBounds(150,80,100,30);
	t1.setEditable(true);
	t2=new JTextField(10);
	t2.addFocusListener(this);
	t2.setBounds(150,110,100,30);
	t3=new JTextField(10);
	t3.setBounds(150,140,100,30);
	t4=new JTextField(10);
	t4.setBounds(150,170,100,30);
	t5=new JTextField(10);
	t5.setBounds(300,200,100,30);
	t6=new JTextField(10);
	t6.setBounds(150,200,100,30);
	t7=new JTextField(10);
	t7.setBounds(150,230,100,30);

	b1=new JButton("Insert");

	b1.setBounds(50,270,100,30);
	b1.addActionListener(this);


	
	f.getContentPane().add(l2);
	f.getContentPane().add(l3);
	f.getContentPane().add(l4);
	f.getContentPane().add(l5);
	f.getContentPane().add(l6);
	f.getContentPane().add(l7);
	f.getContentPane().add(l8);
	f.getContentPane().add(t1);
	f.getContentPane().add(t2);
	f.getContentPane().add(t3);
	f.getContentPane().add(t4);
	f.getContentPane().add(t5);
	f.getContentPane().add(t6);
	f.getContentPane().add(t7);

	f.getContentPane().add(b1);
	
	f.getContentPane().add(imgL);
	f.setSize(1300,1000);
	f.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e)
	{
		
		ResultSet rs;
		Connection con;
	
	if(e.getSource()==b1)
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayreservation","root","root");
	ps=con.prepareStatement("insert into train values(?,?,?,?,?,?,?)");
	ps.setString(1,t1.getText());
	ps.setString(2,t2.getText());
	ps.setString(3,t3.getText());
	ps.setString(4,t4.getText());
	ps.setString(5,t5.getText());
	ps.setString(6,t6.getText());
	ps.setString(7,t7.getText());
	



	JOptionPane.showMessageDialog(b1, "Record Saved");

	ps.executeUpdate();
	f.setVisible(false);
	new AdminWelcome();
	}
	catch(Exception e1)
	{
	System.out.println("Connection failed:"+e1);
	}

	}}
	public static void main(String args[])
	{
	new NewFeature();

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

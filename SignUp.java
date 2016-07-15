package Railway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class SignUp extends JFrame implements ActionListener,ItemListener,TextListener
  { 
    JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9,l10,l11,bir,add,li1,li2,l12;
    JTextField t1, t2, t5, t6, t7,t8,t9,a1,a2,a3,p1, p2;
    JButton btn1;
    CheckboxGroup cg;
    Checkbox c1,c2;
    Choice Married,dobd,dobm,doby;
    Panel dob;
    Font font;
    int x;
    String s1,s2,s31,s32,s33,s34,s4,d1,s5,s6,s7,s8;
 
    SignUp()
     {
    	setLayout(new BorderLayout());
    	setContentPane(new JLabel(new ImageIcon("F:\\wall.jpg")));
    	setLayout(new FlowLayout());
    
    //changing font of all character not Working!!!
    	
    	font = new Font("Serif", Font.ITALIC, 20);
    	setVisible(true);
        setSize(1320, 700);
        setLayout(null);
        setTitle("SignUp Form For Railways");
        
        dob=new Panel();
        dobd=new Choice();
        dobm=new Choice();
        doby=new Choice();
 
        l1 = new JLabel("\t\tSIGNUP All Fields are Compulsery");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email-ID:");
        l4 = new JLabel("Create Passowrd:");
        l5 = new JLabel("Confirm Password:");
        l6 = new JLabel("Gender");
        bir= new JLabel("Date Of Birth");
        l7 = new JLabel("State:");
        add= new JLabel("Address");
        li1= new JLabel("Line 1");
        li2= new JLabel("Line 2");
        l8 = new JLabel("Pin Code:"); 
        l9=  new JLabel("Phone No:");
        l10= new JLabel("District");
        l11= new JLabel("Marrital Status");
        l12=new JLabel("user_id");
        t1 = new JTextField();
        t2 = new JTextField();
        p1 = new JTextField();
        p2 = new JTextField();
        t5 = new JTextField();
        a1= new JTextField();
        a2= new JTextField();
        a3= new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8= new JTextField();
        t9=new JTextField();
        
        cg=new CheckboxGroup();
		c1=new Checkbox("Male",cg,true);
		c2=new Checkbox("Female",cg,false);
        btn1 = new JButton("Signup");
        
      
        
        
        Married=new Choice();
        Married.add("Married");
        Married.add("Unmarried");
          
        
        
        for(int i=1;i<=31;i++)
		{
			dobd.add(""+i);
		}
        dobm.add("JAN");dobm.add("FEB");dobm.add("MAR");dobm.add("APR");dobm.add("MAY");dobm.add("JUNE");dobm.add("JULY");dobm.add("AUG");
        dobm.add("SEP");dobm.add("OCT");dobm.add("NOV");dobm.add("DEC");
        for(int j=1;j<=65;j++)
		{
        	doby.add(""+(1950+j));
		}
        dob.setLayout(new GridLayout(1,3,10,10));
		dob.add(dobd);
		dob.add(dobm);
		dob.add(doby);
        
		
 
     //ADDING LISTENERS(item listener for pass{PENDING})
		
        t1.addActionListener(this);
        t2.addActionListener(this);
        p1.addActionListener(this);
        p2.addActionListener(this);
        t5.addActionListener(this);
        t6.addActionListener(this);
        t7.addActionListener(this);
        t8.addActionListener(this);
        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        c1.addItemListener(this);
        c2.addItemListener(this);
        dobd.addItemListener(this);
        dobm.addItemListener(this);
        doby.addItemListener(this);
        Married.addItemListener(this);
        btn1.addActionListener(this); 
        
        //SETTING POSITION
        
        l1.setBounds(500, 20, 400, 30);
        l2.setBounds(400, 60, 200, 30);
        l3.setBounds(400, 100, 200, 30);
        l4.setBounds(400, 140, 200, 30);
        l5.setBounds(400, 180, 200, 30);
        l6.setBounds(400, 220, 200, 30);
        bir.setBounds(400, 300, 200, 30);
        l7.setBounds(400, 340, 200, 30);
        add.setBounds(400, 380, 200, 30);
        li1.setBounds(400, 420, 200, 30);
        li2.setBounds(400, 460, 200, 30);
        l8.setBounds(400, 500,200,30);
        l9.setBounds(400, 540,200,30);
        l10.setBounds(400, 580,200,30);
        l11.setBounds(400, 610,200,30);
        l12.setBounds(400,650,200,30);
        t1.setBounds(700, 60, 200, 30);
        t2.setBounds(700, 100, 200, 30);
        p1.setBounds(700, 140, 200, 30);
        p2.setBounds(700, 180, 200, 30);
        c1.setBounds(700, 220, 200, 30);
        c2.setBounds(700, 260, 200, 30);
        dob.setBounds(700, 300, 200, 30);
        t5.setBounds(700, 340, 200, 30);
        a1.setBounds(700, 380, 200, 30);
        a2.setBounds(700, 420, 200, 30);
        a3.setBounds(700, 460, 200, 30);
        t6.setBounds(700, 500, 200, 30);
        t7.setBounds(700, 540, 200, 30);
        t8.setBounds(700, 580, 200, 30);
       
        Married.setBounds(700, 620, 200, 30);
        t9.setBounds(700, 660, 200, 30);
        btn1.setBounds(590, 660, 100, 30);
    
       //ADDING TO FRAME
        add(l1);
        add(l2);add(t1);
        add(l3);add(t2);
        add(l4);add(p1);
        add(l5);add(p2);
        add(Married);add(btn1);
        add(bir); add(dob);
        add(l6);add(t5);
        add(add);add(li1);add(li2);add(l12);
        add(a1);add(a2);add(a3);
        add(l7);add(t6);
        add(l8);add(t7);
        add(l9);add(t8);add(t9);
        add(l10);add(c1);
        add(c2);add(l11);
        
        t9.setText(String.valueOf(x));
     }
//END OF DECLARATIONS & GUI 
    
    public static void main(String args[])
    {
        new SignUp();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	Statement st;
    	ResultSet rs;
    	Connection con;
    	PreparedStatement pst1;
    	
    

        
    	   try
    	   {
    	   	Class.forName("com.mysql.jdbc.Driver");
    	   	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayreservation","root","root");
    	    st=con.createStatement();
    	   rs=st.executeQuery("select * from user_id");
    	   rs.next();
    	   x= rs.getInt(1);
    	   t9.setText(String.valueOf(x));

    	   }
    	   catch(Exception e1)
    	   {
    	   System.out.println("Connection failed:"+e1);
    	   }
           if (e.getSource() == btn1)
           {
    	    String ad1=a1.getText();
            String ad2=a2.getText();
            String ad3=a3.getText();
            String address=ad1+","+ad2+","+ad3;
            String s1=dobd.getSelectedItem();
            String s2=dobm.getSelectedItem();
            String s3=doby.getSelectedItem();
            String dateofbirth=s1+"/"+s2+"/"+s3;
            String g1;
            g1 = ""+c1.getState();
            String gen;
            if(g1.equals("true"))
                gen=c1.getLabel();
            else
                gen=c2.getLabel();
            
            try
            {
            	Class.forName("com.mysql.jdbc.Driver");
            	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayreservation","root","root");	
            	
            	  pst1=con.prepareStatement("update user_id set UserId=? where UserId=?");
            		
                  pst1.setInt(1,(x+1));
                  pst1.setInt(2,x);
                  pst1.executeUpdate();
            	  pst1=con.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?,?,?,?,?)");
                  
                  
                   pst1.setString(1,t1.getText());
                   pst1.setString(2,t2.getText());
                   pst1.setString(3,p1.getText());
                   pst1.setString(4,gen);
                   pst1.setString(5,dateofbirth);
                   pst1.setString(6,t5.getText());
                   pst1.setString(7,address);
                   pst1.setInt(8,Integer.parseInt(t6.getText()));
                   pst1.setInt(9,Integer.parseInt(t7.getText()));
                   pst1.setString(10,t8.getText());
                   pst1.setString(11,Married.getSelectedItem());
                   pst1.setInt(12,x);
                   pst1.executeUpdate();
                                    
	                 
                   JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");   

                  
                       
                   
                   setVisible(false);
       				new UserPassword();
                }
               
         catch (Exception ex) 
               {
        	 JOptionPane.showMessageDialog(btn1, "UN-Successful");
                   System.out.println(ex);
               }
          }
     }
   


	@Override
	public void textValueChanged(TextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
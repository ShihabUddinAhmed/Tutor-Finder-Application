import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 public class ProfileS extends JFrame implements ActionListener
 {
	 private TextField tf,tf1,tf2,tf3,tf4;
	 private String s=" ",s1=" ",s2=" ",s3=" ",s4=" ";
	 private Label l,l2,l3,l4,l5,l6;
	 public JFrame parent;
	 private Font f= new Font(null, Font.BOLD, 30);
	 private Font f1=new Font(null, Font.PLAIN, 36);
	 private Button b,b1,b2,b3,b4,b5,b6,b7;
	 private String IDS=" ",IDAc=" ",IDAd=" ";
	 public ProfileS(String ID)
	 {
		 super("Tutor Finder Companion");
		 setResizable(false);
		 l= new Label("Profile:");
		 l.setBounds(5,8,150,50);
		 l.setFont(f);
		 l2= new Label("Name    :");
		 l2.setBounds(100,95,110,25);
		 l2.setFont(new Font(null,Font.BOLD,25));
		 l3=new Label("E-mail   :");
         l3.setBounds(100,135,110,25);
         l3.setFont(new Font(null,Font.BOLD,25));
         l4=new Label("Class    :");
         l4.setBounds(100,175,110,25);
         l4.setFont(new Font(null,Font.BOLD,25));
		 l5=new Label("Phone-Number :");
		 l5.setBounds(12,215,200,20);
		 l5.setFont(new Font(null,Font.BOLD,25));
		 l6=new Label("Address  :");
		 l6.setBounds(82,255,120,20);
		 l6.setFont(new Font(null,Font.BOLD,25));
		 l.setBackground(new Color(7,0,41));
		 l.setForeground(new Color(180,180,180));
		 l2.setBackground(new Color(180,180,180));
		 l2.setForeground(new Color(7,0,41));
		 l4.setForeground(new Color(7,0,41));
		 l4.setBackground(new Color(180,180,180));
		 l5.setForeground(new Color(7,0,41));
		 l5.setBackground(new Color(180,180,180));
		 l6.setForeground(new Color(7,0,41));
		 l6.setBackground(new Color(180,180,180));
		 try
		{
			String sql="SELECT * FROM `student` WHERE `STUDENT_ID` = "+ID;
			String sq="SELECT * FROM `account` WHERE `STUDENT_ID` = "+ID;
			DatabaseLink da=new DatabaseLink();
			ResultSet rSet=da.getProduct(sql);
			ResultSet rSet1=da.getProduct(sq);
			while(rSet.next()&&rSet1.next())
			{
				 IDS=rSet.getString("STUDENT_ID");
				 IDAc=rSet1.getString("ACCOUNT_ID");
				 IDAd=rSet.getString("ADDRESS_ID");
				 String sql1="SELECT * FROM `address` WHERE `ADDRESS_ID` = "+rSet.getString("ADDRESS_ID");
				 try
				{
					DatabaseLink da1=new DatabaseLink();
					ResultSet rSet2=da1.getProduct(sql1);
					while(rSet2.next())
					{
						 s4=s4+rSet2.getString("CITY")+", "+rSet2.getString("STATE")+", "+rSet2.getString("COUNTRY");
						 System.out.println(s1);
					}
					da1.close();
				}
				catch(Exception ex)
				{
					System.out.println("Exception occurred at collecting Data");
				}
				 s=rSet.getString("STUDENT_NAME");
				 s1=rSet1.getString("EMAIL");
				 s2=rSet.getString("CLASS");
				 s3=rSet.getString("PHONE_NUMBER");
				 
				 System.out.println(s1);
			}
			da.close();
		}
		catch(Exception ex)
		{
			System.out.println("Exception occurred at collecting Data");
		}
		 tf=new TextField(20);
         tf.setBounds(215,95,400,30);
		 tf.setFont(new Font(null,Font.BOLD,18));
		 tf.setText(s);
		 tf.setEditable(false);
         tf1=new TextField(20);
         tf1.setBounds(215,135,400,30);
		 tf1.setFont(new Font(null,Font.BOLD,18));
		 tf1.setText(s1);
		 tf1.setEditable(false);
         tf2=new TextField(20);
         tf2.setBounds(215,175,400,30);
		 tf2.setFont(new Font(null,Font.BOLD,18));
		 tf2.setText(s2);
		 tf2.setEditable(false);
         tf3=new TextField(20);
         tf3.setBounds(215,215,400,30);
		 tf3.setFont(new Font(null,Font.BOLD,18));
		 tf3.setText(s3);
		 tf3.setEditable(false);
		 tf4=new TextField(20);
         tf4.setBounds(215,255,400,30);
		 tf4.setFont(new Font(null,Font.BOLD,18));
		 tf4.setText(s4);
		 tf4.setEditable(false);
		 String[] choices={"","UTTARA","NARSINGDI"};
		 // JComboBox<String> cb = new JComboBox<String>(choices);
		 // cb.setBounds(215,255,200,30);
		 // cb.setFont(new Font(null,Font.BOLD,18));
		 b=new Button("Edit Name");
         b.setBounds(625,97,100,25);

         b1=new Button("Edit E-Mail");
         b1.setBounds(625,137,100,25);

         b2=new Button("Edit Class");
         b2.setBounds(625,177,100,25);

         b3=new Button("Edit Phone-Number");
         b3.setBounds(625,217,150,25);
		 b5= new Button("Change Password");
		 b5.setBounds(680,8,120,50);
		 l3.setForeground(new Color(7,0,41));
		 l3.setBackground(new Color(180,180,180));
		 b6=new Button("Edit Address");
         b6.setBounds(625,257,100,25);
		 b7= new Button("BACK");
		 b7.setBounds(350,400,100,50);
		 add(l);add(b3);add(tf);add(b);add(l3);add(tf1);add(b1);add(l4);add(tf2);add(b2);add(l5);add(tf3);add(l2);add(b5);add(l6);add(tf4);add(b6);add(b7);

		 setLayout(null);
		 setLocation(525,300);
		 this.setBackground(new Color(0,0,0));
		 setSize(820,500);
		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
		 {
			 int i=JOptionPane.showConfirmDialog(null,"Are sure to exit?","Warning",JOptionPane.YES_NO_OPTION);
			//System.out.println(i);
			if(i==0)
			{
				System.exit(0);
			}
		 }});
		 b.addActionListener(this);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 //b4.addActionListener(this);
		 b5.addActionListener(this);
		 b6.addActionListener(this);
		 b7.addActionListener(this);
	 }
	 public void paint(Graphics g)
	 {
		 g.setColor(new Color(7,0,41));
		 g.fillRect(0,0,820,500);
		 g.setColor(new Color(180,180,180));
		 g.fillRect(0,100,820,500);
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 String sig=e.getActionCommand();
		 if(sig.equals("BACK"))
		 {
			 this.setVisible(false);
			 parent.setVisible(true);
		 }
		 else
		 {try
		 {
			 DatabaseLink du=new DatabaseLink();
			 ResultSet upResult;
			 if(sig.equals("Edit Name"))
			 {
				 String inputValue = JOptionPane.showInputDialog("Please Input The Name:");
				 int i=0;
				 if(inputValue.equals(null))
				 {
					 
				 }
				 else
				 {
					 System.out.println(inputValue);
					 i=du.ddlOperation("UPDATE `student` SET `STUDENT_NAME` = '"+inputValue+"' WHERE `student`.`STUDENT_ID` = "+IDS+";");
				 if(i==1)
				 {
					 JOptionPane.showMessageDialog(null,
								"Name Edited",
								"Info:",
								JOptionPane.INFORMATION_MESSAGE);
				 }
				 }
			 }
			 else if(sig.equals("Edit E-Mail"))
			 {
				 String inputValue = JOptionPane.showInputDialog("Please Input The Mail Address:");
				 int i=0;
				 if(inputValue.equals(null))
				 {
					 
				 }
				 else
				 {
				 i=du.ddlOperation("UPDATE `account` SET `EMAIL` = '"+inputValue+"' WHERE `account`.`ACCOUNT_ID` = "+IDAc+";");
				 if(i==1)
				 {
					 JOptionPane.showMessageDialog(null,
								"E-Mail Edited",
								"Info:",
								JOptionPane.INFORMATION_MESSAGE);
				 }
				 }
			 }
			 else if(sig.equals("Edit Class"))
			 {
				 String inputValue = JOptionPane.showInputDialog("Please Input The Class:");
				 int i=0;
				 if(inputValue.equals(null))
				 {
					 
				 }
				 else
				 {
				 i=du.ddlOperation("UPDATE `student` SET `CLASS` = '"+inputValue+"' WHERE `student`.`STUDENT_ID` = "+IDS);
				 if(i==1)
				 {
					 JOptionPane.showMessageDialog(null,
								"Class Edited",
								"Info:",
								JOptionPane.INFORMATION_MESSAGE);
				 }
				 }
			 }
			 else if(sig.equals("Edit Phone-Number"))
			 {
				 String inputValue = JOptionPane.showInputDialog("Please Input The Phone-Number:");
				 int i=0;
				 if(inputValue.equals(null))
				 {
					 
				 }
				 else
				 {
				 i=du.ddlOperation("UPDATE `student` SET `PHONE_NUMBER` = '"+inputValue+"' WHERE `student`.`STUDENT_ID` = "+IDS);
				 if(i==1)
				 {
					 JOptionPane.showMessageDialog(null,
								"Phone-Number Edited",
								"Info:",
								JOptionPane.INFORMATION_MESSAGE);
				 }
				 }
			 }
			 else if(sig.equals("Edit Address"))
			 {
				 boolean flag=false;
				 int i=0;
				 String inputValue = JOptionPane.showInputDialog("Please Input The Name of Your City:");
				 if(inputValue.equals(null))
				 {
					 
				 }
				 else
				 {
				 try
				{
					DatabaseLink da=new DatabaseLink();
					ResultSet rSet=da.getProduct("SELECT * FROM `address` WHERE `CITY` LIKE '"+inputValue+"'");
					while(rSet.next())
					{
						 flag=true;
						 i=du.ddlOperation("UPDATE `student` SET `ADDRESS_ID` = '"+rSet.getString("ADDRESS_ID")+"' WHERE `student`.`STUDENT_ID` = "+IDS);
						 if(i==1)
						 {
							 JOptionPane.showMessageDialog(null,
										"Address Edited",
										"Info:",
										JOptionPane.INFORMATION_MESSAGE);
						 }
						 //System.out.println(s1);
					}
					da.close();
				}
				catch(Exception ex)
				{
					System.out.println("Exception occurred at collecting Data");
				}
				 if(flag==false)
				 {
					 String inputValueSt = JOptionPane.showInputDialog("Please Input The Name of Your State:");
					 String inputValueCoun = JOptionPane.showInputDialog("Please Input The Name of Your Country:");
					 if(inputValue.equals(null))
					 {
						 
					 }
				 else
				 {
					 ResultSet upResult1=du.getProduct("SELECT * FROM `address` WHERE 1 ORDER BY ADDRESS_ID;");
					 String t=" ";
					 while(upResult1.next())
					 {
						 t=upResult1.getString("ADDRESS_ID");
					 }
					 int iD=Integer.parseInt(t.substring(t.indexOf('1'),(t.indexOf('1')+4)));
					 int y=du.ddlOperation("INSERT INTO `address` (`ADDRESS_ID`, `CITY`, `STATE`, `COUNTRY`) VALUES ("+(iD+1)+", '"+inputValue+"', '"+inputValueSt+"', '"+inputValueCoun+"');");
					 upResult=du.getProduct("SELECT * FROM `address` WHERE `CITY` LIKE '"+inputValue+"' AND `STATE` LIKE '"+inputValueSt+"' AND `COUNTRY` LIKE '"+inputValueCoun+"'");
					 while(upResult.next())
					 {
						 i=du.ddlOperation("UPDATE `student` SET `ADDRESS_ID` = '"+upResult.getString("ADDRESS_ID")+"' WHERE `student`.`STUDENT_ID` = "+IDS);
					 }
					 if(i==1)
					 {
						 JOptionPane.showMessageDialog(null,
									"Address Edited",
									"Info:",
									JOptionPane.INFORMATION_MESSAGE);
					 }
				 }
				 }
				 }
			 }
			 else if(sig.equals("Change Password"))
			 {
				 String inputValue = JOptionPane.showInputDialog("Please Input The New Password:");
				 String inputValue1 = JOptionPane.showInputDialog("Please re Enter the Password:");
				 if(inputValue1.equals(inputValue))
				 {
					 int i=0;
					 if(inputValue.equals(null))
				 {
					 
				 }
				 else
				 {
					 i=du.ddlOperation("UPDATE `account` SET `PASSWORD` = '"+inputValue+"' WHERE `account`.`ACCOUNT_ID` = "+IDAc+";");
					 if(i==1)
					 {
						 JOptionPane.showMessageDialog(null,
									"Password Changed",
									"Info:",
									JOptionPane.INFORMATION_MESSAGE);
					 }
					 
				 }
				 }
				 else
					 {
						 JOptionPane.showMessageDialog(null,
									"Please Try Again",
									"WARNING",
									JOptionPane.WARNING_MESSAGE);
					 }
			 }
			 du.close();
		 }
		 catch(Exception ex)
		 {
			 System.out.println("ERROR when Updating DATA");
		 }}
	 }
 }
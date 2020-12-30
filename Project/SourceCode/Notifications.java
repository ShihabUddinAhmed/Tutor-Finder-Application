import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 public class Notifications extends JFrame implements ActionListener
 {
	 private TextArea cTeach;
	 private Font f= new Font(null, Font.BOLD, 20);
	 private Font f1=new Font(null, Font.PLAIN, 18);
	 private Button j;
	 private ResultSet rSet;
	 private String offID=" ",ID="0";
	 public Notifications(String ID,String type)
	 {
		 super("Notifications");
		 setResizable(false);
		 System.out.println(ID);
		 this.ID=ID;
		 String textStr="Latest Notifications:\n\n";
		 j= new Button("OK");
		 j.setBounds(150,408,100,50);
		 if(type.equals("INSTITUTION_ID"))
		 {
			 String sql="SELECT * FROM `offerings` WHERE `INSTITUTION_ID` = "+ID;
			 String s1=" ",s=" ",sub=" ";
			 try
			{
				DatabaseLink da=new DatabaseLink();
				rSet=da.getProduct(sql);
				while(rSet.next())
				{
					 s=rSet.getString("STATUS");
					 s1=rSet.getString("PROFESSIONAL_ID");
					try
					{
						String sq="SELECT * FROM `professional` WHERE `PROFESSIONAL_ID` ="+ s1;
						DatabaseLink da1=new DatabaseLink();
						ResultSet rSet1=da1.getProduct(sq);
						while(rSet1.next())
						{
							 if(s.equals("ACCEPTED"))
							 {textStr=textStr+" \u2709 "+rSet1.getString("PROFESSIONAL_NAME")+" has agreed to teach "+rSet1.getString("PREFERRED_SUBJECT")+" as you offered.\n";}
							 else if(s.equals("PENDING"))
							 {textStr=textStr+" \u2709 You have requested "+rSet1.getString("PROFESSIONAL_NAME")+" to teach "+rSet1.getString("PREFERRED_SUBJECT")+".\n";}
						}
						da1.close();
					}
					catch(Exception ex)
					{
						System.out.println("Exception occurred at collecting Data");
					} 
				}
				da.close();
			}
			catch(Exception ex)
			{
				System.out.println("Exception occurred at collecting Data");
			}
		 }
		 else if(type.equals("STUDENT_ID"))
		 {
			 String sql="SELECT * FROM `offerings` WHERE `STUDENT_ID` = "+ID;
			 String s1=" ",s=" ",sub=" ",s2=" ";
			 try
			{
				DatabaseLink da=new DatabaseLink();
				rSet=da.getProduct(sql);
				while(rSet.next())
				{
					 s=rSet.getString("STATUS");
					 s1=rSet.getString("FREELANCER_ID");
					 
					try
					{
						String sq="SELECT * FROM `freelancer` WHERE `FREELANCER_ID` ="+ s1;
						DatabaseLink da1=new DatabaseLink();
						ResultSet rSet1=da1.getProduct(sq);
						while(rSet1.next())
						{
							 if(s.equals("ACCEPTED"))
							 {textStr=textStr+" \u2709 "+rSet1.getString("FREELANCER_NAME")+" has agreed to teach "+rSet1.getString("PREFERRED_SUBJECT")+" as you offered.\n";}
							 else if(s.equals("PENDING"))
							 {textStr=textStr+" \u2709 You have requested "+rSet1.getString("FREELANCER_NAME")+" to teach "+rSet1.getString("PREFERRED_SUBJECT")+".\n";}
						}
						da1.close();
					}
					catch(Exception ex)
					{
						System.out.println("Exception occurred at collecting Data");
					} 
				}
				da.close();
			}
			catch(Exception ex)
			{
				System.out.println("Exception occurred at collecting Data");
			}
		 }
		 else if(type.equals("FREELANCER_ID"))
		 {
			 String sql="SELECT * FROM `offerings` WHERE `STATUS` LIKE 'PENDING' AND `FREELANCER_ID` = "+ID;//+" ORDER BY `OFFER_ID` ASC";
			 String s1=" ",sub=" ",s2=" ";
			 try
			{
				DatabaseLink da=new DatabaseLink();
				rSet=da.getProduct(sql);
				while(rSet.next())
				{
					 s1=rSet.getString("STUDENT_ID");
					 offID=rSet.getString("OFFER_ID");
					try
					{
						String sq="SELECT * FROM `student` WHERE `STUDENT_ID` ="+ s1;
						DatabaseLink da1=new DatabaseLink();
						ResultSet rSet1=da1.getProduct(sq);
						while(rSet1.next())
						{
							 {textStr=textStr+" \u2709 "+rSet1.getString("STUDENT_NAME")+" has requested you to teach with salary of "+rSet.getString("SALARY")+" BDT"+".\n";}
						}
						da1.close();
						Button j1=new Button("ACCEPT");
						j1.setBounds(80,408,100,50);
						j.setBounds(200,408,100,50);
						add(j1);
						j1.addActionListener(this);
					}
					catch(Exception ex)
					{
						System.out.println("Exception occurred at collecting Data");
					} 
				}
				da.close();
			}
			catch(Exception ex)
			{
				System.out.println("Exception occurred at collecting Data");
			}
		 }
		 else if(type.equals("PROFESSIONAL_ID"))
		 {
			 String sql="SELECT * FROM `offerings` WHERE `STATUS` LIKE 'PENDING' AND `PROFESSIONAL_ID` = "+ID;//+" ORDER BY `OFFER_ID` ASC";
			 String s1=" ",sub=" ",s2=" ";
			 try
			{
				DatabaseLink da=new DatabaseLink();
				rSet=da.getProduct(sql);
				while(rSet.next())
				{
					 s1=rSet.getString("INSTITUTION_ID");
					 //offID=rSet.getString("OFFER_ID");
					 
					try
					{
						String sq="SELECT * FROM `institution` WHERE `INSTITUTION_ID` ="+s1;
						DatabaseLink da1=new DatabaseLink();
						ResultSet rSet1=da1.getProduct(sq);
						while(rSet1.next())
						{
							 {textStr=textStr+" \u2709 The Head of "+rSet1.getString("INSTITUTION_NAME")+" has requested you to be with them paying a salary of "+rSet.getString("SALARY")+" BDT"+".\n";}
						}
						da1.close();
						Button j1=new Button("ACCEPT REQUEST");
						j1.setBounds(80,408,120,50);
						j.setBounds(220,408,100,50);
						add(j1);
						j1.addActionListener(this);
					}
					catch(Exception ex)
					{
						System.out.println("Exception occurred at collecting Data");
					} 
				}
				da.close();
			}
			catch(Exception ex)
			{
				System.out.println("Exception occurred at collecting Data");
			}
		 }
		 cTeach= new TextArea(textStr,1000,37,TextArea.SCROLLBARS_VERTICAL_ONLY);
		 cTeach.setBounds(0,0,400,400);
		 cTeach.setFont(f1);
		 cTeach.setEditable(false);
		 add(j);add(cTeach);
		 setLayout(null);
		 setLocation(925,450);
		 this.setBackground(new Color(0,0,0));
		 setSize(400,500);
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
		 j.addActionListener(this);
	 }
	 public void paint(Graphics g)
	 {
		 g.setColor(new Color(7,0,41));
		 g.fillRect(0,0,820,500);
		 // g.setColor(new Color(180,180,180));
		 // g.fillRect(0,100,820,400);
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 String sig=e.getActionCommand();
		 if(sig.equals("OK"))
		 {
			 this.setVisible(false);
		 }
		 else if(sig.equals("ACCEPT REQUEST"))
		 {
			 try{
				 DatabaseLink d1=new DatabaseLink();
				 rSet=d1.getProduct("SELECT * FROM `offerings` WHERE `STATUS` LIKE 'PENDING' AND `PROFESSIONAL_ID` = "+ID);
				 while(rSet.next())
				 {
					 String q="UPDATE `offerings` SET `STATUS` = 'ACCEPTED' WHERE `offerings`.`OFFER_ID` = "+rSet.getString("OFFER_ID");
					 String inputValue = JOptionPane.showInputDialog("Please Input The Name of The Institution");
					 offID=rSet.getString("INSTITUTION_ID");
					 try
					 {
						 DatabaseLink dr=new DatabaseLink();
						 ResultSet rS=dr.getProduct("SELECT * FROM `institution` WHERE `INSTITUTION_NAME` LIKE '"+inputValue+"'");
						 while(rS.next())
						 {
							 inputValue=rS.getString("INSTITUTION_ID");
						 }
					 }
					 catch(Exception e1)
					 {
						 System.out.println("Exception occurred at 1collecting Data");
					 }
					 if(offID.equals(inputValue))
					 {
						 try
						 {
							 String l="UPDATE `professional` SET `INSTITUTION_ID` = '"+inputValue+"' WHERE `professional`.`PROFESSIONAL_ID` = "+ID;
							 DatabaseLink d=new DatabaseLink();
							 int i=0,l1=0;
							 i=d.ddlOperation(q);
							 l1=d.ddlOperation(l);
							 if(i!=0&&l1!=0)
							 {
								 JOptionPane.showMessageDialog(null,
								"Accepted The Request",
								"Info:",
								JOptionPane.INFORMATION_MESSAGE);
							 }
						 }
						 catch(Exception ex)
						 {
							System.out.println("Exception occurred at updating Data");
						 }
					 }
					 else
					 {JOptionPane.showMessageDialog(null,
								"Invalid Name",
								"WARNING",
								JOptionPane.WARNING_MESSAGE);}
			 }
			 }
			 catch(Exception ex)
			 {
				 System.out.println("Exception occurred at 2collecting Data");
			 }
		 }
		 else if(sig.equals("ACCEPT"))
		 {
			 try{
				 DatabaseLink d1=new DatabaseLink();
				 rSet=d1.getProduct("SELECT * FROM `offerings` WHERE `STATUS` LIKE 'PENDING' AND `FREELANCER_ID` = "+ID);
				 while(rSet.next())
				 {
					 String q="UPDATE `offerings` SET `STATUS` = 'ACCEPTED' WHERE `offerings`.`OFFER_ID` = "+rSet.getString("OFFER_ID");
					 String inputValue = JOptionPane.showInputDialog("Please Input The Name of The Institution");
					 offID=rSet.getString("STUDENT_ID");
					 try
					 {
						 DatabaseLink dr=new DatabaseLink();
						 ResultSet rS=dr.getProduct("SELECT * FROM `student` WHERE `STUDENT_NAME` LIKE '"+inputValue+"'");
						 while(rS.next())
						 {
							 inputValue=rS.getString("STUDENT_ID");
						 }
					 }
					 catch(Exception e1)
					 {
						 System.out.println("Exception occurred at 1collecting Data");
					 }
					 if(offID.equals(inputValue))
					 {
						 try
						 {
							 String l="INSERT INTO `association_stu_fre` (`STUDENT_ID`, `FREELANCER_ID`) VALUES ('"+inputValue+"', '"+ID+"');";
							 DatabaseLink d=new DatabaseLink();
							 int i=0,l1=0;
							 i=d.ddlOperation(q);
							 l1=d.ddlOperation(l);
							 if(i!=0&&l1!=0)
							 {
								 JOptionPane.showMessageDialog(null,
								"Accepted The Request",
								"Info:",
								JOptionPane.INFORMATION_MESSAGE);
							 }
						 }
						 catch(Exception ex)
						 {
							System.out.println("Exception occurred at updating Data");
						 }
					 }
					 else
					 {JOptionPane.showMessageDialog(null,
								"Invalid Name",
								"WARNING",
								JOptionPane.WARNING_MESSAGE);}
			 }
			 }
			 catch(Exception ex)
			 {
				 System.out.println("Exception occurred at 2collecting Data");
			 }
		 }
	 }
 }
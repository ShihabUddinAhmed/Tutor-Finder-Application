import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 public class RequestForm extends JFrame implements ActionListener
 {
	 private TextArea cTeach;
	 private Font f= new Font(null, Font.BOLD, 20);
	 private Font f1=new Font(null, Font.PLAIN, 18);
	 private Button j,j1;
	 private ResultSet rSet;
	 private String ID="0";
	 public RequestForm(String ID,String cls,String type)
	 {
		 super("Request For Tutor");
		 setResizable(false);
		 System.out.println(ID);
		 this.ID=ID;
		 String textStr=" ID\tContact No.\t\tQualification\tSubject\t\tName\n ";
		 j= new Button("BACK");
		 j.setBounds(200,408,100,50);
		 j1=new Button("REQUEST");
		 j1.setBounds(450,408,100,50);
		 if(type.equals("FREELANCER_ID"))
		 {
			 String sql="SELECT * FROM `freelancer` WHERE `REFERRED_CLASS` LIKE '"+cls+"' ORDER BY `FREELANCER_ID` ASC";
			 String s1=" ",sub=" ",s2=" ";
			 try
			{
				DatabaseLink da=new DatabaseLink();
				rSet=da.getProduct(sql);
				while(rSet.next())
				{
					 textStr=textStr+rSet.getString("FREELANCER_ID")+"\t"+rSet.getString("PHONE_NUMBER")+"\t"+rSet.getString("QUALIFICATION")+"\t"+rSet.getString("PREFERRED_SUBJECT")+"\t\t"+rSet.getString("FREELANCER_NAME")+"\n ";
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
			 String sql="SELECT * FROM `professional` WHERE 1";
			 String s1=" ",sub=" ",s2=" ";
			 try
			{
				DatabaseLink da=new DatabaseLink();
				rSet=da.getProduct(sql);
				while(rSet.next())
				{
					 textStr=textStr+rSet.getString("PROFESSIONAL_ID")+"\t"+rSet.getString("PHONE_NUMBER")+"\t"+rSet.getString("QUALIFICATION")+"\t"+rSet.getString("PREFERRED_SUBJECT")+"\t"+rSet.getString("PROFESSIONAL_NAME")+"\n ";
				}
				da.close();
			}
			catch(Exception ex)
			{
				System.out.println("Exception occurred at collecting Data");
			}
		 }
		 cTeach= new TextArea(textStr,1000,37,TextArea.SCROLLBARS_VERTICAL_ONLY);
		 cTeach.setBounds(0,0,800,400);
		 cTeach.setFont(f1);
		 cTeach.setEditable(false);
		 add(j);add(cTeach);add(j1);
		 setLayout(null);
		 setLocation(925,450);
		 this.setBackground(new Color(0,0,0));
		 setSize(800,500);
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
		 j1.addActionListener(this);
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
		 if(sig.equals("BACK"))
		 {
			 this.setVisible(false);
		 }
		 else if(sig.equals("REQUEST"))
		 {
			 String g=JOptionPane.showInputDialog("Please Give The ID of Teacher for Request: ");
			 if(g.indexOf("5")==0)
			 {
				 try{
				 DatabaseLink d1=new DatabaseLink();
				 rSet=d1.getProduct("SELECT * FROM `freelancer` WHERE `FREELANCER_ID` LIKE "+g);
				 while(rSet.next())
				 {
					 String sal=JOptionPane.showInputDialog("Amount of salary you wanna Request: ");
					 int i=0;
					 i=d1.ddlOperation("INSERT INTO `offerings` (`OFFER_ID`, `PREFERRED_SUBJECT`, `SALARY`, `STATUS`, `STUDENT_ID`, `INSTITUTION_ID`, `FREELANCER_ID`, `PROFESSIONAL_ID`) VALUES (NULL, '"+rSet.getString("PREFERRED_SUBJECT")+"', '"+sal+"', 'PENDING', '"+ID+"', NULL, '"+g+"', NULL);");
					 if(i!=0)
					 {
						 JOptionPane.showMessageDialog(null,
								"Request gone Successfully",
								"INFO:",
								JOptionPane.INFORMATION_MESSAGE);
					 }
					 else
					 {JOptionPane.showMessageDialog(null,
								"Please Try Again!",
								"WARNING",
								JOptionPane.WARNING_MESSAGE);}
				 }
				 d1.close();
				 }
				 catch(Exception ex)
				 {
					 System.out.println("Exception occurred at 2collecting Data");
				 }
			 }
			 else if(g.indexOf("3")==0)
			 {
				 try{
				 DatabaseLink d1=new DatabaseLink();
				 rSet=d1.getProduct("SELECT * FROM `professional` WHERE `PROFESSIONAL_ID` LIKE "+g);
				 String sal=JOptionPane.showInputDialog("Amount of salary you wanna Request: ");
					 
				 while(rSet.next())
				 {
					 int i=0;
					 i=d1.ddlOperation("INSERT INTO `offerings` (`OFFER_ID`, `PREFERRED_SUBJECT`, `SALARY`, `STATUS`, `STUDENT_ID`, `INSTITUTION_ID`, `FREELANCER_ID`, `PROFESSIONAL_ID`) VALUES (NULL, '"+rSet.getString("PREFERRED_SUBJECT")+"', '"+sal+"', 'PENDING', NULL, '"+ID+"', NULL, '"+g+"');");
					 if(i!=0)
					 {
						 JOptionPane.showMessageDialog(null,
								"Request gone Successfully",
								"INFO:",
								JOptionPane.INFORMATION_MESSAGE);
					 }
					 else
					 {JOptionPane.showMessageDialog(null,
								"Please Try Again!",
								"WARNING",
								JOptionPane.WARNING_MESSAGE);}
				 }
				 d1.close();
				 }
				 catch(Exception ex)
				 {
					 System.out.println("Exception occurred at 2collecting Data");
				 }
			 }
		 }
	 }
 }
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 public class HomeFreelancer extends JFrame implements ActionListener
 {
	 private Label l,l2,l3;
	 private TextArea cTeach;
	 private JPasswordField password;
	 public Login parent;
	 private Font f= new Font(null, Font.BOLD, 20);
	 private Font f1=new Font(null, Font.PLAIN, 18);
	 private Button j,j1,j2;
	 private ResultSet rSet;
	 private String ID;
	 public HomeFreelancer(String ID)
	 {
		 super("Tutor Finder Companion");
		 setResizable(false);
		 this.ID=ID;
		 System.out.println(ID);
		 String sql="SELECT * FROM `freelancer` WHERE `FREELANCER_ID` = "+ID;
		 String s="Welcome ",s1=" ",textStr="  Phone-Number		Class		Name Of Students	Salary\n ";
		 try
		{
			DatabaseLink da=new DatabaseLink();
			rSet=da.getProduct(sql);
			while(rSet.next())
			{
				 s1=rSet.getString("FREELANCER_NAME");
				 System.out.println(s1);
			}
			da.close();
		}
		catch(Exception ex)
		{
			System.out.println("Exception occurred at collecting Data");
		}
		 
		 l= new Label(s+s1);
		 l.setBounds(10,10,442,50);
		 l.setFont(f);
		 l2= new Label("Currrent jobs: ");
		 l2.setBounds(10,80,155,50);
		 l2.setFont(f1);
		 l.setBackground(new Color(7,0,41));
		 l.setForeground(new Color(180,180,180));
		 l2.setBackground(new Color(180,180,180));
		 l2.setForeground(new Color(0,0,0));
		 j1= new Button("Notifications");
		 j1.setBounds(630,75,110,50);
		 j1.setFont(new Font(null,Font.BOLD, 15));
		 j= new Button("Log Out");
		 j.setBounds(700,8,100,50);
		 j2= new Button("Profile");
		 j2.setBounds(550,8,100,50);
		  try
			{
				sql="SELECT * FROM `association_stu_fre` WHERE `FREELANCER_ID` = "+ID;
				DatabaseLink da2=new DatabaseLink();
				ResultSet rSet2=da2.getProduct(sql);
				while(rSet2.next())
				{
					 String r=rSet2.getString("STUDENT_ID");
					 System.out.println(r);
					 try
					{
						String sq="SELECT * FROM `student` WHERE `STUDENT_ID` ="+r;//+"ORDER BY `FREELANCER_ID` ASC";
						DatabaseLink da1=new DatabaseLink();
						ResultSet rSet3=da1.getProduct("SELECT * FROM `offerings` WHERE `FREELANCER_ID` = " +ID+ " AND `STUDENT_ID` = " +r+ " ORDER BY `OFFER_ID` ASC");
						ResultSet rSet1=da1.getProduct(sq);
						while(rSet1.next()&&rSet3.next())
						{
							 textStr=textStr+rSet1.getString("PHONE_NUMBER")+"\t\t"+rSet1.getString("CLASS")+"\t\t"+rSet1.getString("STUDENT_NAME")+"\t"+rSet3.getString("SALARY")+"\n ";
							 //System.out.println(textStr);
						}
						da1.close();
					}
					catch(Exception ex2)
					{
						System.out.println("Exception occurred at collecting Data");
					}
				}
				da2.close();
			}
			catch(Exception ex1)
			{
				System.out.println("Exception occurred at collecting Data");
			}
		 cTeach= new TextArea(textStr);
		 cTeach.setBounds(10,133,790,315);
		 cTeach.setFont(f1);
		 cTeach.setEditable(false);
		 add(j1);add(l);add(l2);add(j);add(j2);add(cTeach);
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
		 j.addActionListener(this);
		 j1.addActionListener(this);
		 j2.addActionListener(this);
	 }
	 public void paint(Graphics g)
	 {
		 g.setColor(new Color(7,0,41));
		 g.fillRect(0,0,820,500);
		 g.setColor(new Color(180,180,180));
		 g.fillRect(0,100,820,400);
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 String sig=e.getActionCommand();
		 if(sig.equals("Log Out"))
		 {
			 this.setVisible(false);
			 Login l=new Login();
			 l.setVisible(true);
			 l.parent=parent.parent;
		 }
		 else if(sig.equals("Notifications"))
		 {
			 Notifications n=new Notifications(ID,"FREELANCER_ID");
			 n.setVisible(true);
		 }
		 else if(sig.equals("Profile"))
		 {
			 ProfileF p=new ProfileF(ID);
			 p.parent=this;
			 this.setVisible(false);
			 p.setVisible(true);
		 }
	 }
 }
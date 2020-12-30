import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 public class HomeInstitution extends JFrame implements ActionListener
 {
	 private Label l,l2,l3;
	 private TextArea cTeach;
	 private JPasswordField password;
	 public Login parent;
	 private String ID;
	 private Font f= new Font(null, Font.BOLD, 20);
	 private Font f1=new Font(null, Font.PLAIN, 18);
	 private Button j,j1,j2,j3;
	 private ResultSet rSet;
	 public HomeInstitution(String ID)
	 {
		 super("Tutor Finder Companion");
		 setResizable(false);
		 this.ID=ID;
		 System.out.println(ID);
		 String sql="SELECT * FROM `institution` WHERE `INSTITUTION_ID` = "+ID;
		 String s="Welcome ",s1=" ";
		 try
		 {
			DatabaseLink da=new DatabaseLink();
			rSet=da.getProduct(sql);
			while(rSet.next())
			{
				 s1=rSet.getString("INSTITUTION_NAME");
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
		 l2= new Label("Currrent Teachers: ");
		 l2.setBounds(10,70,155,50);
		 l2.setFont(f1);
		 l.setBackground(new Color(7,0,41));
		 l.setForeground(new Color(180,180,180));
		 l2.setBackground(new Color(180,180,180));
		 l2.setForeground(new Color(0,0,0));
		 j1= new Button("Notifications");
		 j1.setBounds(650,120,110,50);
		 j1.setFont(new Font(null,Font.BOLD, 15));
		 j= new Button("Log Out");
		 j.setBounds(700,8,100,50);
		 j2= new Button("Profile");
		 j2.setBounds(550,8,100,50);
		 j3= new Button("Request Tutor");
		 j3.setBounds(620,220,180,70);
		 j3.setFont(new Font(null, Font.BOLD,20));
		 sql="SELECT * FROM `professional` WHERE `INSTITUTION_ID` ="+ID;
		 String textStr="  Subject			Name Of Teachers	SALARY\n\n ";
		 try
		 {
			DatabaseLink da2=new DatabaseLink();
			ResultSet rSet2=da2.getProduct(sql);
			while(rSet2.next())
			{
				String r=rSet2.getString("PROFESSIONAL_ID");
				 try
				 {
					DatabaseLink da1=new DatabaseLink();
					ResultSet rSet1=da1.getProduct("SELECT * FROM `offerings` WHERE `INSTITUTION_ID` = " +ID+ " AND `PROFESSIONAL_ID` = " +r+ " ORDER BY `OFFER_ID` ASC");
					while(rSet1.next())
					{
						 textStr=textStr+rSet2.getString("PREFERRED_SUBJECT")+"\t\t"+rSet2.getString("PROFESSIONAL_NAME")+"\t"+rSet1.getString("SALARY")+"\n ";
					}
					da1.close();
				 }
				catch(Exception ex)
				 {
					System.out.println("Exception occurred at collecting Data");
				 }
				 //textStr=textStr+rSet1.getString("PREFERRED_SUBJECT")+"\t\t"+rSet1.getString("PROFESSIONAL_NAME")+"\n ";
			}
			da2.close();
		 }
		catch(Exception ex)
		 {
			System.out.println("Exception occurred at collecting Data");
		 }
		 cTeach= new TextArea(textStr);
		 cTeach.setBounds(10,120,600,300);
		 cTeach.setFont(f1);
		 cTeach.setEditable(false);
		 add(j1);add(l);add(l2);add(j);add(j2);add(j3);add(cTeach);
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
		 j3.addActionListener(this);
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
			 Notifications n=new Notifications(ID,"INSTITUTION_ID");
			 n.setVisible(true);
		 }
		 else if(sig.equals("Profile"))
		 {
			 ProfileI p=new ProfileI(ID);
			 p.parent=this;
			 this.setVisible(false);
			 p.setVisible(true);
		 }
		 else if(sig.equals("Request Tutor"))
		 {
			 RequestForm r=new RequestForm(ID," ","PROFESSIONAL_ID");
			 r.setVisible(true);
		 }
	 }
 }
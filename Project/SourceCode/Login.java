import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
 public class Login extends JFrame implements ActionListener
 {
	 private Label l,l2,l3;
	 private JTextField email;
	 private JPasswordField password;
	 public JFrame parent;
	 private Font f= new Font(null, Font.BOLD, 20);
	 private Font f1=new Font(null, Font.PLAIN, 18);
	 private Button j,j1;
	 private ResultSet rSet;
	 public Login()
	 {
		 super("Tutor Finder Companion");
		 setResizable(false);
		 l= new Label("Please give your E-mail and Password:");
		 l.setBounds(180,100,368,50);
		 l.setFont(f);
		 l2= new Label("Email           :");
		 l2.setBounds(200,150,108,50);
		 l2.setFont(f1);
		 l.setBackground(new Color(180,180,180));
		 l.setForeground(new Color(0,0,0));
		 l2.setBackground(new Color(180,180,180));
		 l2.setForeground(new Color(0,0,0));
		 j1= new Button("Cancel");
		 j1.setBounds(390,300,100,50);
		 j= new Button("Log In");
		 j.setBounds(240,300,100,50);
		 l3= new Label("Password    :");
		 l3.setFont(new Font(null, Font.PLAIN, 18));
		 l3.setBounds(200,200,108,50);
		 l3.setForeground(new Color(0,0,0));
		 l3.setBackground(new Color(180,180,180));
		 email= new JTextField(40);
		 email.setBounds(308,160,220,30);
		 email.setFont(f1);
		 password=new JPasswordField(50);
		 password.setBounds(308,210,220,30);
		 password.setFont(f1);
		 password.setEchoChar('\u26AB');
		 add(j1);add(l);add(l2);add(j);add(l3);add(email);add(password);
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
	 }
	 public void paint(Graphics g)
	 {
		 g.setColor(new Color(0,0,0));
		 g.fillRect(0,0,820,500);
		 g.setColor(new Color(180,180,180));
		 g.fillRect(150,0,470,500);
	 }
	 private boolean checkAuth(){
		boolean flag=false;
		char[] s=password.getPassword();
		String pSWd=new String(s);
		String sql="SELECT * FROM `account` WHERE `EMAIL` LIKE '"+email.getText()+"' AND `PASSWORD` LIKE '"+pSWd+"' ORDER BY `ACCOUNT_ID` ASC";
		//System.out.println(sql);
		try{
			DatabaseLink da=new DatabaseLink();
			rSet=da.getProduct(sql);
			while(rSet.next())
			{
				flag=true;
			}
			da.close();
		}
		catch(Exception ex){
			System.out.println("Exception occurred at Authentication");
		}
		return flag;
	}
	 public void actionPerformed(ActionEvent e)
	 {
		 String sig=e.getActionCommand();
		 char[] s=password.getPassword();
				 String pSWd=new String(s);
		 boolean flag=false;
		 if(sig.equals("Cancel"))
		 {
			 this.setVisible(false);
			 parent.setVisible(true);
		 }
		 else if(sig.equals("Log In"))
		 {
			 try{DatabaseLink d=new DatabaseLink();
				 ResultSet r=d.getProduct("SELECT * FROM `administrator` WHERE `ADMINISTRATOR _ID` LIKE '"+email.getText()+"' AND `PASSWORD` LIKE '"+pSWd+"'");
				 while(r.next())
				 {
					 flag=true;
				 }
				 d.close();
			 }
			 catch(Exception exc)
			 {
				 System.out.println("Error from Administrator");
			 }
			 if(this.checkAuth()==true)
			 {
				 String s1=" ",s2=" ",s3=" ",s4=" ",s5=" ";
				String sql="SELECT * FROM `account` WHERE `EMAIL` LIKE '"+email.getText()+"' AND `PASSWORD` LIKE '"+pSWd+"' ORDER BY `ACCOUNT_ID` ASC";
				//System.out.println(sql);
				try{
					DatabaseLink da=new DatabaseLink();
					rSet=da.getProduct(sql);
					while(rSet.next())
					{
						 s1=rSet.getString("ACCOUNT_TYPE");
						 System.out.println(s1);
						 s2=rSet.getString("STUDENT_ID");
						 s3=rSet.getString("FREELANCER_ID");
						 s4=rSet.getString("INSTITUTION_ID");
						 s5=rSet.getString("PROFESSIONAL_ID");
						 //System.out.println(s2+s3+s4+s5);
					}
					da.close();
				}
				catch(Exception ex){
					System.out.println("Exception occurred at Getting Data");
				}
				
				if(s1.equals("student"))
				{
					System.out.println(s2+s3+s4+s5);
					HomeStudent sUp=new HomeStudent(s2);
					this.setVisible(false);
					sUp.setVisible(true);
					sUp.parent=this;
				}
				else if(s1.equals("freelancer"))
				{
					HomeFreelancer sUpF=new HomeFreelancer(s3);
					this.setVisible(false);
					sUpF.setVisible(true);
					sUpF.parent=this;
				}
				else if(s1.equals("institution"))
				{
					HomeInstitution sUpI=new HomeInstitution(s4);
					this.setVisible(false);
					sUpI.setVisible(true);
					sUpI.parent=this;
				}
				else if(s1.equals("professional"))
				{
					HomeProfessional sUpP=new HomeProfessional(s5);
					this.setVisible(false);
					sUpP.setVisible(true);
					sUpP.parent=this;
				}
			 }
			 
			 else if(flag==true)
			 {
				 this.setVisible(false);
				 while(flag)
				 {
				 System.out.println("Welcome Sir!");
				 Scanner scan=new Scanner(System.in);
				 System.out.println("Enter the SQL: ");
						 String sq=scan.nextLine();
				 //int i=scan.nextInt();
				 
				 try
				 {
					 DatabaseLink d4=new DatabaseLink();
					 if(sq.substring(0,6).equals("SELECT"))
					 {
						 ResultSet r=d4.getProduct(sq);
						 System.out.println("Enter the Column name: ");
						 String ql=scan.nextLine();
						 while(r.next())
						 {
							 System.out.println(r.getString(ql));
						 }
						 System.out.println("Wanna Do more? yes/no");
						 String h1=scan.nextLine();
						 if(h1.equals("no"))
						 {flag=false;}
						 
					 }
					 else
					 {
						 
						 int k=d4.ddlOperation(sq);
					 }
				 }
				 catch(Exception e3)
				 {
					 System.out.println("Administrator Fault");
				 }
				 }
				 System.out.println("Thanks for Your Contribution Sir...");
				 this.setVisible(true);
			 }
			 else
			 {JOptionPane.showMessageDialog(null,
				 "Invalid E-mail or Password.\n Plaese Check Again...",
				 "Warning",
				 JOptionPane.WARNING_MESSAGE);}
		 }
	 }
 }
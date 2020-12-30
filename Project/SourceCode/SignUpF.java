import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 public class SignUpF extends JFrame implements ActionListener
 {
	 private Label l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	 private JTextField name, email, cls, contact, address, prefferedSub, qualification;
	 private JPasswordField password, passwordC;
	 public JFrame parent;
	 private Font f= new Font(null, Font.BOLD, 20);
	 private Font f1=new Font(null, Font.PLAIN, 18);
	 private Button j,j1;
	 public SignUpF()
	 {
		 super("Tutor Finder Companion");
		 setResizable(false);
		 l= new Label("*All Fields are required...");
		 l.setBounds(50,0,140,50);
		 l.setFont(new Font(null, Font.BOLD, 12));
		 l1= new Label("Registration For Freelancer Teachers: ");
		 l1.setBounds(248,0,415,50);
		 l1.setFont(f);
		 l1.setForeground(new Color(0,0,0));
		 l1.setBackground(new Color(180,180,180));
		 l2= new Label("Name           :");
		 l2.setBounds(65,50,108,50);
		 l2.setFont(f1);
		 l.setBackground(new Color(0,0,0));
		 l.setForeground(new Color(255,38,0));
		 l2.setBackground(new Color(0,0,0));
		 l2.setForeground(new Color(180,180,180));
		 j1= new Button("Cancel");
		 j1.setBounds(650,300,100,50);
		 j= new Button("Register");
		 j.setBounds(650,200,100,50);
		 l4= new Label("E-mail          :");
		 l4.setFont(f1);
		 l4.setBounds(65,100,108,50);
		 l4.setForeground(new Color(180,180,180));
		 l4.setBackground(new Color(0,0,0));
		 l5= new Label("Reffered Class  :");
		 l5.setFont(f1);
		 l5.setBounds(37,150,158,50);
		 l5.setForeground(new Color(180,180,180));
		 l5.setBackground(new Color(0,0,0));
		 l6= new Label("Contact No  :");
		 l6.setFont(f1);
		 l6.setBounds(65,200,108,50);
		 l6.setForeground(new Color(180,180,180));
		 l6.setBackground(new Color(0,0,0));
		 l7= new Label("Address       :");
		 l7.setFont(f1);
		 l7.setBounds(65,250,108,50);
		 l7.setForeground(new Color(180,180,180));
		 l7.setBackground(new Color(0,0,0));
		 l9= new Label("Preffered Subject  :");
		 l9.setFont(f1);
		 l9.setBounds(18,300,158,50);
		 l9.setForeground(new Color(180,180,180));
		 l9.setBackground(new Color(0,0,0));
		 l10= new Label("Qualification  :");
		 l10.setFont(f1);
		 l10.setBounds(57,350,158,50);
		 l10.setForeground(new Color(180,180,180));
		 l10.setBackground(new Color(0,0,0));
		 l3= new Label("Password    :");
		 l3.setFont(f1);
		 l3.setBounds(67,400,108,50);
		 l3.setForeground(new Color(180,180,180));
		 l3.setBackground(new Color(0,0,0));
		 l8= new Label("Re-Type Password :");
		 l8.setFont(f1);
		 l8.setBounds(7,450,168,50);
		 l8.setForeground(new Color(180,180,180));
		 l8.setBackground(new Color(0,0,0));
		 name= new JTextField(30);
		 name.setBounds(308,60,320,30);
		 name.setFont(f1);
		 email= new JTextField(40);
		 email.setBounds(308,110,320,30);
		 email.setFont(f1);
		 contact= new JTextField(14);
		 contact.setBounds(308,210,320,30);
		 contact.setFont(f1);
		 address= new JTextField(30);
		 address.setBounds(308,260,320,30);
		 address.setFont(f1);
		 cls= new JTextField(10);
		 cls.setBounds(308,160,320,30);
		 cls.setFont(f1);
		 prefferedSub= new JTextField(20);
		 prefferedSub.setBounds(308,310,320,30);
		 prefferedSub.setFont(f1);
		 qualification= new JTextField(15);
		 qualification.setBounds(308,360,320,30);
		 qualification.setFont(f1);
		 password=new JPasswordField(50);
		 password.setBounds(308,410,320,30);
		 password.setFont(f1);
		 password.setEchoChar('\u26AB');
		 passwordC=new JPasswordField(50);
		 passwordC.setBounds(308,460,320,30);
		 passwordC.setFont(f1);
		 passwordC.setEchoChar('\u26AB');
		 add(l1);add(j1);add(l);add(l2);add(j);add(l3);add(name);add(password);add(l4);add(l5);add(l6);add(l7);add(l8);add(email);add(contact);add(address);add(passwordC);add(cls);add(l9);add(l10);add(prefferedSub);add(qualification);
		 setLayout(null);
		 setLocation(525,300);
		 this.setBackground(new Color(0,0,0));
		 setSize(820,550);
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
		 g.fillRect(0,0,820,550);
		 g.setColor(new Color(180,180,180));
		 g.fillRect(250,0,820,550);
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 String sig=e.getActionCommand();
		 if(sig.equals("Cancel"))
		 {
			 this.setVisible(false);
			 parent.setVisible(true);
		 }
		 else if(sig.equals("Register"))
		 {
			 
			 int u=0,u1=0;
			 char[] q=password.getPassword();
			 char[] q1=passwordC.getPassword();
			 String w=new String(q);
			 String w1=new String(q1);
			 System.out.println(name.getText()+"-"+email.getText()+"-"+w);
			 String sql="INSERT INTO `freelancer` (`FREELANCER_NAME`,`PHONE_NUMBER`,`QUALIFICATION`,`PREFERRED_SUBJECT`,`REFERRED_CLASS`) VALUES ('"+name.getText()+"','"+contact.getText()+"','"+qualification.getText()+"','"+prefferedSub.getText()+"','"+cls.getText()+"');";
			 if(name.getText().equals("") && email.getText().equals("") && w.equals(""))
			 {
				 JOptionPane.showMessageDialog(null,
						"Empty feilds found!",
						"WARNING",
						JOptionPane.WARNING_MESSAGE);
				
			 }
			 else
			 {
				 if(w.equals(w1))
				 {
					 try
					 {
						 DatabaseLink da=new DatabaseLink();
						 ResultSet rSet=da.getProduct("SELECT * FROM `address` WHERE 1");
						 while(rSet.next())
						 {
							 String q2=rSet.getString("CITY");
							 String q3=address.getText();
							 if(q2.equals(q3))
							 {
								 sql="INSERT INTO `freelancer` (`FREELANCER_NAME`,`PHONE_NUMBER`,`QUALIFICATION`,`PREFERRED_SUBJECT`,`REFERRED_CLASS`, `ADDRESS_ID`) VALUES ('"+name.getText()+"','"+contact.getText()+"', '"+qualification.getText()+"','"+prefferedSub.getText()+"','"+cls.getText()+"','"+rSet.getString("ADDRESS_ID")+"');";
							 }
							 
							 
							 
						 }
						 u=da.ddlOperation(sql);
							 String sq="SELECT * FROM `freelancer` WHERE `FREELANCER_NAME` LIKE '"+name.getText()+"' AND `PHONE_NUMBER` LIKE '"+contact.getText()+"'";
							 ResultSet rSet1=da.getProduct(sq);
							 String sq1=" ";
							 while(rSet1.next())
							 {
								 sq1=rSet1.getString("FREELANCER_ID");
							 }
							 String sql1="INSERT INTO `account` (`EMAIL`, `PASSWORD`, `ACCOUNT_TYPE`, `STUDENT_ID`, `FREELANCER_ID`, `INSTITUTION_ID`, `PROFESSIONAL_ID`) VALUES ('"+email.getText()+"', '"+w+"', 'freelancer', NULL,'"+sq1+"', NULL, NULL);";
							 u1=da.ddlOperation(sql1);
						 da.close();
					 }
					 catch(Exception ex)
					 {
						 System.out.println("Error at insertion...");
					 }
					 
				 }
				 if(u==1&&u1==1)
				 {
					 JOptionPane.showMessageDialog(null,
							"Thanks for Subscribtion",
							"INFO:",
							JOptionPane.INFORMATION_MESSAGE);
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null,
							"Please Try Again",
							"WARNING",
							JOptionPane.WARNING_MESSAGE);
				 }
			 }
		 }
	 }
 }
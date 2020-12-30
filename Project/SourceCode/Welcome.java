import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 public class Welcome extends JFrame implements ActionListener
 {
	 private Label l,l2,l3;
	 private Font f= new Font(null, Font.BOLD, 44);
	 private Font f1=new Font(null, Font.PLAIN, 36);
	 private Button j,j1;
	 public Welcome()
	 {
		 super("Tutor Finder Companion");
		 setResizable(false);
		 l= new Label("Welcome To");
		 l.setBounds(300,100,263,50);
		 l.setFont(f);
		 l2= new Label("...Tutor Finder Companion...");
		 l2.setBounds(200,150,447,50);
		 l2.setFont(f1);
		 l.setBackground(new Color(91,92,89));
		 l.setForeground(new Color(0,0,0));
		 l2.setBackground(new Color(91,92,89));
		 l2.setForeground(new Color(0,0,0));
		 j1= new Button("Sign Up");
		 j1.setBounds(450,300,100,50);
		 j= new Button("Log In");
		 j.setBounds(300,300,100,50);
		 l3= new Label("\u00a9 copyright: Shihab-Faiyaz Software Development.");
		 l3.setFont(new Font(null, Font.PLAIN, 12));
		 l3.setBounds(535,445,275,20);
		 l3.setForeground(new Color(255,255,255));
		 l3.setBackground(new Color(0,0,0));
		 add(j1);add(l);add(l2);add(j);add(l3);
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
		 g.setColor(new Color(55,55,55));
		 g.fillRoundRect(0,0,820,500,700,400);
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 String sig=e.getActionCommand();
		 if(sig.equals("Log In"))
		 {
			 Login l=new Login();
			 l.parent=this;
			 this.setVisible(false);
			 l.setVisible(true);
		 }
		 else if(sig.equals("Sign Up"))
		 {
			 Object[] options = { "Student", "Institution", "Freelancer", "Proffessional" };
			int h=JOptionPane.showOptionDialog(null, "Select Type of Your Account: ", "Navigate",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			null, options, options[0]);
			//System.out.println(h);
			if(h==0)
			{
				SignUpS r=new SignUpS();
				r.parent=this;
				this.setVisible(false);
				r.setVisible(true);
			}
			else if(h==1)
			{
				SignUpI r=new SignUpI();
				r.parent=this;
				this.setVisible(false);
				r.setVisible(true);
			}
			else if(h==2)
			{
				SignUpF d=new SignUpF();
				d.parent=this;
				this.setVisible(false);
				d.setVisible(true);
			}
			else if(h==3)
			{
				SignUpP d=new SignUpP();
				d.parent=this;
				this.setVisible(false);
				d.setVisible(true);
			}
		 }
	 }
 }
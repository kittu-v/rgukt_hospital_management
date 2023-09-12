package hospitalmanagement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import com.toedter.calendar.JDateChooser;
public class management extends JFrame implements ActionListener {

	JButton sub,view;JTextField box,t;JComboBox dept;JTextField id;JTextField no;JTextField r;
	JDateChooser a;
	
	management(){
		
		JLabel name=new JLabel("NAME:");
		name.setBounds(150, 210, 1200, 60);
		name.setFont(new Font("Sanserif",Font.BOLD,20));
		name.setForeground(Color.white);
		name.setBackground(Color.white);
		add(name);
		
		box=new JTextField();
		box.setBounds(230,230,130,20);
		//box.setBackground(Color.LIGHT_GRAY);
		add(box);
		
		
		JLabel branch=new JLabel("DEPARTMENT:");
		branch.setBounds(500, 210, 1200, 60);
		branch.setFont(new Font("Sansserif",Font.BOLD,20));
		branch.setForeground(Color.white);
		branch.setBackground(Color.white);
		add(branch);
		
		String Depart[]= {"CHOOSE","PUC-I","PUC-II","CSE","EEE","ECE","MECH","CIVIL","CHEM","MME"};
		dept=new JComboBox(Depart);
		dept.setBounds(650, 230, 130, 20);
		add(dept);
		
		
        
        JLabel sid=new JLabel("ID NO:");
		sid.setBounds(150, 290, 1200, 60);
		sid.setFont(new Font("Sanserif",Font.BOLD,20));
		sid.setForeground(Color.white);
		sid.setBackground(Color.white);
		add(sid);
		
		id=new JTextField("B");
		id.setBounds(230,310,130,20);
		//id.setBackground(Color.LIGHT_GRAY);
		add(id);
		
		
		
		JLabel mbl=new JLabel("MOBILE NO :");
		mbl.setBounds(500, 290, 1200, 60);
		mbl.setFont(new Font("Sanserif",Font.BOLD,20));
		mbl.setForeground(Color.white);
		mbl.setBackground(Color.white);
		add(mbl);
		
		no=new JTextField();
		no.setBounds(650,310,130,20);
		//no.setBackground(Color.LIGHT_GRAY);
		add(no);
		
		
		JLabel reason=new JLabel("REASON :");
		reason.setBounds(150, 370, 1200, 60);
		reason.setFont(new Font("Sanserif",Font.BOLD,20));
		reason.setForeground(Color.white);
		reason.setBackground(Color.white);
		add(reason);
		
		r=new JTextField();
		r.setBounds(260,390,130,20);
		//r.setBackground(Color.LIGHT_GRAY);
		add(r);
				
		JLabel date=new JLabel("DATE :");
	    date.setBounds(710, 370, 1200, 60);
		date.setFont(new Font("Sanserif",Font.BOLD,20));
		date.setForeground(Color.white);
		date.setBackground(Color.white);
		add(date);
				
		a=new JDateChooser();
		a.setBounds(780, 390, 130, 20);
		add(a);
		
		JLabel time=new JLabel("TIME :");
		time.setBounds(500, 370, 1200, 60);
		time.setFont(new Font("Sanserif",Font.BOLD,20));
		time.setForeground(Color.white);
		time.setBackground(Color.white);
		add(time);
		
		t=new JTextField();
		t.setBounds(570,390,130,20);
		t.setForeground(Color.MAGENTA);
		t.setBackground(Color.white);
		//t.setFont(new Font("Sanserif",Font.BOLD,19));
		add(t);
		
        
        
		sub=new JButton("SUBMIT");
		sub.setBounds(400, 500, 100, 40);
		sub.setForeground(Color.black);
		//sub.setBackground(Color.white);
		add(sub);
		sub.addActionListener(this);
		
		view=new JButton("VIEW DATA");
		view.setBounds(550, 500, 100, 40);
		view.setForeground(Color.black);
		//sub.setBackground(Color.white);
		add(view);
		view.addActionListener(this);
		
		
		
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/rgukt.png"));
		Image img2=img.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel image=new JLabel(img3);
		image.setBounds(0, 10, 1170, 650);
		add(image);
		
		
		
		
		setTitle("ENTER DATA");
		setLayout(null);
		setSize(1190,690);
		setLocation(60,20);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}
	public static void main(String args[]) {
		new management();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	    if(e.getSource()==sub) {
	    	String name=box.getText();
	    	String idno=id.getText();
	    	String mobno=no.getText();
	    	String reas=r.getText();
	    	String date=((JTextField)a.getDateEditor().getUiComponent()).getText();
	    	String department=(String) dept.getSelectedItem();
	    	String time=t.getText();
	    	
	    	try {
	    		conn b=new conn();
	    		String query="insert into patientrecord values('"+name+"','"+idno+"','"+mobno+"','"+reas+"','"+date+"','"+department+"','"+time+"')";
	    		b.s.executeUpdate(query);
	    		JOptionPane.showMessageDialog(null, "SUBMITTED SUCCESSFULLY");
	    		setVisible(false);
	    		new management();
	    	}catch(Exception e1) {
	    		e1.printStackTrace();
	    	}
	    	
	    }
	    else if(e.getSource()==view) {
	    	setVisible(false);
	    	new view();
	    }
	}
}

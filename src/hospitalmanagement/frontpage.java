package hospitalmanagement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class frontpage extends JFrame implements ActionListener {
	JButton sub=new JButton("ADMIN LOGIN");
	//JFrame frame=new JFrame();
	frontpage(){
		

		//JButton sub=new JButton("ADMIN LOGIN");
		sub.setBounds(280, 330, 200, 80);
		sub.setForeground(Color.black);
		sub.setFocusable(false);
		sub.addActionListener(this);
		//sub.setBackground(Color.white);
		add(sub);
		
		
		
		
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/front.png"));
		Image img2=img.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel image=new JLabel(img3);
		image.setBounds(0, 10, 1170, 650);
		add(image);
		
		
		//setLayout(null);
		setSize(1080,800);
		setLocation(90,50);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		frontpage rgu=new frontpage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sub) {
			setVisible(false);
			adminlogin a=new adminlogin();
		}
	}
}

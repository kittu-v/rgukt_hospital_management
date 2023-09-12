package hospitalmanagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class view extends JFrame implements ActionListener {
JDateChooser date;JTable table; JButton ok,back,print;//ResultSet rs;
	view(){
		
		JLabel search=new JLabel("VIEW BY DATE :");
		search.setBounds(60, 30, 1200, 60);
		search.setFont(new Font("Sanserif",Font.BOLD,20));
		search.setForeground(Color.black);
		search.setBackground(Color.white);
		add(search);
		
		JLabel tname=new JLabel("NAME");
		tname.setBounds(10, 80, 1200, 60);
		tname.setFont(new Font("Acme",Font.BOLD,15));
		tname.setForeground(Color.red);
		add(tname);

		JLabel tidno=new JLabel("ID NO");
		tidno.setBounds(135, 80, 1200, 60);
		tidno.setFont(new Font("Acme",Font.BOLD,15));
		tidno.setForeground(Color.red);
		add(tidno);
		
		JLabel tmob=new JLabel("MOB NO");
		tmob.setBounds(260, 80, 1200, 60);
		tmob.setFont(new Font("Acme",Font.BOLD,15));
		tmob.setForeground(Color.red);
		add(tmob);
		
		JLabel tres=new JLabel("REASON");
		tres.setBounds(385, 80, 1200, 60);
		tres.setFont(new Font("Acme",Font.BOLD,15));
		tres.setForeground(Color.red);
		add(tres);
		
		JLabel tdept=new JLabel("DEPARTMENT");
		tdept.setBounds(640, 80, 1200, 60);
		tdept.setFont(new Font("Acme",Font.BOLD,15));
		tdept.setForeground(Color.red);
		add(tdept);
		
		JLabel t=new JLabel("DATE");
		t.setBounds(515, 80, 1200, 60);
		t.setFont(new Font("Acme",Font.BOLD,15));
		t.setForeground(Color.red);
		add(t);
		
		JLabel time=new JLabel("TIME");
		time.setBounds(770, 80, 1200, 60);
		time.setFont(new Font("Acme",Font.BOLD,15));
		time.setForeground(Color.red);
		add(time);

		date=new JDateChooser();
		date.setBounds(220, 50, 130, 20);
		add(date);
		
		back=new JButton("BACK");
		back.setBounds(60, 80, 80, 20);
		back.setForeground(Color.black);
		//sub.setBackground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ok=new JButton("OK");
		ok.setBounds(360, 50, 80, 20);
		ok.setForeground(Color.black);
		//sub.setBackground(Color.white);
		add(ok);
		ok.addActionListener(this);
		
		print=new JButton("PRINT");
		print.setBounds(160, 80, 80, 20);
		print.setForeground(Color.black);
		//sub.setBackground(Color.white);
		add(print);
		print.addActionListener(this);
		
		
		table=new JTable();
		table.setBounds(5,120,890,600);
		add(table);
		table.setBackground(Color.white);
		table.setForeground(Color.BLUE);
		try {
	    conn dateview=new conn();
	    ResultSet r=dateview.s.executeQuery("select * from patientrecord");
        table.setModel(DbUtils.resultSetToTableModel(r));
		}catch(Exception e) {
			e.printStackTrace();
		}
		JScrollPane scroll=new JScrollPane();
		scroll.setBounds(0, 100, 900, 600);
		add(scroll);
		
		setLayout(null);
		setSize(900,700);
		setLocation(60,20);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ok) {
			String datesearch=((JTextField)date.getDateEditor().getUiComponent()).getText();
			//String query="select * from patientrecord where date='"+datesearch+"'";
			//String coloumn[]= {"NAME","ID NO","MOB NO","REASON","DATE","DEPARTMENT","TIME"};
		try {
			conn c=new conn();
			ResultSet r=c.s.executeQuery("select * from patientrecord where date='"+datesearch+"'");
			table.setModel(DbUtils.resultSetToTableModel(r));
        }catch(Exception e1) {
			e1.printStackTrace();
		}
	}else if(e.getSource()==back){
		setVisible(false);
		new management();
	}else if(e.getSource()==print) {
		try {
			table.print();
		} catch (PrinterException e1) {
			e1.printStackTrace();
		}
	}
	else {
		setVisible(false);
	}
	}
		public static void main(String args[]){
			new view();
		}
	}	



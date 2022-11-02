package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class DetailCustomer  {
	public void open() {
		JFrame f = new JFrame();
		f.setSize(300,300);
		f.setTitle("고객 특이사항");
		f.getContentPane().setLayout(null);
		
		JTextArea t1 = new JTextArea();
		t1.setBounds(30, 22, 223, 183);
		f.getContentPane().add(t1);
		
		JButton b1 = new JButton("저장");
		b1.setBounds(30, 228, 97, 23);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("불러오기");
		b2.setBounds(156, 228, 97, 23);
		f.getContentPane().add(b2);
		f.setVisible(true);
			
	} 
}

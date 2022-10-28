
package practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("Page1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Page1 page = new Page1();
				page.open();
			}
		});
		btn1.setBounds(131, 175, 91, 23);
		f.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("Page2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Page2 page = new Page2();
				page.open();
			}
		});
		btn2.setBounds(261, 175, 91, 23);
		f.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("Page3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Page3 page = new Page3();
//				page.open();
			}
		});
		btn3.setBounds(131, 230, 91, 23);
		f.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("Page4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Page4 page = new Page4();
				page.open();
			}
		});
		btn4.setBounds(261, 230, 91, 23);
		f.getContentPane().add(btn4);
		f.setVisible(true);
	}
}

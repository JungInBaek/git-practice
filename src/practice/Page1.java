package practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Page1 {
	public void open() {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		
		JButton btn1 = new JButton("b1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		JButton btn2 = new JButton("b2");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		JButton btn3 = new JButton("b3");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		f.setVisible(true);
	}
}

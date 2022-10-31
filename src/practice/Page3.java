package practice;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Page3 {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
	private static JTextField tf4;
	private static JTextField tf5;
	private static JTextField tf6;
	private static JTextField tf7;
	private static JTextField tf8;
//	public void open() {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("상품판매");
		f.setSize(745, 612);
		f.getContentPane().setLayout(null);
		
		tf1 = new JTextField();
		tf1.setBounds(81, 156, 39, 21);
		f.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(265, 156, 39, 21);
		f.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(444, 156, 39, 21);
		f.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(621, 156, 39, 21);
		f.getContentPane().add(tf4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(81, 330, 39, 21);
		f.getContentPane().add(tf5);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		tf6.setBounds(265, 330, 39, 21);
		f.getContentPane().add(tf6);
		
		tf7 = new JTextField();
		tf7.setColumns(10);
		tf7.setBounds(444, 330, 39, 21);
		f.getContentPane().add(tf7);
		
		tf8 = new JTextField();
		tf8.setColumns(10);
		tf8.setBounds(621, 330, 39, 21);
		f.getContentPane().add(tf8);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(39, 376, 666, 175);
		f.getContentPane().add(textArea);
		
		JButton b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.setText("아메리카노");
			}
		});
		b1.setBounds(39, 30, 121, 116);
		f.getContentPane().add(b1);
		
		JButton b1_1 = new JButton("-");
		b1_1.setBounds(39, 155, 39, 23);
		f.getContentPane().add(b1_1);
		
		JButton b1_2 = new JButton("+");
		b1_2.setBounds(121, 155, 39, 23);
		f.getContentPane().add(b1_2);
		
		JButton b2 = new JButton("");
		b2.setBounds(223, 30, 121, 116);
		f.getContentPane().add(b2);
		
		JButton b2_1 = new JButton("-");
		b2_1.setBounds(223, 155, 39, 23);
		f.getContentPane().add(b2_1);
		
		JButton b2_2 = new JButton("+");
		b2_2.setBounds(305, 155, 39, 23);
		f.getContentPane().add(b2_2);
		
		JButton b3 = new JButton("");
		b3.setBounds(402, 30, 121, 116);
		f.getContentPane().add(b3);
		
		JButton b3_1 = new JButton("-");
		b3_1.setBounds(402, 155, 39, 23);
		f.getContentPane().add(b3_1);
		
		JButton b3_2 = new JButton("+");
		b3_2.setBounds(484, 155, 39, 23);
		f.getContentPane().add(b3_2);
		
		JButton b4 = new JButton("");
		b4.setBounds(580, 30, 121, 116);
		f.getContentPane().add(b4);
		
		JButton b4_1 = new JButton("-");
		b4_1.setBounds(580, 155, 39, 23);
		f.getContentPane().add(b4_1);
		
		JButton b4_2 = new JButton("+");
		b4_2.setBounds(662, 155, 39, 23);
		f.getContentPane().add(b4_2);
		
		JButton b8 = new JButton("");
		b8.setBounds(580, 204, 121, 116);
		f.getContentPane().add(b8);
		
		JButton b8_1 = new JButton("-");
		b8_1.setBounds(580, 329, 39, 23);
		f.getContentPane().add(b8_1);
		
		JButton b8_2 = new JButton("+");
		b8_2.setBounds(662, 329, 39, 23);
		f.getContentPane().add(b8_2);
		
		JButton b7 = new JButton("");
		b7.setBounds(403, 204, 121, 116);
		f.getContentPane().add(b7);
		
		JButton b7_1 = new JButton("-");
		b7_1.setBounds(403, 329, 39, 23);
		f.getContentPane().add(b7_1);
		
		JButton b7_2 = new JButton("+");
		b7_2.setBounds(485, 329, 39, 23);
		f.getContentPane().add(b7_2);
		
		JButton b6 = new JButton("");
		b6.setBounds(223, 204, 121, 116);
		f.getContentPane().add(b6);
		
		JButton b6_1 = new JButton("-");
		b6_1.setBounds(223, 329, 39, 23);
		f.getContentPane().add(b6_1);
		
		JButton b6_2 = new JButton("+");
		b6_2.setBounds(305, 329, 39, 23);
		f.getContentPane().add(b6_2);
		
		JButton b5 = new JButton("");
		b5.setBounds(40, 204, 121, 116);
		f.getContentPane().add(b5);
		
		JButton b5_1 = new JButton("-");
		b5_1.setBounds(40, 329, 39, 23);
		f.getContentPane().add(b5_1);
		
		JButton b5_2 = new JButton("+");
		b5_2.setBounds(122, 329, 39, 23);
		f.getContentPane().add(b5_2);
		
		
		
		
		f.setVisible(true);
		
		// test KimHwiDong
		
		// 2022.10.31 AM 12:14 연습용 수정
		
		// 2022.10.31 AM 12:25 연습용 수정_최종
		
	}
}

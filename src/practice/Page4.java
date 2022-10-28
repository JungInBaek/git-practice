package practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Page4 {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		JFrame f = new JFrame("�뒪�꺆愿�由�");
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("�븘�씠�뵒");
		l1.setBounds(110, 40, 79, 23);
		f.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("鍮꾨�踰덊샇");
		l2.setBounds(110, 73, 79, 23);
		f.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("�쟾�솕踰덊샇");
		l3.setBounds(110, 106, 79, 23);
		f.getContentPane().add(l3);
		
		JLabel l4 = new JLabel("�씠由�");
		l4.setBounds(110, 139, 79, 23);
		f.getContentPane().add(l4);
		
		JLabel l5 = new JLabel("吏곸썝�뿬遺�");
		l5.setBounds(110, 172, 79, 23);
		f.getContentPane().add(l5);
		
		t1 = new JTextField();
		t1.setBackground(new Color(255, 255, 255));
		t1.setText("id諛쏆븘�샂");
		t1.setEditable(false);
		t1.setBounds(229, 42, 168, 21);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBackground(new Color(255, 255, 255));
		t2.setText("pw諛쏆븘�샂");
		t2.setColumns(10);
		t2.setEditable(false);
		t2.setBounds(229, 75, 168, 21);
		f.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setBackground(new Color(255, 255, 255));
		t3.setEditable(false);
		t3.setText("tel諛쏆븘�샂");
		t3.setColumns(10);
		t3.setBounds(229, 108, 168, 21);
		f.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setBackground(new Color(255, 255, 255));
		t4.setText("name諛쏆븘�샂");
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(229, 141, 168, 21);
		f.getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setBackground(new Color(255, 255, 255));
		t5.setText("rol諛쏆븘�샂");
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(229, 174, 168, 21);
		f.getContentPane().add(t5);
		
		JLabel lblNewLabel = new JLabel("Multi Cafe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 215, 361, 214);
		f.getContentPane().add(lblNewLabel);
		//s
		f.setVisible(true);
		
	}
}

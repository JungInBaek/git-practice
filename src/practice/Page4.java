package practice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import dao.MemberDAO;
import vo.MemberVO;

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
		JFrame f = new JFrame("스탭관리");
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);

		JLabel l1 = new JLabel("ID");
		l1.setBounds(110, 40, 79, 23);
		f.getContentPane().add(l1);

		JLabel l2 = new JLabel("PW");
		l2.setBounds(110, 73, 79, 23);
		f.getContentPane().add(l2);

		JLabel l3 = new JLabel("NAME");
		l3.setBounds(110, 106, 79, 23);
		f.getContentPane().add(l3);

		JLabel l4 = new JLabel("TEL");
		l4.setBounds(110, 139, 79, 23);
		f.getContentPane().add(l4);

		JLabel l5 = new JLabel("ROL");
		l5.setBounds(110, 172, 79, 23);
		f.getContentPane().add(l5);

		t1 = new JTextField();
		t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				t1.setText("");
			}
		});
		t1.setText("ID를 입력해주세요.");
		t1.setColumns(10);
		t1.setBackground(Color.WHITE);
		t1.setBounds(201, 40, 168, 21);
		f.getContentPane().add(t1);

		t2 = new JPasswordField("1234");
		((JPasswordField) t2).setEchoChar('*');
		t2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				t2.setText("");
			}
		});
		t2.setBounds(201, 74, 168, 21);
		f.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setBackground(new Color(255, 255, 255));
		t3.setEditable(false);
		t3.setText("name값받아올거임");
		t3.setColumns(10);
		t3.setBounds(201, 107, 168, 21);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setBackground(new Color(255, 255, 255));
		t4.setText("tel값받아올거임");
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(201, 140, 168, 21);
		f.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setBackground(new Color(255, 255, 255));
		t5.setText("rol값받아올거임");
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(201, 173, 168, 21);
		f.getContentPane().add(t5);

		JLabel lblNewLabel = new JLabel("Multi Cafe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(74, 215, 361, 214);
		f.getContentPane().add(lblNewLabel);

		JButton b1 = new JButton("조회");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				String id = t1.getText();
//				String pw = t2.getText();
//				MemberVO vo = new MemberVO();
//				MemberDAO dao = new MemberDAO();
//				dao.getMemberByIdPw(vo);
//				vo.setId(id);
//				vo.setPw(pw);
//
//				String name = vo.getName();
//				String tel = vo.getTel();
//				t3.setText(name);
//				t4.setText(tel);

			}
		});
		b1.setBackground(new Color(255, 255, 255));
		b1.setBounds(375, 40, 79, 56);
		f.getContentPane().add(b1);
		f.setVisible(true);

	}

}

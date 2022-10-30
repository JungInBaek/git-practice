package practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

import dao.MemberDAO;
import vo.MemberVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Page4 {
	protected static final MemberVO MemberVO = null;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	private JTextField t1;
	private JPasswordField t2;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		JFrame f = new JFrame("스탭관리");
		f.setSize(500, 300);
		f.getContentPane().setLayout(null);

		JLabel l1 = new JLabel("아이디");
		l1.setBounds(75, 40, 79, 23);
		f.getContentPane().add(l1);

		JLabel l2 = new JLabel("비밀번호");
		l2.setBounds(75, 73, 79, 23);
		f.getContentPane().add(l2);

		JLabel l3 = new JLabel("이름");
		l3.setBounds(75, 106, 79, 23);
		f.getContentPane().add(l3);

		JLabel l4 = new JLabel("전화번호");
		l4.setBounds(75, 139, 79, 23);
		f.getContentPane().add(l4);

		JLabel l5 = new JLabel("직원여부");
		l5.setBounds(75, 172, 79, 23);
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
		t1.setBounds(162, 40, 207, 21);
		f.getContentPane().add(t1);

		t2 = new JPasswordField("00000000");
		t2.setEchoChar('*');
		t2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				t2.setText("");
			}
		});
		t2.setBounds(162, 74, 207, 21);
		f.getContentPane().add(t2);
		f.setVisible(true);

		t3 = new JTextField();
		t3.setBackground(new Color(255, 255, 255));
		t3.setEditable(false);
		t3.setText("아이디와 비밀번호를 입력하세요.");
		t3.setColumns(10);
		t3.setBounds(162, 107, 207, 21);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setBackground(new Color(255, 255, 255));
		t4.setText("아이디와 비밀번호를 입력하세요.");
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(162, 140, 207, 21);
		f.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setBackground(new Color(255, 255, 255));
		t5.setText("아이디와 비밀번호를 입력하세요.");
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(162, 173, 207, 21);
		f.getContentPane().add(t5);

		JButton b1 = new JButton("조회");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String id = t1.getText();
					String pw = t2.getText();
					MemberVO vo = new MemberVO();
					MemberDAO dao = new MemberDAO();

					vo.setId(id);
					vo.setPw(pw);
					MemberVO member = dao.getMemberByIdPw(vo); // 저장용도
					t1.setText(member.getId());
					t2.setText(member.getPw());
					t3.setText(member.getName());
					t4.setText(member.getTel());
					t5.setText(member.getRole().name());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(f, "아이디와 비밀번호가 일치하지 않습니다.", "로그인오류", 0);
				}

			}
		});
		b1.setBackground(new Color(255, 255, 255));
		b1.setBounds(375, 40, 79, 56);
		f.getContentPane().add(b1);

	}
}

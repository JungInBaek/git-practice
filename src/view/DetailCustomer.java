package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import dao.DetailDAO;
import vo.DetailVO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class DetailCustomer { // 고객 상세정보
	private static JTextField t1;

	public void open() {

		JFrame f = new JFrame();
		f.setSize(300, 300);
		f.setTitle("고객 특이사항");
		f.getContentPane().setLayout(null);

		JTextArea t2 = new JTextArea();
		t2.setBounds(12, 95, 260, 125);
		f.getContentPane().add(t2);

		JButton b1 = new JButton("검색");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				DetailDAO dao = new DetailDAO();
				DetailVO bag = new DetailVO();
				bag.setId(id);
				DetailVO result = dao.one(bag);

				t2.setText(result.getMemo());
			}
		});
		b1.setBounds(140, 30, 64, 23);
		f.getContentPane().add(b1);

		JLabel lblNewLabel = new JLabel("고객 아이디");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 97, 23);
		f.getContentPane().add(lblNewLabel);

		t1 = new JTextField();
		t1.setBounds(12, 31, 116, 21);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("특이사항");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 62, 97, 23);
		f.getContentPane().add(lblNewLabel_1);

		JButton b1_1 = new JButton("저장");
		b1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String memo = t2.getText();
				DetailDAO a = new DetailDAO();
				DetailVO bag = new DetailVO();
				bag.setMemo(memo);
				bag.setId(id);
				a.insert(bag);
				t2.setText(" ");
			}
		});
		b1_1.setBounds(208, 30, 64, 23);
		f.getContentPane().add(b1_1);
		f.setVisible(true);
	}
}

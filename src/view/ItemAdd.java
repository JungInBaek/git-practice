package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ItemDAO;
import vo.ItemVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemAdd {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JTextField t5;

	public void open() {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);

		t1 = new JTextField();
		t1.setBounds(172, 108, 259, 30);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(172, 155, 259, 30);
		f.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(172, 202, 259, 30);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(172, 249, 259, 30);
		f.getContentPane().add(t4);

		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(172, 293, 259, 30);
		f.getContentPane().add(t5);

		JLabel lblNewLabel_5 = new JLabel("상품추가");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(135, 24, 201, 45);
		f.getContentPane().add(lblNewLabel_5);

		JButton btnNewButton = new JButton("추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String code = t1.getText();
					String price1 = t2.getText();
					int price = Integer.parseInt(price1);
					String name = t3.getText();
					String quantity1 = t4.getText();
					int quantity = Integer.parseInt(quantity1);
					String etc = t5.getText();

					ItemDAO dao = new ItemDAO();
					ItemVO vo = new ItemVO();

					vo.setCode(code);
					vo.setPrice(price);
					vo.setName(name);
					vo.setQuantity(quantity);
					vo.setEtc(etc);
					dao.itemAdd(vo);

					if (price < 0 || quantity < 0) {
						JOptionPane.showMessageDialog(null, "음수는 입력할 수 없습니다.");
					} else if (code.isEmpty() || name.isEmpty()) {
						JOptionPane.showMessageDialog(null, "* 표시된 필수란에 기입해주세요.");
					} else {
						JOptionPane.showMessageDialog(null, "추가되었습니다.");
					}
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "* 표시된 필수란에 기입해주세요.");
				}

			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton.setBounds(111, 366, 97, 59);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton_1.setBounds(253, 366, 97, 59);
		f.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("*상품코드");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel.setBounds(25, 101, 135, 44);
		f.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("*가격");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_1.setBounds(25, 148, 135, 44);
		f.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("*상품명");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_2.setBounds(25, 195, 135, 44);
		f.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("*수량");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_3.setBounds(25, 242, 135, 44);
		f.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("비고");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_4.setBounds(25, 286, 135, 44);
		f.getContentPane().add(lblNewLabel_4);

		f.setVisible(true);

	}
}

package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ItemDAO;
import vo.ItemVO;

public class ItemDelete {
	private static JTextField t1;

	public void open(JTable table) {
		JFrame f = new JFrame();
		f.setSize(500, 300);
		f.getContentPane().setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("상품삭제");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(135, 24, 201, 45);
		f.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel = new JLabel("*상품코드");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel.setBounds(33, 101, 127, 44);
		f.getContentPane().add(lblNewLabel);

		t1 = new JTextField();
		t1.setBounds(172, 108, 259, 30);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JButton btnNewButton = new JButton("삭제");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = t1.getText();

				ItemDAO dao = new ItemDAO();
				ItemVO vo = new ItemVO();
				vo.setCode(code);
				ItemVO item = dao.getItemByCode(vo);
				dao.itemDelete(vo);

				if (code.isEmpty()) {
					JOptionPane.showMessageDialog(null, "상품코드를 입력하세요");
				} else if (code.contains(" ")) {
					JOptionPane.showMessageDialog(null, "공백을 입력할 수 없습니다.");
				} else if (code.equals(item.getCode()) == false) {
					JOptionPane.showMessageDialog(null, "입력하신 상품코드가 존재하지 않습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
					
					String[] header = { "CODE", "PRICE", "NAME", "QUANTITY", "ETC" };
					ArrayList<ItemVO> list = dao.list();
					Object[][] all = new Object[list.size()][5];
					for (int i = 0; i < all.length; i++) {
						ItemVO bag = list.get(i);
						all[i][0] = bag.getCode();
						all[i][1] = bag.getPrice();
						all[i][2] = bag.getName();
						all[i][3] = bag.getQuantity();
						all[i][4] = bag.getEtc();
						DefaultTableModel model = new DefaultTableModel(all, header);
						table.setModel(model);
					}
					f.dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton.setBounds(111, 176, 97, 59);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton_1.setBounds(253, 176, 97, 59);
		f.getContentPane().add(btnNewButton_1);

		f.setVisible(true);

	}

}

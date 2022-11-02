package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ItemDAO;
import vo.ItemVO;
import vo.MemberVO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ItemManageView {
	JTable table;
	JPanel panel = new JPanel();
	ArrayList<ItemVO> list = new ArrayList<>();
	
	public void open() {
		JFrame f = new JFrame();
		f.setSize(800, 800);
		f.getContentPane().setLayout(null);

		// 상품리스트
		panel.setBounds(95, 358, 600, 300);
		f.getContentPane().add(panel);

		String[] header = { "CODE", "PRICE", "NAME", "QUANTITY", "ETC" };

		ItemDAO dao = new ItemDAO();
		list = dao.list();

		Object[][] all = new Object[list.size()][5];
		
		table = new JTable(all, header);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 290));
		
		for (int i = 0; i < all.length; i++) {
			ItemVO bag = list.get(i);
			all[i][0] = bag.getCode();
			all[i][1] = bag.getPrice();
			all[i][2] = bag.getName();
			all[i][3] = bag.getQuantity();
			all[i][4] = bag.getEtc();
		}
		
		panel.add(scrollPane);


		JLabel lblNewLabel = new JLabel("상품관리");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(217, 64, 350, 86);
		f.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("상품추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemAdd page = new ItemAdd();
				page.open();

			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(129, 201, 129, 71);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("상품조회");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = dao.list();
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
			}
		});
		btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(265, 292, 246, 61);
		f.getContentPane().add(btnNewButton_1_1);

		/*
		 * JButton btnNewButton_3 = new JButton("상품조회");
		 * btnNewButton_3.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { ItemDAO dao = new ItemDAO();
		 * 
		 * ArrayList<ItemVO> list = dao.list();
		 * 
		 * String[] header = { "CODE", "PRICE", "NAME", "QUANTITY", "ETC" };
		 * 
		 * Object[][] all = new Object[list.size()][5]; // 행, 열의 개수 for (int i = 0; i <
		 * all.length; i++) { ItemVO bag = list.get(i); all[i][0] = bag.getCode();
		 * all[i][1] = bag.getPrice(); all[i][2] = bag.getName(); all[i][3] =
		 * bag.getQuantity(); all[i][4] = bag.getEtc(); }
		 * 
		 * table = new JTable(all, header); JScrollPane scrollPane = new
		 * JScrollPane(table);
		 * 
		 * for (int i = 0; i < all.length; i++) { for (int j = 0; j < all[i].length;
		 * j++) { System.out.print(all[i][j] + " "); } System.out.println(); } } });
		 * 
		 * btnNewButton_3.setFont(new Font("굴림", Font.BOLD, 20));
		 * btnNewButton_3.setBounds(182, 310, 427, 71);
		 * f.getContentPane().add(btnNewButton_3);
		 * 
		 */
		JButton btnNewButton_1 = new JButton("상품삭제");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemDelete page = new ItemDelete();
				page.open();
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1.setBounds(325, 201, 129, 71);
		f.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("상품수정");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("수정할 상품코드를 입력하세요");

				if (code == null) {
					JOptionPane.showMessageDialog(f, "취소했습니다");
				} else {
					ItemDAO dao = new ItemDAO();
					ItemVO vo = new ItemVO();
					vo.setCode(code);

					ItemVO item = dao.getItemByCode(vo);

					if (item.getCode() == null) {
						JOptionPane.showMessageDialog(null, "입력하신 상품코드가 존재하지 않습니다.");
					} else if (code.equals(item.getCode())) {
						ItemUpdate page = new ItemUpdate();
						page.open(item);
					}
				}

			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_2.setBounds(522, 201, 129, 71);
		f.getContentPane().add(btnNewButton_2);
		

		f.setVisible(true);

	}
}

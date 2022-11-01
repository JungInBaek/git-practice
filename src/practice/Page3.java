package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ItemDAO;
import vo.ItemVO;

public class Page3 {
	ItemDAO dao = new ItemDAO();
	ArrayList<ItemVO> list = new ArrayList<>();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JTable table;
	int i = 0;
	int count = 0;

	public void open() {
		list = dao.list();
		JFrame f = new JFrame();
		f.setTitle("상품판매");
		f.setSize(745, 800);
		f.getContentPane().add(panel1, BorderLayout.NORTH);
		panel1.setPreferredSize(new Dimension(700, 500));
		f.getContentPane().add(panel2, BorderLayout.CENTER);
		f.getContentPane().add(panel3, BorderLayout.SOUTH);

		// table 항목명
		String[] header = { "코드명", "가격", "이름" };

		Object[][] all = new Object[list.size()][3]; // 행, 열의 개수

		table = new JTable(all, header); // 내용, 항목명
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 150));
		panel2.add(scrollPane);

		Font font = new Font("굴림", Font.BOLD, 30);
		JLabel lbl = new JLabel("주문 합계");
		JTextField tf = new JTextField(10);
		lbl.setFont(font);
		tf.setFont(font);
		tf.setBackground(Color.black);
		tf.setForeground(Color.white);
		tf.setHorizontalAlignment(JTextField.CENTER);
		panel3.add(lbl);
		panel3.add(tf);

		for (i = 0; i < all.length; i++) {
			JButton btn = new JButton(list.get(i).getName());
			btn.putClientProperty("id", i);
			btn.setPreferredSize(new Dimension(150, 80));
			// btn 이벤트
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int id = (Integer) btn.getClientProperty("id");
					System.out.println(id);
					all[id][0] = list.get(id).getCode();
					all[id][1] = list.get(id).getPrice();
					all[id][2] = list.get(id).getName();
					count += (Integer) all[id][1];
					tf.setText(count + "");
					DefaultTableModel model = new DefaultTableModel(all, header);
					table.setModel(model);
				}
			}); // event end
			panel1.add(btn);
		} // for end

		f.setVisible(true);
	}
}

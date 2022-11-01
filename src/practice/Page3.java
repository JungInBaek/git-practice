package practice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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

	public void open() {
		list = dao.list();
		JFrame f = new JFrame();
		f.setTitle("상품판매");
		f.setSize(745, 900);
//		f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		f.getContentPane().add(panel1, BorderLayout.NORTH);
		panel1.setPreferredSize(new Dimension(700, 300));
		f.getContentPane().add(panel2, BorderLayout.CENTER);
		f.getContentPane().add(panel3, BorderLayout.SOUTH);
//		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// table 항목명
		String[] header = { "코드명", "가격", "이름"};

		Object[][] all = new Object[list.size()][3]; // 행, 열의 개수
//		for (int i = 0; i < list.size(); i++) {
//			ItemVO bag = list.get(i); // 가방을 1개 꺼내세요.
//			all[i][0] = bag.getCode();
//			all[i][1] = bag.getPrice();
//			all[i][2] = bag.getName();
//		}

		table = new JTable(all, header); // 내용, 항목명
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 200));
		panel2.add(scrollPane);

		ArrayList<String> names = new ArrayList<>();
		
		for (i = 0; i < all.length; i++) {
			JButton btn = new JButton(list.get(i).getName());
			btn.setPreferredSize(new Dimension(150, 130));
			names.add(list.get(i).getName());
			// btn 이벤트
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int index = names.indexOf(e.getActionCommand());
					all[index][0] = list.get(index).getCode();
					all[index][1] = list.get(index).getPrice();
					all[index][2] = list.get(index).getName();
					System.out.println(all[index][0]);
//						if (list.get(j).getName().equals("아메리카노")) {
//							all[j][0] = list.get(j).getCode();
//							System.out.println(list.get(j).getCode());
//							break;
//						} else {
//							JOptionPane.showMessageDialog(table, "값이 없습니다.");
//						}
					
					
				}
			});
			panel1.add(btn);
		} //for end

		f.setVisible(true);

		// test KimHwiDong

		// 2022.10.31 AM 12:14 연습용 수정

		// 2022.10.31 AM 12:25 연습용 수정_최종

	}
}

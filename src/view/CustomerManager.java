package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.MemberDAO;
import vo.MemberVO;

public class CustomerManager {
	private static JTable table;

	public void open() {
		JFrame f = new JFrame();
		f.setSize(528, 693);
		MemberDAO dao = new MemberDAO();
		String header[] = { "아이디", "패스워드", "이름", "전화번호" };
		ArrayList<MemberVO> list = dao.list();
		String[][] all = new String[list.size()][4];
		for (int i = 0; i < all.length; i++) {
			all[i][0] = list.get(i).getId();
			all[i][1] = list.get(i).getPw();
			all[i][2] = list.get(i).getName();
			all[i][3] = list.get(i).getTel();
			JPanel panel = new JPanel();
			f.getContentPane().add(panel, BorderLayout.CENTER);

			table = new JTable(all, header);

			JScrollPane scrollPane = new JScrollPane(table);
			panel.add(scrollPane);

			f.setVisible(true);
		}
	}
}

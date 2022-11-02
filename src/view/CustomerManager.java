package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import dao.MemberDAO;
import vo.MemberVO;

public class CustomerManager {
	private static JTable table;

	public static void main(String[] args) {

		{
			JFrame f = new JFrame();
			f.setSize(528, 850);
			MemberDAO dao = new MemberDAO();
			String header[] = { "아이디", "패스워드", "이름", "전화번호", };
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

				JLabel n1 = new JLabel();
				n1.setIcon(new ImageIcon("img/coffee.jpg"));
				panel.add(n1);

				
				f.setVisible(true);
			}
		}

	}
}

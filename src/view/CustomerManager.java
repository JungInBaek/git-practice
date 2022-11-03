package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import dao.MemberDAO;
import vo.MemberVO;

public class CustomerManager {
	private static JTable table;

	public void open() {

		{
			JFrame f = new JFrame();
			f.setTitle("고객정보");
			f.setSize(528, 750);
			MemberDAO dao = new MemberDAO();
			String header[] = { "아이디", "패스워드", "이름", "전화번호", };
			ArrayList<MemberVO> list = dao.list();
			String[][] all = new String[list.size()][4];
			for (int i = 0; i < all.length; i++) {
				for (int j = 0; j < 4; j++) {
					all[i][0] = list.get(i).getId();
					all[i][1] = list.get(i).getPw();
					all[i][2] = list.get(i).getName();
					all[i][3] = list.get(i).getTel();
				}
			}
			JPanel panel = new JPanel();
			f.getContentPane().add(panel, BorderLayout.CENTER);

			table = new JTable(all, header);

			JScrollPane scrollPane = new JScrollPane(table);
			panel.add(scrollPane);

			JLabel n1 = new JLabel();
			n1.setIcon(new ImageIcon("img/coffee.jpg"));
			panel.add(n1);
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowNo = table.getSelectedRow();
					int colNo = table.getSelectedColumn();
					Object value = (Object) table.getModel().getValueAt(rowNo, colNo);
					Object id = table.getModel().getValueAt(rowNo, 0);
					Object pw = table.getModel().getValueAt(rowNo, 1);
					Object name = table.getModel().getValueAt(rowNo, 2);
					Object tel = table.getModel().getValueAt(rowNo, 3);
					JOptionPane.showMessageDialog(table, id+" "+ pw +" "+ name+" "+tel);
					
				}
			});
			JLabel l2 = new JLabel("고객정보");
			l2.setFont(new Font("굴림", Font.BOLD, 20));
			l2.setHorizontalAlignment(SwingConstants.CENTER);
			f.getContentPane().add(l2, BorderLayout.NORTH);
			
			JButton b = new JButton("상세검색");
			b.setHorizontalAlignment(SwingConstants.CENTER);
			f.getContentPane().add(b, BorderLayout.SOUTH);
			
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DetailCustomer a = new DetailCustomer();
					a.open();
				}
			});
			f.setVisible(true);
		}
	}

}

package practice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import dao.ItemDAO;
import vo.ItemVO;

public class Page3 {
//	public void open() {
	static ItemDAO dao = new ItemDAO();
	static ArrayList<ItemVO> list = new ArrayList<>();
	static int i = 0;
	
	public static void main(String[] args) {
		list = dao.list();
		JFrame f = new JFrame();
		f.setTitle("상품판매");
		f.setSize(745, 612);
		f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		
		
		
		for (i = 0; i < list.size(); i++) {
			JButton btn = new JButton(list.get(i).getName());
			btn.setPreferredSize(new Dimension(150, 130));
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
//					t1.setText( list.get(i).getName() );
				}
			});
			
			f.getContentPane().add(btn);
		}
		
		
		
		
		f.setVisible(true);
		
		// test KimHwiDong
		
		// 2022.10.31 AM 12:14 연습용 수정
		
		// 2022.10.31 AM 12:25 연습용 수정_최종
		
	}
}




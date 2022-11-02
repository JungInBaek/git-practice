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

public class ItemUpdate {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JTextField t5;
	
	public void open(ItemVO item, JTable table){
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*상품코드");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel.setBounds(25, 101, 135, 44);
		f.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(172, 108, 259, 30);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		t1.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("*가격");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_1.setBounds(25, 148, 135, 44);
		f.getContentPane().add(lblNewLabel_1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(172, 155, 259, 30);
		f.getContentPane().add(t2);
		
		JLabel lblNewLabel_2 = new JLabel("*상품명");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_2.setBounds(25, 195, 135, 44);
		f.getContentPane().add(lblNewLabel_2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(172, 202, 259, 30);
		f.getContentPane().add(t3);
		
		JLabel lblNewLabel_3 = new JLabel("*수량");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_3.setBounds(25, 242, 135, 44);
		f.getContentPane().add(lblNewLabel_3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(172, 249, 259, 30);
		f.getContentPane().add(t4);
		
		JLabel lblNewLabel_4 = new JLabel("비고");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_4.setBounds(25, 286, 135, 44);
		f.getContentPane().add(lblNewLabel_4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(172, 293, 259, 30);
		f.getContentPane().add(t5);
		
		JLabel lblNewLabel_5 = new JLabel("상품수정");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(135, 24, 201, 45);
		f.getContentPane().add(lblNewLabel_5);
		
		
		t1.setText(item.getCode());
		t2.setText(item.getPrice() + "");
		t3.setText(item.getName());
		t4.setText(item.getQuantity() + "");
		t5.setText(item.getEtc()); 
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = t1.getText();
				String price1 = t2.getText();
				int price = Integer.parseInt(price1);
				String name = t3.getText();
				String quantity1 = t4.getText();
				int quantity = Integer.parseInt(quantity1);
				String etc = t5.getText();
				
				ItemDAO dao = new ItemDAO();
				ItemVO vo = new ItemVO();
				
				if (price1.isEmpty() || name.isEmpty() || quantity1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "* 표시된 필수란에 기입해주세요.");
				}else {
					vo.setCode(code);
					vo.setPrice(price);
					vo.setName(name);
					vo.setQuantity(quantity);
					vo.setEtc(etc);
					dao.itemUpdate(vo);
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
					
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
		
		
		f.setVisible(true);

	}


}

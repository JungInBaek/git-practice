package practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

public class Page2 {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	public void open() {
		
	
		JFrame f = new JFrame();
		f.setTitle("고객 관리");
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("고객 관리");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(97, 0, 278, 42);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 41, 99, 35);
		f.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.BOLD, 10));
		textField.setBounds(107, 48, 309, 21);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 182, 460, 218);
		f.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_1 = new JLabel("가입일자");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 86, 99, 35);
		f.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("포인트");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(12, 131, 99, 35);
		f.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("굴림", Font.BOLD, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(107, 93, 309, 21);
		f.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("굴림", Font.BOLD, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(107, 138, 309, 21);
		f.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("전체");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setBounds(14, 410, 97, 41);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("변경");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1.setBounds(133, 410, 97, 41);
		f.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("삭제");
		btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(253, 410, 97, 41);
		f.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("추가");
		btnNewButton_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(375, 410, 97, 41);
		f.getContentPane().add(btnNewButton_1_1_1);
		f.setVisible(true);
	}
	
}

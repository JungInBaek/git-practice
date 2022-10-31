package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vo.ItemVO;

public class ItemDAO {
	
	private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbId = "cafe";
	private String dbPw = "1234";

	public ArrayList<ItemVO> list() {
		ArrayList<ItemVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw); 

			String sql = "select * from item";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				String code = rs.getString("code");
				String price1 = rs.getString("price"); 
				int price = Integer.parseInt(price1);
				String name = rs.getString("name"); 
				String quantity1 = rs.getString("quantity"); 
				int quantity = Integer.parseInt(quantity1);

				ItemVO bag = new ItemVO(); 
				bag.setCode(code);
				bag.setPrice(price);
				bag.setName(name);
				bag.setQuantity(quantity);

				list.add(bag);
			}
			ps.close();
			con.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

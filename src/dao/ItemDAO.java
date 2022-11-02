package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

			String sql = "select * from item ORDER BY code";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String code = rs.getString("code");
				String price1 = rs.getString("price");
				int price = Integer.parseInt(price1);
				String name = rs.getString("name");
				String quantity1 = rs.getString("quantity");
				int quantity = Integer.parseInt(quantity1);
				String etc = rs.getString("etc");

				ItemVO bag = new ItemVO();
				bag.setCode(code);
				bag.setPrice(price);
				bag.setName(name);
				bag.setQuantity(quantity);
				bag.setEtc(etc);

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

	// 상품관리-추가
	public void itemAdd(ItemVO vo) {

		String sql = "INSERT INTO Item VALUES (?, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getQuantity());
			pstmt.setString(5, vo.getEtc());

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 상품관리-삭제
	public void itemDelete(ItemVO vo) {

		String sql = "delete from Item where code = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 상품관리-수정
	public void itemUpdate(ItemVO vo) {

		String sql = "update Item set price = ?, name = ?, quantity = ?, etc = ? where code = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getQuantity());
			pstmt.setString(4, vo.getEtc());
			pstmt.setString(5, vo.getCode());

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 상품코드로 조회
	public ItemVO getItemByCode(ItemVO vo) {
		String sql = "select code, price, name, quantity, etc from Item where code = ? ";
		ItemVO item = new ItemVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());

			pstmt.executeQuery();

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				item.setCode(rs.getString("code"));
				item.setPrice(rs.getInt("price"));
				item.setName(rs.getString("name"));
				item.setQuantity(rs.getInt("quantity"));
				item.setEtc(rs.getString("etc"));
			}

			pstmt.close();
			conn.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return item;
	}


}

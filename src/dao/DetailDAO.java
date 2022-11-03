package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.DetailVO;

public class DetailDAO {

	public void insert(DetailVO bag) { //고객정보 DAO
		try {
			// 드라이버 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "cafe";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			// DB 연결 성공

			String sql = "insert into DETAILCUSTOMER values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// sql문 객체 생성 성공

			ps.setString(1, bag.getId());
			ps.setString(2, bag.getMemo());
			ps.executeUpdate(); // sql문 전송
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public DetailVO one(DetailVO bag2) {

		DetailVO bag = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "cafe";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "select * from DETAILCUSTOMER where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag2.getId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("검색결과가 있음.");
				String id2 = rs.getString(1);
				String memo = rs.getString(2);
				System.out.println("검색한 결과>>" + id2 + memo);
				bag = new DetailVO();
				bag.setMemo(memo);
			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constant.Role;
import vo.MemberVO;

public class MemberDAO {

	private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbId = "cafe";
	private String dbPw = "1234";

	// member 추가
	public void add(MemberVO vo) {
		String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getRole().toString());

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// id로 id만 조회
	public MemberVO getIdById(String id) {
		String sql = "SELECT id FROM member WHERE id = ?";

		MemberVO member = new MemberVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString("id"));
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	// id, pw로 member 조회
	public MemberVO getMemberByIdPw(MemberVO vo) {
		String sql = "SELECT * FROM member WHERE id = ? and pw = ?";

		MemberVO member = new MemberVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setTel(rs.getString("tel"));
				if (rs.getString("rol").equals(Role.STAFF.name())) {
					member.setRole(Role.STAFF);
				} else {
					member.setRole(Role.CLIENT);
				}
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public void revise(String ID, String PW, String NAME, String TEL) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);

			String sql = "UPDATE member SET PW = ?, NAME = ?, TEL = ? WHERE ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, PW);
			ps.setString(2, NAME);
			ps.setString(3, TEL);
			ps.setString(4, ID);

			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//

	// 고객정보 전체출력
	public ArrayList<MemberVO> list() {
		String sql = "select * from MEMBER";
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id2 = rs.getString(1); // 컬럼의 순서 1번 id값 추출
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);

				MemberVO member = null;
				member = new MemberVO();
				member.setId(id2);
				member.setPw(pw);
				member.setName(name);
				member.setTel(tel);
				if (rs.getString("rol").equals(Role.STAFF.name())) {
					member.setRole(Role.STAFF);
				} else {
					member.setRole(Role.CLIENT);
				}

				list.add(member);

			}
			pstmt.close();
			conn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

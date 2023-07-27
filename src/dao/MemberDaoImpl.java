package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBclose;
import db.DBconnection;
import dto.MemberDto;

public class MemberDaoImpl implements MemberDao {
	
	@Override
	public boolean getId(String id) {
		String sql = " SELECT ID " + " FROM ORDER_MEMBER1 " + " WHERE ID = ? ";

		Connection conn = null; // DB Connection
		PreparedStatement psmt = null; // SQL
		ResultSet rs = null; // result

		boolean findid = false;

		System.out.println("sql:" + sql);

		try {
			conn = DBconnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				findid = true; // 데이터가 있을 때
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBclose.close(psmt, conn, rs);
		}

		return findid;
	}

	@Override
	public boolean addMember(MemberDto dto) {
		String sql = " INSERT INTO ORDER_MEMBER1(ID, PWD, NAME, EMAIL, AUTH) " + " VALUES(?, ?, ?, ?, 3) ";

		Connection conn = null;
		PreparedStatement psmt = null;

		System.out.println("sql:" + sql);

		int count = 0;

		try {
			conn = DBconnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBclose.close(psmt, conn, null);
		}

		return count > 0 ? true : false;
	}

	@Override
	public MemberDto login(String id, String pwd) {
		String sql = " SELECT ID, NAME, EMAIL, AUTH " + " FROM ORDER_MEMBER1 " + " WHERE ID=? AND PWD=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		MemberDto mem = null;

		try {
			conn = DBconnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pwd.trim());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String _id = rs.getString(1); // id
				String _name = rs.getString(2); // name
				String _email = rs.getString(3);// email
				int auth = rs.getInt(4); // auth

				mem = new MemberDto(_id, null, _name, _email, auth);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBclose.close(psmt, conn, rs);
		}
		return mem;
	}

}

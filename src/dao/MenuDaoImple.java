package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBclose;
import db.DBconnection;
import dto.MenuDto;

public class MenuDaoImple  implements MenuDao {
	
	public List<MenuDto> getMenuList(){
		List<MenuDto> list = new ArrayList<MenuDto>();
		
		String sql = "SELECT SEQ, MENU, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE"
				+ " FROM MENU_TABLE1";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBconnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MenuDto menuDto = new MenuDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5));
				list.add(menuDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose.close(psmt, conn, rs);
		}	
		
		return list;
	}

	@Override
	public MenuDto getMenuInfo(String menu) {
		String sql = " SELECT SEQ, MENU, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE "
				+ " FROM MENU_TABLE1 "
				+ " WHERE MENU = ?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MenuDto menuDto = null;
		try {
			conn = DBconnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, menu);
			rs = psmt.executeQuery();
			while(rs.next()) {
				menuDto = new MenuDto(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getInt(4),
							rs.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose.close(psmt, conn, rs);
		}	
		
		
		return menuDto;
	}
	

}

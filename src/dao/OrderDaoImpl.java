package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBconnection;
import dto.OrderDto;

public class OrderDaoImpl implements OrderDao {
	
	public boolean order(OrderDto orderDto) {
		String sql = " INSERT INTO ORDER_TABLE1(SEQ, ID, MENU, KIND, ICE_SIZE, "
				+ " COUNT, PRICE, WDATE) " + " VALUES(SEQ_ORDER.NEXTVAL, ?, ?, ?, ?, ?, ? , SYSDATE)";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		try {
			conn = DBconnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, orderDto.getId());
			psmt.setString(2, orderDto.getMenu());
			psmt.setString(3, orderDto.getKind());
			psmt.setString(4, orderDto.getSize());
			psmt.setInt(5, orderDto.getCount());
			psmt.setInt(6, orderDto.getPrice());
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count > 0 ? true : false;
	}



	@Override
	public List<OrderDto> orderedList(String id) {
		List<OrderDto> list = new ArrayList<OrderDto>();
		String sql = "select SEQ, ID, MENU, KIND, ICE_SIZE, " + " COUNT, PRICE, WDATE "
				+ "FROM ORDER_TABLE1" + " WHERE ID = ? ORDER BY WDATE DESC";
		try {
			Connection conn = DBconnection.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				OrderDto orderDto = new OrderDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7),
						rs.getString(8));
				list.add(orderDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}



	@Override
	public int allSum(String id) {
		String sql = "select sum(price) from ORDER_TABLE1 WHERE ID = ?";
		int num = 0;
		try {
			Connection conn = DBconnection.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	

}

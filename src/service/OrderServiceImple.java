package service;

import java.util.List;

import dao.OrderDao;
import dao.OrderDaoImpl;
import dto.OrderDto;

public class OrderServiceImple implements OrderService {
	
	OrderDao orderdao = new OrderDaoImpl();
	
	@Override
	public boolean order(OrderDto orderDto) {
		return orderdao.order(orderDto);
	}


	@Override
	public List<OrderDto> orderedList(String id) {
		return orderdao.orderedList(id);
	}


	@Override
	public int allSum(String id) {
		// TODO Auto-generated method stub
		return orderdao.allSum(id);
	}


}

package service;

import java.util.List;

import dto.OrderDto;

public interface OrderService {
	
	public boolean order(OrderDto orderDto);
	
	public List<OrderDto> orderedList(String id);
	public int allSum(String id);

}

package controller;

import java.util.List;

import dto.OrderDto;
import service.OrderService;
import service.OrderServiceImple;
import view.MenuView;
import view.OrderListView;
import view.OrderView;
import view.OrderedListView;

public class OrderController {
	
	OrderService orderService = new OrderServiceImple();
	
	public void getOrderView() {
		new OrderView();
	}
	
	public void getMenuView() {
		new MenuView();
	}
	
	public boolean order(OrderDto orderDto) {
		return orderService.order(orderDto);
	}
	
	public void getOrderListView() {
		new OrderListView();
	}
	
	public List<OrderDto> getOrderedList(String id) {
		return orderService.orderedList(id);
	}
	
	public void getOrderedListView() {
		new OrderedListView();
	}
	
	public int allSum(String id) {
		return orderService.allSum(id);
	}


}

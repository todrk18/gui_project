package singleton;

import java.util.ArrayList;
import java.util.List;

import controller.MemberController;
import controller.MenuController;
import controller.OrderController;
import dto.OrderDto;

public class Singleton {
	
private static Singleton s = null;
	
	public MemberController memCtrl = null;
	public OrderController orderCtrl = null;
	public MenuController menuCtrl = null;

	private String loginID = null;
	
	private OrderDto orderDto = null;
	
	private List<OrderDto> list = null;

	public List<OrderDto> getList() {
		return list;
	}

	public void setList(List<OrderDto> list) {
		this.list = list;
	}

	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	private Singleton() {
		memCtrl = new MemberController();
		orderCtrl = new OrderController();
		menuCtrl = new MenuController();
		list = new ArrayList<OrderDto>();
	
	}
	
	public static Singleton getInstance() {
		if( s == null) {
			s = new Singleton();
		}
		return s;
	}


}

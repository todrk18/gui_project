package controller;

import java.util.List;

import dto.MenuDto;
import service.MenuService;
import service.MenuServiceImpl;

public class MenuController {
	
	MenuService menuServ = new MenuServiceImpl();
	
	public List<MenuDto> getMenuList() {
		return menuServ.getMenuList();
	}
	
	public MenuDto getMenuInfo(String menu) {
		return menuServ.getMenuInfo(menu);
	}


}

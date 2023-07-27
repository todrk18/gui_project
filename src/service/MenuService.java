package service;

import java.util.List;

import dto.MenuDto;

public interface MenuService {
	
	public List<MenuDto> getMenuList();
	
	public MenuDto getMenuInfo(String menu);


}

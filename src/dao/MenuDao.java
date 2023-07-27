package dao;

import java.util.List;

import dto.MenuDto;

public interface MenuDao {
	
	public List<MenuDto> getMenuList();
	
	public MenuDto getMenuInfo(String menu);


}

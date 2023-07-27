package service;

import java.util.List;

import dao.MenuDao;
import dao.MenuDaoImple;
import dto.MenuDto;

public class MenuServiceImpl implements MenuService {
	
	MenuDao menuDao = new MenuDaoImple();
	
	@Override
	public List<MenuDto> getMenuList() {
		return menuDao.getMenuList();
	}

	@Override
	public MenuDto getMenuInfo(String menu) {
		
		return menuDao.getMenuInfo(menu);
	}

}

package main;

import db.DBconnection;
import singleton.Singleton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBconnection.initConnection();
//		
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
//		new OrderView();
//		new MenuView();
//		new OrderListView();
//		new OrderedListView();

	}


	

}

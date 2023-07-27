package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuView extends JFrame {
	
	JLabel menuLabel, sizeLabel, smallLabel, mediumLabel, LargeLabel;
	JLabel[] jMenu, smallPrice, mediumPrice, LargePrice;
	String[] strMenu = { "바닐라 아이스크림", "쵸코 아이스크림", "녹차 아이스크림", 
			"딸기 아이스크림", "망고 아이스크림", "민트쵸코 아이스크림", "치즈 아이스크림", "커피 아이스크림", "아이스크림 케잌",
			"팥빙수" };
	String[] strSmallPrice = { "3000", "3000", "3000", "3000", "3000", "3000", "3000", "3000", "10000", "4000" };

	public MenuView() {
		
		setLayout(null);
		
		menuLabel = new JLabel("가격표");
		menuLabel.setBounds(450, 30, 100, 30);
		// 메뉴
		add(menuLabel);
		
		sizeLabel = new JLabel("사이즈");
	    sizeLabel.setBounds(40, 100, 200, 30);
	    add(sizeLabel);
		jMenu = new JLabel[strMenu.length];
		for (int i = 0; i < jMenu.length; i++) {
			jMenu[i] = new JLabel(strMenu[i]);
			jMenu[i].setBounds(40, 140 + 30 * i, 200, 30);

			add(jMenu[i]);
		}
		
		smallLabel = new JLabel("Small");
		smallLabel.setBounds(240, 100, 200, 30);
	    add(smallLabel);
		smallPrice = new JLabel[strSmallPrice.length];
		for (int i = 0; i < smallPrice.length; i++) {
			smallPrice[i] = new JLabel(strSmallPrice[i]);

			smallPrice[i].setBounds(240, 140 + 30 * i, 200, 30);
			add(smallPrice[i]);
		}
		
		mediumLabel = new JLabel("Medium");
		mediumLabel.setBounds(440, 100, 200, 30);
	    add(mediumLabel);
		mediumPrice = new JLabel[strSmallPrice.length];
		for (int i = 0; i < smallPrice.length; i++) {
			mediumPrice[i] = new JLabel((Integer.parseInt(strSmallPrice[i]) + 1000) + "");

			mediumPrice[i].setBounds(440, 140 + 30 * i, 200, 30);
			add(mediumPrice[i]);
		}

		LargeLabel = new JLabel("Large");
		LargeLabel.setBounds(640, 100, 200, 30);
	    add(LargeLabel);
		LargePrice = new JLabel[strSmallPrice.length];
		for (int i = 0; i < smallPrice.length; i++) {
			LargePrice[i] = new JLabel((Integer.parseInt(strSmallPrice[i]) + 2000) + "");
			LargePrice[i].setBounds(640, 140 + 30 * i, 200, 30);
			add(LargePrice[i]);
		}

		setBounds(100, 100, 800, 700);
		setLocation(1100, 100);
		setVisible(true);
		setLocationRelativeTo(null);    //창을 가운데 위치시킴
		setResizable(false);			// 창 사이즈 고정

	}


}

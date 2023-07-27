package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.OrderDto;
import singleton.Singleton;

public class OrderedListView extends JFrame {
	
	private JTable jtable;
	private JScrollPane jscrPane;
	private JLabel allPriceLabel;

	String columnNames[] = { "�ֹ��� ���̽�ũ��", "��¥", "������", "����", "����"};

	Object rowData[][];
	DefaultTableModel model;
	List<OrderDto> list = null;
	
	public OrderedListView() {
		super("�ֹ��ߴ�����");

		setLayout(null);

		Singleton s = Singleton.getInstance();
		list = s.orderCtrl.getOrderedList(s.getLoginID());
		
//		this.list = list;
		rowData = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			OrderDto orderDto = list.get(i);
			
			rowData[i][0] = orderDto.getMenu();
			rowData[i][1] = orderDto.getWdate();
			rowData[i][2] = orderDto.getSize();
			rowData[i][3] = orderDto.getCount();
			rowData[i][4] = orderDto.getPrice();
		}
	

		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		jtable = new JTable(model);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);

		allPriceLabel = new JLabel("�� ����: " + (s.orderCtrl.allSum(s.getLoginID() + "")));
		allPriceLabel.setBounds(550, 380, 150, 30);
		
		add(allPriceLabel);
		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setLocationRelativeTo(null);    //â�� ��� ��ġ��Ŵ
		setResizable(false);			// â ������ ����

	}


}

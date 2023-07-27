package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.OrderDto;
import singleton.Singleton;

public class OrderListView extends JFrame implements MouseListener {
	
	private JTable jtable;
	private JScrollPane jscrPane;

	private JButton orderBtn, removeBtn, addOrder;

	String columnNames[] = { "ICECREAM", "����", "ũ��", "��", "�Ѿ�" };

	Object rowData[][];
	DefaultTableModel model;
	OrderDto orderDto;
	List<OrderDto> list;

	public OrderListView() {
		super("�ֹ�����");

		setLayout(null);

		Singleton s = Singleton.getInstance();

		list = s.getList();

		rowData = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			OrderDto orderDto = list.get(i);
			System.out.println(orderDto.toString());
			rowData[i][0] = orderDto.getMenu();
			rowData[i][1] = orderDto.getKind();
			rowData[i][2] = orderDto.getSize();
			rowData[i][3] = orderDto.getCount();
			rowData[i][4] = orderDto.getPrice();
		}

		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);

		jtable = new JTable(model);
		
		jtable.addMouseListener(this);
//		jtable.addMouseListener(this);

		// column�� ���� ����
//		jtable.getColumnModel().getColumn(0).setMaxWidth(50); // ��ȣ
//		jtable.getColumnModel().getColumn(1).setMaxWidth(500); // ����
//		jtable.getColumnModel().getColumn(2).setMaxWidth(200); // �ۼ���

		// ���̺��� column�� ���� ����(����, �߰�, ������)
//		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
//		celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // �߰�

		// '��ȣ'�� '�ۼ���'�� �÷��� ���� �߰� ������ �ȴ�
//		jtable.getColumn("��ȣ").setCellRenderer(celAlignCenter);
//		jtable.getColumn("�ۼ���").setCellRenderer(celAlignCenter);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		
		addOrder = new JButton("�߰� �ֹ��ϱ�");
		addOrder.setBounds(440, 370, 150, 30);
		addOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getOrderView();
				dispose(); 
			}
		});
		add(addOrder);
		
		orderBtn = new JButton("�ֹ��ϱ�");
		orderBtn.setBounds(580, 370, 100, 30);
		orderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.size() == 0) {
					JOptionPane.showMessageDialog(null, "�ֹ��� ����� �����ϴ�");
					return;
				}
				for (int i = 0; i < list.size(); i++) {
					s.orderCtrl.order(list.get(i));
				}
				JOptionPane.showMessageDialog(null, "�ֹ��� �Ϸ�Ǿ����ϴ�");

			}
		});

		removeBtn = new JButton("��ٱ��� ��ü ����");
		removeBtn.setBounds(690, 370, 160, 30);
		removeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s.setList(new ArrayList<OrderDto>());
				s.orderCtrl.getOrderView();
				JOptionPane.showMessageDialog(null, "����� ���� �����Ǿ����ϴ�.");
				dispose();

			}
		});
		

		add(orderBtn);
		add(removeBtn);

		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setLocationRelativeTo(null);    //â�� ��� ��ġ��Ŵ
		setResizable(false);			// â ������ ����


	}
	// ������ �޴�Ŭ���� ����
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowNum = jtable.getSelectedRow();	
		Singleton s = Singleton.getInstance();	
		JOptionPane.showMessageDialog(null, "������ �� ����:" + list.get(rowNum).toString());
		int result = JOptionPane.showConfirmDialog(null, "������ �޴��� �����Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.CLOSED_OPTION) {
			
		}else if (result == JOptionPane.YES_OPTION) {
			list.remove(rowNum);
			dispose();
			s.orderCtrl.getOrderListView();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

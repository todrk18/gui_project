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

	String columnNames[] = { "ICECREAM", "종류", "크기", "개", "총액" };

	Object rowData[][];
	DefaultTableModel model;
	OrderDto orderDto;
	List<OrderDto> list;

	public OrderListView() {
		super("주문내역");

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

		// column의 폭을 설정
//		jtable.getColumnModel().getColumn(0).setMaxWidth(50); // 번호
//		jtable.getColumnModel().getColumn(1).setMaxWidth(500); // 제목
//		jtable.getColumnModel().getColumn(2).setMaxWidth(200); // 작성자

		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
//		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
//		celAlignCenter.setHorizontalAlignment(JLabel.CENTER); // 중간

		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
//		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
//		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		
		addOrder = new JButton("추가 주문하기");
		addOrder.setBounds(440, 370, 150, 30);
		addOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getOrderView();
				dispose(); 
			}
		});
		add(addOrder);
		
		orderBtn = new JButton("주문하기");
		orderBtn.setBounds(580, 370, 100, 30);
		orderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.size() == 0) {
					JOptionPane.showMessageDialog(null, "주문할 목록이 없습니다");
					return;
				}
				for (int i = 0; i < list.size(); i++) {
					s.orderCtrl.order(list.get(i));
				}
				JOptionPane.showMessageDialog(null, "주문이 완료되었습니다");

			}
		});

		removeBtn = new JButton("장바구니 전체 삭제");
		removeBtn.setBounds(690, 370, 160, 30);
		removeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s.setList(new ArrayList<OrderDto>());
				s.orderCtrl.getOrderView();
				JOptionPane.showMessageDialog(null, "목록이 전부 삭제되었습니다.");
				dispose();

			}
		});
		

		add(orderBtn);
		add(removeBtn);

		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setLocationRelativeTo(null);    //창을 가운데 위치시킴
		setResizable(false);			// 창 사이즈 고정


	}
	// 삭제할 메뉴클릭시 삭제
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowNum = jtable.getSelectedRow();	
		Singleton s = Singleton.getInstance();	
		JOptionPane.showMessageDialog(null, "선택한 글 정보:" + list.get(rowNum).toString());
		int result = JOptionPane.showConfirmDialog(null, "선택한 메뉴를 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
		
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

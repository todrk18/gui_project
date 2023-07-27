package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dto.MenuDto;
import dto.OrderDto;
import singleton.Singleton;

public class OrderView  extends JFrame {
	
	JLabel sizeLabel, kindLabel, countLabel;
	JButton menuBtn, orderBtn, orderedListMenuBtn, cartBtn;
	Choice menuChoice;

	JPanel sizePanel, kindPanel;

	ButtonGroup sizeGroup, kindGroup;  // ��ư�׷� ���� �ߺ�üũ�ذ�

	JRadioButton smallRButton, mediumRButton, largeRButton, cornRButton, cupRButton, notRButton;


	JTextField countTextField;

	public OrderView() {
		setLayout(null);

		orderedListMenuBtn = new JButton("�ֹ� ����");
		orderedListMenuBtn.setBounds(630, 50, 150, 40);
		orderedListMenuBtn.addActionListener(new ActionListener() {
			Singleton s = Singleton.getInstance();

			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getOrderedListView();

			}
		});

		add(orderedListMenuBtn);
//�޴���ư
		menuBtn = new JButton("�޴���");
		menuBtn.setBounds(800, 50, 150, 40);
		Singleton s = Singleton.getInstance();

		menuBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getMenuView();

			}
		});

		menuChoice = new Choice();

		List<MenuDto> list = s.menuCtrl.getMenuList();

		for (int i = 0; i < list.size(); i++) {
			menuChoice.add(list.get(i).getMenu());
		}

		menuChoice.setBounds(150, 100, 500, 40);

		// ������
		sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(5, 1));
		sizePanel.setBorder(new LineBorder(Color.black, 1));
//		sizePanel.setBorder(BorderFactory.createEmptyBorder(10,	10,	10,	10));

		sizePanel.setBounds(100, 200, 180, 180);

		sizeLabel = new JLabel("ũ��");
		sizeGroup = new ButtonGroup();

		smallRButton = new JRadioButton("Small");
		mediumRButton = new JRadioButton("Medium");
		largeRButton = new JRadioButton("Large");

		sizePanel.add(sizeLabel);

		sizeGroup.add(smallRButton);
		sizeGroup.add(mediumRButton);
		sizeGroup.add(largeRButton);

		sizePanel.add(smallRButton);
		sizePanel.add(mediumRButton);
		sizePanel.add(largeRButton);

		//

		// ����
		kindPanel = new JPanel();
		kindPanel.setLayout(new GridLayout(5, 1, 10, 10));
		kindPanel.setBorder(new LineBorder(Color.black, 1));
//		sizePanel.setBorder(BorderFactory.createEmptyBorder(10,	10,	10,	10));

		kindPanel.setBounds(300, 200, 180, 180);

		kindLabel = new JLabel("����");

		kindGroup = new ButtonGroup();

		cornRButton = new JRadioButton("��");
		cupRButton = new JRadioButton("��");
		notRButton = new JRadioButton("����");

		kindPanel.add(kindLabel);
		kindGroup.add(cornRButton);
		kindGroup.add(cupRButton);
		

		kindPanel.add(cornRButton);
		kindPanel.add(cupRButton);
		
		//���� �Է�
		countTextField = new JTextField();
		countTextField.setBounds(150, 500, 80, 40);

		countLabel = new JLabel("��");
		countLabel.setBounds(250, 500, 60, 40);

		orderBtn = new JButton("��ٱ��Ͽ� ���");
		orderBtn.setBounds(350, 500, 140, 40);
		
		
		
		
		orderBtn.addActionListener(new ActionListener() {
			Singleton s = Singleton.getInstance();

			@Override
			public void actionPerformed(ActionEvent e) {
				if (countTextField.getText().equals("") || countTextField.getText() == null) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���!");
					return;
				}
  
				// ������ ����
				String selectedSizeButton = null;
				if (smallRButton.isSelected()) {
					selectedSizeButton = smallRButton.getText();
				} else if (mediumRButton.isSelected()) {
					selectedSizeButton = mediumRButton.getText();
				} else if (largeRButton.isSelected()) {
					selectedSizeButton = largeRButton.getText();
				} else {
					JOptionPane.showMessageDialog(null, "���̽�ũ���� ����� �������ּ���!");
					return;
				}

				// ���� ����
				String selectedKindButton = null;
				if (cornRButton.isSelected()) {
					selectedKindButton = cornRButton.getText();
				} else if (cupRButton.isSelected()) {
					selectedKindButton = cupRButton.getText();
				} else {
					selectedKindButton = "����";
				}


				int price = getPrice() * Integer.parseInt(countTextField.getText());

//				System.out.println(menuChoice.getSelectedItem());

//				JOptionPane.showMessageDialog(null, selectedButton);
//				OrderDto o = new OrderDto(id, menu, kind, size,  count, price)
				OrderDto orderDto = new OrderDto(s.getLoginID(), menuChoice.getSelectedItem(), selectedKindButton,
						selectedSizeButton, Integer.parseInt(countTextField.getText()), price);

//				s.orderCtrl.order(orderDto);

				s.setOrderDto(orderDto);
				List<OrderDto> list = s.getList();
				list.add(orderDto);
				s.setList(list);

				JOptionPane.showMessageDialog(null, orderDto.toString());

				
//				System.out.println(orderDto.getSeq());
//				System.out.println(orderDto.getSeq());

			}
		});

		cartBtn = new JButton("��ٱ��Ϸ� �̵�");
		cartBtn.setBounds(500, 500, 140, 40);
		cartBtn.addActionListener(new ActionListener() {

			Singleton s = Singleton.getInstance();

			@Override
			public void actionPerformed(ActionEvent e) {
				s.orderCtrl.getOrderListView();
			}
		});

		
		add(cartBtn);
		add(menuBtn);
		add(menuChoice);
		add(sizePanel);
		add(kindPanel);
		add(countTextField);
		add(countLabel);
		add(orderBtn);

		setBounds(100, 100, 1000, 700);
		setVisible(true);
		setLocationRelativeTo(null);    //â�� ��� ��ġ��Ŵ
		setResizable(false);			// â ������ ����

	}

	public int getPrice() {
		Singleton s = Singleton.getInstance();
		if (menuChoice.getSelectedItem().equals(s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getMenu())) {
			if (smallRButton.isSelected()) {
				return s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getSmallSize();
			} else if (mediumRButton.isSelected()) {
				return s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getMediumSize();
			} else if (largeRButton.isSelected()) {
				return s.menuCtrl.getMenuInfo(menuChoice.getSelectedItem()).getLargeSize();
			}
		}
		return 0;
	}

}

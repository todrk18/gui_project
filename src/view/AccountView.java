package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import singleton.Singleton;

public class AccountView extends JFrame implements ActionListener {
	
	private JTextField idTextF;
	private JTextField passTextF;
	private JTextField nameTextF;
	private JTextField emailTextF;

	private JButton accountBtn;
	private JButton idBtn;

	public AccountView() {
		super("ȸ������");
		setLayout(null);
		
		JLabel loginLabel = new JLabel("ȸ������ ");
		loginLabel.setBounds(140, 20, 120, 15);
		add(loginLabel);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);

		idTextF = new JTextField();
		idTextF.setBounds(100, 60, 150, 20);
		add(idTextF);
		idTextF.setColumns(10);

		idBtn = new JButton("id");
		idBtn.addActionListener(this);
		idBtn.setBounds(260, 60, 50, 20);
		add(idBtn);

		JLabel passLabel = new JLabel("PassWord:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);

		passTextF = new JTextField();
		passTextF.setBounds(100, 104, 150, 20);
		add(passTextF);

		JLabel nameLabel = new JLabel("�̸�:");
		nameLabel.setBounds(31, 148, 67, 15);
		add(nameLabel);

		nameTextF = new JTextField();
		nameTextF.setBounds(100, 148, 150, 20);
		add(nameTextF);

		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(31, 192, 67, 15);
		add(emailLabel);

		emailTextF = new JTextField();
		emailTextF.setBounds(100, 192, 150, 20);
		add(emailTextF);

		accountBtn = new JButton("ȸ������");
		accountBtn.addActionListener(this);
		accountBtn.setBounds(31, 236, 280, 50);
		add(accountBtn);

		getContentPane().setBackground(Color.gray);
		setBounds(100, 100, 350, 400);
		setVisible(true);
		setLocationRelativeTo(null);        //â�� ��� ��ġ��Ŵ
		setResizable(false);				// â ������ ����


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// JOptionPane.showMessageDialog(null, "��ư Ŭ��");
		JButton btn = (JButton) e.getSource();
		String btnTitle = btn.getLabel();

		Singleton s = Singleton.getInstance();

		if (btnTitle.equals("id")) {
			boolean b = s.memCtrl.idCheck(idTextF.getText());
			if (b) {
				JOptionPane.showMessageDialog(null, "�̹� ������� id �Դϴ�");
				idTextF.setText("");
			} else {
				JOptionPane.showMessageDialog(null, idTextF.getText() + "�� ����� �� �ֽ��ϴ�.");
			}

		} else if (btnTitle.equals("ȸ������")) {
			//	��ĭüũ
			
			s.memCtrl.regiAf(idTextF.getText(), passTextF.getText(),
								nameTextF.getText(), emailTextF.getText());
			
			this.dispose();
		}
	}
	
	

}

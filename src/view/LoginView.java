package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import singleton.Singleton;

public class LoginView extends JFrame implements ActionListener {
	
	private JTextField idTextF;
	private JPasswordField pwTextF;
	
	private JButton logBtn;
	private JButton accountBtn;
	
	public LoginView() {
		super("�α���");
		setLayout(null);
		
		JLabel loginLabel = new JLabel("�α��� ");
		loginLabel.setBounds(120, 20, 120, 15);
		add(loginLabel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);
		
		idTextF = new JTextField(10);
		idTextF.setBounds(100, 60, 150, 20);
		add(idTextF);
		
		JLabel passLabel = new JLabel("PW:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);
		
		pwTextF = new JPasswordField();
		pwTextF.setBounds(100, 104, 150, 20);
		add(pwTextF);
				
		logBtn = new JButton("log-in");
		logBtn.setBounds(31, 150, 100, 40);
		logBtn.addActionListener(this);
		add(logBtn);
		
		accountBtn = new JButton("ȸ������");
		accountBtn.setBounds(150, 150, 100, 40);
		accountBtn.addActionListener(this);
		add(accountBtn);
		
		setBounds(100, 100, 300, 280);
		getContentPane().setBackground(Color.gray);
		setVisible(true);		
		setLocationRelativeTo(null);  //â�� ��� ��ġ��Ŵ
		setResizable(false); 		//â ������ ����

		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				System.exit(0);				
			}			
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		JButton btn = (JButton)e.getSource();

		Singleton s = Singleton.getInstance();
		
		if(btn == logBtn){	// log in
			// controller�� �̵�
			s.memCtrl.loginAf(idTextF.getText(), pwTextF.getText());
			dispose();
		} else if (btn == accountBtn) { //ȸ������
			s.memCtrl.regi();
			this.dispose();
		}
	}

}

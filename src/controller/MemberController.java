package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.MemberServiceImpl;
import singleton.Singleton;
import view.AccountView;
import view.LoginView;

public class MemberController {
	
	//MemberController - > MemberService - > MemberDao
			//Service�� ��ȭ
			MemberService memberServ = new MemberServiceImpl();
			
			public void login() {
				new LoginView();
			}
			
			public void regi() {
				new AccountView();
			}
			
			public void logout() {
				Singleton s = Singleton.getInstance();
				s.setLoginID("");
				login();
			}
			
			//registerAfter
			public void regiAf(String id, String pwd, String name, String email) {
				boolean b = memberServ.addMember(new MemberDto(id, pwd, name, email, 3)); // ����� 3��
				if(b) {
					JOptionPane.showMessageDialog(null, "ȸ������ ����");
					login();
				}else {
					JOptionPane.showMessageDialog(null, "ȸ������ ����");
					regi();
				}
			}
			
			
			public void loginAf(String id, String pwd) {
				MemberDto dto = memberServ.login(id, pwd);
				if(dto == null) {
					JOptionPane.showMessageDialog(null, "id�� password�� Ʋ�Ƚ��ϴ�");
					login();
				}else {
					JOptionPane.showMessageDialog(null, dto.getId() + "�� ȯ���մϴ�");
					
					Singleton s = Singleton.getInstance();
					s.setLoginID(dto.getId());
					
					
					s.orderCtrl.getOrderView();
					
				}
			}
			
			public boolean idCheck(String id) {
				return memberServ.getId(id);
			}
			

}

package service;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.MemberDto;

//Controller�� dao�� �߰���(�߰���)
public class MemberServiceImpl implements MemberService {
	
	MemberDao dao = new MemberDaoImpl();

	@Override
	public boolean getId(String id) {
		return dao.getId(id);
	}

	@Override
	public boolean addMember(MemberDto dto) {
		return dao.addMember(dto);
	}

	@Override
	public MemberDto login(String id, String pwd) {
		return dao.login(id, pwd);
	}

}

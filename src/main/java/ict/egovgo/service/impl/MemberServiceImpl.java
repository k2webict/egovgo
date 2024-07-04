package ict.egovgo.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ict.egovgo.dao.MemberDAO;
import ict.egovgo.domain.MemberVO;
import ict.egovgo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;

	@Override
	public MemberVO login(MemberVO memberVO) throws SQLException {
		return dao.login(memberVO);
	}

	@Override
	public List<MemberVO> memberList(MemberVO memberVO) throws SQLException{
		return dao.memberList(memberVO);
	}

	@Override
	public List<MemberVO> userList(MemberVO memberVO) throws SQLException {
		
		return dao.userList(memberVO);
	}
}

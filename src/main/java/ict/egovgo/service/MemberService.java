package ict.egovgo.service;

import java.sql.SQLException;
import java.util.List;

import ict.egovgo.domain.MemberVO;

public interface MemberService {
	
	/*
	 * 사용자 로그인 정보를 조회한다.
	 * INPUT - UserVO
	 * OUTPUT - UserVO
	 */
	public MemberVO login(MemberVO memberVO) throws SQLException;
	
	public List<MemberVO> memberList(MemberVO memberVO) throws SQLException;
	
	public List<MemberVO> userList(MemberVO memberVO) throws SQLException;
	
}


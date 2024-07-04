package ict.egovgo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ict.egovgo.domain.MemberVO;

@Repository
public class MemberDAO  {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace ="ict.egovgo.mapper.memberMapper";

	public MemberVO login(MemberVO memberVO) throws SQLException {
		return sqlSession.selectOne(namespace +".login", memberVO);
	}
	
	public List<MemberVO> memberList(MemberVO memberVO) throws SQLException{
		return sqlSession.selectList(namespace +".memberList", memberVO);
	}
	
	public List<MemberVO> userList(MemberVO memberVO) throws SQLException{
		return sqlSession.selectList(namespace +".userList", memberVO);
	}

}

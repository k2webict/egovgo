package ict.egovgo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ict.egovgo.domain.DataManageVO;
import ict.egovgo.domain.MemberVO;

public interface DataManageService {
	
	//Local
	public static final String FILE_DIRECTORY = "C:/upload/";

	//조회
	public List<DataManageVO> selectDataManageList(Map<String, Object> param) throws SQLException;	
	
	
	public List<MemberVO> selectUserInfoList(Map<String, Object> param) throws SQLException;	
	
	//신규저장
	public int insertUserInfo(Map<String, Object> param) throws SQLException;
	
	//사용자 수정
	public int updateUserInfo(Map<String, Object> param) throws SQLException;
		
	//사용자 삭제
	public int deleteUserInfo(Map<String, Object> param) throws SQLException;
	
	//삭제
	public int deleteDataManage(Map<String, Object> param) throws SQLException;

	//KEY값채번
	public int selectDataManageMaxBno() throws SQLException;
	
	//등록or갱신
	public int mergeDataManage(Map<String, Object> param) throws SQLException;

	//파일정보 조회
	public DataManageVO selectUploadFileInfo(int bno) throws SQLException;

	//첨부파일 삭제
	public void deleteUploadFile(DataManageVO dataManageVO);
	
	//첨부파일 저장
	public void insertUploadFile(DataManageVO dataManageVO);
	
	//게시판 목록조회
	public List<DataManageVO> boardList(DataManageVO dataManageVo) throws SQLException;	
	
	//게시판 상세조회
	public DataManageVO boardMap(DataManageVO dataManageVo) throws SQLException;	
	
	//등록
	public void registBoard(DataManageVO dataManageVo) throws SQLException;
	
	//수정
	public void updateBoard(DataManageVO dataManageVo) throws SQLException;
	
	//삭제
	public void deleteBoard(DataManageVO dataManageVo) throws SQLException;
		

}

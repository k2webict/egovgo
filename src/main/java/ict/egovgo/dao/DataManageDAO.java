/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ict.egovgo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ict.egovgo.domain.DataManageVO;
import ict.egovgo.domain.MemberVO;

@Repository
public class DataManageDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace ="ict.egovgo.mapper.dataManagerMapper";
	
	//조회
	public List<DataManageVO> selectDataManageList(Map<String, Object> param) throws SQLException {
		return sqlSession.selectList(namespace +".selectDataManageList", param);	
	}
	
	//조회
		public List<MemberVO> selectUserInfoList(Map<String, Object> param) throws SQLException {
			return sqlSession.selectList(namespace +".selectUserInfoList", param);	
		}


	//삭제
	public int deleteDataManage(Map<String, Object> param) throws SQLException{
		return sqlSession.delete(namespace+".deleteDataManage",param);
	}
	
	//KEY값채번
	public int selectDataManageMaxBno() throws SQLException {
		return sqlSession.selectOne(namespace+".selectDataManageMaxBno");
	}
	
	//등록or갱신
	public int mergeDataManage(Map<String, Object> param) throws SQLException{
		return sqlSession.insert(namespace + ".mergeDataManage", param);
	}
	
	//파일정보 조회
	public DataManageVO selectUploadFileInfo(int bno) throws SQLException {
		return sqlSession.selectOne(namespace+".selectUploadFileInfo",bno);
	}
	
	//파일정보 갱신
	public void updateUploadFileInfo(DataManageVO dataManageVO) {
		sqlSession.update(namespace+".updateUploadFileInfo",dataManageVO);
	}
	
	
	//저장
	public int insertUserInfo(Map<String, Object> param) throws SQLException{
		return sqlSession.insert(namespace+".insertUserInfo",param);
	}


	//수정
	public int updateUserInfo(Map<String, Object> param) throws SQLException{
		return sqlSession.update(namespace+".updateUserInfo",param);
	}
	
	//삭제
	public int deleteUserInfo(Map<String, Object> param) throws SQLException{
		return sqlSession.update(namespace+".deleteUserInfo",param);
	}
	
	//조회
	public List<DataManageVO> selectBoardList(DataManageVO dataManageVo) throws SQLException {
		return sqlSession.selectList(namespace +".selectBoardList", dataManageVo);	
		}
	
	//조회
	public DataManageVO selectBoardMap(DataManageVO dataManageVo) throws SQLException {
		return sqlSession.selectOne(namespace +".selectBoardMap", dataManageVo);	
		}
	
	//조회수 업데이트
	public void updateViewCount(DataManageVO dataManageVo) throws SQLException {
		sqlSession.update(namespace +".updateViewCount", dataManageVo);
		}
	
	//등록or갱신
	public void registBoard(DataManageVO dataManageVo) throws SQLException{
		sqlSession.insert(namespace + ".registBoard", dataManageVo);
		}
	
	
	//등록or갱신
	public void updateBoard(DataManageVO dataManageVo) throws SQLException{
		sqlSession.update(namespace + ".updateBoard", dataManageVo);
		}
		
		
	//삭제
	public void deleteBoard(DataManageVO dataManageVo) throws SQLException{
		sqlSession.delete(namespace+".deleteBoard",dataManageVo);
		}

}

package ict.egovgo.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ict.egovgo.dao.DataManageDAO;
import ict.egovgo.domain.DataManageVO;
import ict.egovgo.domain.MemberVO;
import ict.egovgo.service.DataManageService;

@Service
public class DataManageServiceImpl implements DataManageService {
	
	@Inject
	private DataManageDAO dao;

	private static final Logger LOGGER = LoggerFactory.getLogger(DataManageServiceImpl.class);


	@Override
	public List<DataManageVO> selectDataManageList(Map<String, Object> param) throws SQLException {
		return dao.selectDataManageList(param);
	}
	
	
	

	@Override
	public int deleteDataManage(Map<String, Object> param) throws SQLException {
		return dao.deleteDataManage(param);
	}
	
	@Override
	public int selectDataManageMaxBno() throws SQLException {
		return dao.selectDataManageMaxBno();
	}
	
	@Override
	public int mergeDataManage(Map<String, Object> param) throws SQLException {
		return dao.mergeDataManage(param);
	}
	
	@Override
	public DataManageVO selectUploadFileInfo(int bno) throws SQLException {
		return dao.selectUploadFileInfo(bno);
	}
	
	@Override
	public void deleteUploadFile(DataManageVO dataManageVO){
		String filePath = dataManageVO.getAtch_path();
	    String fileName = dataManageVO.getAtch_uuid();
	    
	    File file = new File(filePath, fileName);
	    if (file.exists()) {
	        if (file.delete()) {
	        	LOGGER.info("첨부파일 삭제 성공");
	        } else {
	        	LOGGER.info("첨부파일 삭제 실패");
	        }
	    } else {
	    	LOGGER.info("삭제할 첨부파일이 없습니다.");
	    }
	}
	
	@Override
	public void insertUploadFile(DataManageVO dataManageVO) {
		MultipartFile uploadFile = dataManageVO.getUploadFile();
		if (uploadFile != null && !uploadFile.isEmpty()) {
	        String originalFilename = uploadFile.getOriginalFilename();
	        String gubunCode = dataManageVO.getGubun();
	        
	        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
	        
	        if (!".zip".equalsIgnoreCase(extension)) {
	            LOGGER.info("첨부파일 확장자 불일치");
	        }else {
	        	dataManageVO.setAtch_original_name(originalFilename);
	      
	        	String atchUuid = UUID.randomUUID().toString()+"("+originalFilename+")"+ extension;
	            dataManageVO.setAtch_uuid(atchUuid);
	            
	            String atchPath = gubunSetting(gubunCode);
	            	            
	            dataManageVO.setAtch_path(atchPath);

	            File directory = new File(atchPath);
	            
	            if (!directory.exists()) {
	                boolean created = directory.mkdirs();
	                if (!created) {
	                    LOGGER.error("파일 저장 경로 생성 중 오류 발생");
	                }
	            }
	            File targetFile = new File(directory, atchUuid);
	            try {
	                uploadFile.transferTo(targetFile);
	                LOGGER.info("파일저장 성공");
	                //파일정보 갱신
	                dao.updateUploadFileInfo(dataManageVO);
	            } catch (IOException e) {
	                LOGGER.error("PDF 파일 저장 중 오류 발생", e);
	            }
	        }
		}		
	}
	
	
	public static String gubunSetting(String gubunCode) {
		
		String basePath = "/C:/upload"; 
		
        switch (gubunCode) {
		case "1": basePath += "/계획보고";
			break;

		case "2": basePath += "/착수보고";
			break;
			
		case "3": basePath += "/자료제출요구 및 현장조사";
		break;
		
		case "4": basePath += "/결과보고";
		break;
		
		case "5": basePath += "/사전통지 및 시정조치";
		break;
		
		case "6": basePath += "/안건";
		break;
		
		case "7": basePath += "/시정조치 통보";
		break;
		
		case "8": basePath += "/이행결과 보고";
		break;
		
		case "9": basePath += "/이행실태 점검";
		break;
		
		case "10": basePath += "/이의제기 및 법원제출 통보";
		break;
		
		}
        
        return basePath;
        
	}

	//유저 리스트
	@Override
	public List<MemberVO> selectUserInfoList(Map<String, Object> param) throws SQLException {
		return dao.selectUserInfoList(param);
	}



	//신규 저장
	@Override
	public int insertUserInfo(Map<String, Object> param) throws SQLException {
		return dao.insertUserInfo(param);
	}



	//정보 수정
	@Override
	public int updateUserInfo(Map<String, Object> param) throws SQLException {
		return dao.updateUserInfo(param);
	}



	//정보 삭제
	@Override
	public int deleteUserInfo(Map<String, Object> param) throws SQLException {
		return dao.deleteUserInfo(param);
	}




	@Override
	public List<DataManageVO> boardList(DataManageVO dataManageVo) throws SQLException {
		return dao.selectBoardList(dataManageVo);
	}


	@Override
	public DataManageVO boardMap(DataManageVO dataManageVo) throws SQLException {
		//조회수 증가
		DataManageVO boardMap = dao.selectBoardMap(dataManageVo);
		if(boardMap != null) {
			int viewCnt = boardMap.getView_count() + 1;
			boardMap.setView_count(viewCnt);
			dao.updateViewCount(boardMap);
		}
		return boardMap;
	}
	
	@Override
	public void registBoard(DataManageVO dataManageVo) throws SQLException {
		
		int board_idno =dao.selectDataManageMaxBno();
		
		dataManageVo.setBoard_idno(board_idno);
		
		dao.registBoard(dataManageVo);
	}
	
	@Override
	public void updateBoard(DataManageVO dataManageVo) throws SQLException {
		dao.updateBoard(dataManageVo);
	}
	
	
	@Override
	public void deleteBoard(DataManageVO dataManageVo) throws SQLException {
		dao.deleteBoard(dataManageVo);
	}
}

package ict.egovgo.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ict.egovgo.domain.DataManageVO;
import ict.egovgo.domain.MemberVO;
import ict.egovgo.service.DataManageService;

@Controller
@RequestMapping("/data")
public class DataManageRestController {
	
	@Inject
	private DataManageService service;
	
	private static Logger LOGGER = LoggerFactory.getLogger(DataManageRestController.class);
		
	//
	@ResponseBody
	@RequestMapping("/selectUserInfoList.do")
	public List<MemberVO> selectUserInfoList(@RequestParam(required=false) Map<String, Object> param) {
		
		List<MemberVO> selectUserInfoList = null; 
		try {
			selectUserInfoList = service.selectUserInfoList(param);
		}catch (SQLException e) {
			LOGGER.error("조회에러");
		}
		return selectUserInfoList;
	}
	
	
	@ResponseBody
	@RequestMapping("/saveUserInfo.do")
	public Map<String,Object> saveUserInfo(@RequestParam(required=false) Map<String, Object> param) throws SQLException {
		
		String saveStatus =param.get("saveStatus")+"";
		int saveResult=0;
		String state =null;
		Map<String, Object> result = new HashMap<>();
		
		 switch (saveStatus) {
	        case "I":
	            saveResult = service.insertUserInfo(param);
	            state = "저장";
	            break;
	        case "U":
	            saveResult = service.updateUserInfo(param);
	            state = "수정";
	            break;
	        default:
	            saveResult = service.deleteUserInfo(param);
	            state = "삭제";
	            break;
	    }

	    result.put("message", saveResult < 0 ? state + "에 실패하였습니다." : state + "되었습니다.");
	    return result;
	}
	
	
		//게시판 조회
		@RequestMapping("/selectBoardPage.do" )
		public String selectBoardPage(HttpServletRequest request,@RequestParam(required=false) Map<String, Object> param, DataManageVO dataManageVo, Model model) {
			try {	
				//게시판리스트
				List<DataManageVO> boardList = service.boardList(dataManageVo);
				
				model.addAttribute("boardList", boardList);
			    model.addAttribute("param", dataManageVo);
			}catch (SQLException e) {
				// TODO: handle exception
			}
			return "board/boardPage";
		}
		
		//게시판 상세
		@RequestMapping("selectBoardDetailView.do")
		public String selectBoardDetailView(HttpServletRequest request, @RequestParam(required=false) Map<String, Object> param, DataManageVO dataManageVo, Model model) {
			//게시판맵
			try {
				DataManageVO boardMap = service.boardMap(dataManageVo);
				model.addAttribute("boardMap", boardMap);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "board/boardDetailView";
		}
		
		
		
		//게시판 등록 페이지
		@RequestMapping("registBoardInfo.do")
		public String registBoardInfo(HttpServletRequest request, @RequestParam(required=false) Map<String, Object> param, DataManageVO dataManageVo, Model model) {
			
			return "board/boardRegistView";
		}
		
		//게시판 등록
		@RequestMapping("dataManageRegistForm.do")
		public String dataManageRegistForm(HttpServletRequest request, @RequestParam(required=false) Map<String, Object> param, DataManageVO dataManageVo, Model model, HttpSession session) {
			//게시판 등록
			try {
				MemberVO memberVO = (MemberVO) session.getAttribute("loginSession");
				String userNm = memberVO.getUser_nm();
				dataManageVo.setAuthor(userNm);
				service.registBoard(dataManageVo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/data/selectBoardPage.do";
		}
		
		
		//자료관리 시스템 데이터 등록
		@RequestMapping("dataManageUpdate.do")
		public String dataManageUpdateForm(HttpServletRequest request, @RequestParam(required=false) Map<String, Object> param, DataManageVO dataManageVo, Model model, HttpSession session) {
			//게시판 등록
			try {
				service.updateBoard(dataManageVo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/data/selectBoardPage.do";
		}
		
		//자료관리 시스템 데이터 삭제
		@RequestMapping("dataManageDelete.do")
		public String dataManageDelete(HttpServletRequest request, @RequestParam(required=false) Map<String, Object> param, DataManageVO dataManageVo, Model model) {
			//게시판 삭제
			try {
				service.deleteBoard(dataManageVo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "redirect:/data/selectBoardPage.do";
		}
		
		
}

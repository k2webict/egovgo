package ict.egovgo.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ict.egovgo.domain.DataManageVO;
import ict.egovgo.domain.MemberVO;
import ict.egovgo.service.MemberService;

@Controller
public class LoginController {
	
	@Inject
    PasswordEncoder passwordEncoder;
	
	@Inject
	private MemberService service;
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	private static final String LOGIN_SESSION = "loginSession";
	
	@RequestMapping(value = {"/", "/login.do"})
	public String index(HttpSession session, RedirectAttributes ra, Model model) {
		return "/member/login";
	}
	
	@PostMapping("/member/loginPost.do")
	public String login(MemberVO memberVO, HttpSession session, RedirectAttributes ra) {
		System.out.println(memberVO.getUser_id());
		try {
			MemberVO member = service.login(memberVO);
			if (member == null) {
				ra.addFlashAttribute("message", "Please check your ID and password again.");
	            return "redirect:/login.do";
			} else {
				String userPw = memberVO.getUser_pw();
				/*if (!passwordEncoder.matches(userPw, member.getUser_pw())) {
	                LOGGER.info("Password mismatch");
	                ra.addFlashAttribute("message", "Please check your ID and password again.");
	                return "redirect:/login.do";
	            }*/
				
				memberVO.setUser_nm(member.getUser_nm());
	            return "forward:/data/dataManagePage.do"; 
	            }
		} catch (SQLException e) {
			LOGGER.error("An error occurred while logging in.", e);
	        ra.addFlashAttribute("message", "An error occurred while logging in. Please try again later.");
	        return "redirect:/login.do";
	    }
	}
	
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request, HttpSession session, MemberVO memberVO, RedirectAttributes ra, Model model) {
		session.removeAttribute(LOGIN_SESSION);
		session.invalidate();
		return "/member/login";
	}
	
	
	//사원관리 페이지
	@RequestMapping("/data/dataManagePage.do")
	public String dataManagePage(MemberVO memberVO, Model model) {
		try {	
			//사용자리스트
			//List<MemberVO> memberList = service.memberList(memberVO); 
			//유저리스트
			List<MemberVO> userList = service.userList(memberVO); 
			//model.addAttribute("memberList", memberList);
			model.addAttribute("userList", userList);
			
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return "dataManager/dataManagePage";
	}

	
	
}

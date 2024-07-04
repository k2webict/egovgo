package ict.egovgo.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN_SESSION = "loginSession";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();

		ModelMap modelMap = modelAndView.getModelMap();
		Object loginSession = modelMap.get("memberVO");

		if (loginSession != null) {
			logger.info("new login Session");
			session.setAttribute(LOGIN_SESSION, loginSession);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN_SESSION) != null) {
			logger.info("clear login Session");
			session.removeAttribute(LOGIN_SESSION);
		}

		return true;
	}
}

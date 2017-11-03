package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

public class LoginAction implements IAction {
	
	// 입력값 검증
	private void validate(String id, String pwd) throws Exception {
		if (CommonUtil.isEmpty(id)) throw new Exception("아이디를 입력하세요.");
		if (CommonUtil.isEmpty(pwd)) throw new Exception("비밀번호를 입력하세요.");
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			// 1. 입력값 추출
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			System.out.printf("id : %s, pwd : %s \n", id, pwd);
			
			// 2. 입력값 검증
			validate(id, pwd);
			
			// id, pwd 정합성 체크
			boolean result = true;
			
			if (result) {
				// 세션에 사용자 정보를 생성해서 담기
				HttpSession session = request.getSession();
				UserVO user = new UserVO();
				user.setId(id);
				user.setName("홍길동");
				user.setNickname("의적");
				
				session.setAttribute("user", user);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
				rd.forward(request, response);
			} else {
				throw new Exception("Invalid username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		}
	}

}

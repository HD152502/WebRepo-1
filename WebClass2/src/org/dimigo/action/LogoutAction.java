package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션에 사용자 정보 삭제
		HttpSession session = request.getSession();
				
		session.invalidate();
				
		RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
		rd.forward(request, response);
	}

}

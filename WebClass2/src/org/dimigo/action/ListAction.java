package org.dimigo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.vo.UserVO;

public class ListAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("aaa@naver.com", "안용식", "용팔이"));
		list.add(new UserVO("bbb@naver.com", "이재승", "리중딱"));
		list.add(new UserVO("ccc@naver.com", "", ""));
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
		rd.forward(request, response);
	}

}

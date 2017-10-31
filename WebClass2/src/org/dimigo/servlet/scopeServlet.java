package org.dimigo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class scopeServlet
 */
@WebServlet(name = "ScopeServlet", urlPatterns = { "/scope" })
public class scopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scopeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// id, pwd 값을 뽑아서 출력하기
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			System.out.printf("id : %s, pwd : %s \n", id, pwd);
			
			if (id == null || id.trim().equals("")) throw new Exception("아이디는 필수 항목입니다.");
			
			// 1. request scope
			request.setAttribute("key", "rValue");
			
			// 2. session scope
			request.getSession().setAttribute("key", "sValue");
			
			// 3. application scope
			request.getServletContext().setAttribute("key", "aValue");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/scope.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/scope.jsp");
			rd.forward(request, response);
		}
	}

}

package jp.co.aforce.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.been.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;


public class LoginAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		HttpSession session = request.getSession();
		
		
		String login =request.getParameter("login");
		String password = request.getParameter("password");
		CustomerDAO dao =new CustomerDAO();
		Customer customer= dao.search(login,password);
		
		if(customer != null) {
			session.setAttribute("customer", customer);
			return "login-out.jsp";
		}
		return "login-error.jsp";
	}

}

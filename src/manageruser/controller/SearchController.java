package manageruser.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * class nhan thong tin tu form search
 * day sang listuser hien thong tin
 * @author Chu lun Kute
 *
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	/**
	 * lay cac thong tin form search
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String groupName = request.getParameter("groupName");
		session.setAttribute("fullName", fullName);
		session.setAttribute("email", email);
		session.setAttribute("groupName", groupName);
		RequestDispatcher view = request.getRequestDispatcher("ListUserController");
		view.forward(request, response);
		
	}

}

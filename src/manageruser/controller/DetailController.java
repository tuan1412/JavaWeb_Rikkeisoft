package manageruser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.model.User;
import manageruser.service.GetInfoService;
import manageruser.service.serviceimpl.GetInfoImpl;
/**
 * Hien thi va xoa sua user
 * @author Chu lun Kute
 *
 */
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DetailController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		//goi service
		GetInfoService getInfo = new GetInfoImpl(userId);
		User user = getInfo.getInfoUser();
		//truyen tra lai tham so
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		RequestDispatcher view = request.getRequestDispatcher("detail.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

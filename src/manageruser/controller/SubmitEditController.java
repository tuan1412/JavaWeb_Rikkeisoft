package manageruser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.model.User;
import manageruser.service.UpdateInfoService;
import manageruser.service.serviceimpl.UpdateInfoImpl;
/**
 * Xac nhan edit user
 * @author Chu lun Kute
 *
 */
public class SubmitEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SubmitEditController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		UpdateInfoService uService = new UpdateInfoImpl(user);
		uService.updateInfo();
		request.setAttribute("type", "Edit");
		request.setAttribute("des", "detail.jsp");
		RequestDispatcher view = request.getRequestDispatcher("success.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

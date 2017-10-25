package manageruser.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.model.User;
import manageruser.service.DeleteService;
import manageruser.service.serviceimpl.DeleteUserServiceImpl;

/**
 * Xoa logic user
 */

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lay id
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getUserId();
		//goi dich vu xoa 
		DeleteService deService = new DeleteUserServiceImpl(userId);
		deService.deleteUser();
		//dua ve trang listuser
		session.removeAttribute("user");
		response.sendRedirect(request.getContextPath() + "/ListUserController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

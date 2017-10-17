package manageruser.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.constant.Constant;
import manageruser.service.LoginService;
import manageruser.service.serviceimpl.LoginServiceImpl;
/**
 * Class de kiem tra dang nhap
 * thong bao loi khi dang nhap that bai 
 * chuyen huong sang list_user khi dang nhap thanh cong 
 * @author Chu lun Kute
 *
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
        super();
    }
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doGet(req, resp);
	}
    
    /**
     * Kiem tra xem form login dung chuan ko
     * Neu user ton tai, tao session
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		

		LoginService loginService = new LoginServiceImpl();
		List<String> errors = new ArrayList<>();
		
		errors = loginService.validate(username, password);
		
		if (errors.isEmpty()) {
			HttpSession session = request.getSession(true);
			session.setAttribute(Constant.LOGGED_IN_USER, username);
			response.sendRedirect(request.getContextPath() + "/ListUserController");
			return;
		}else {
			request.setAttribute("errors", errors);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
	}
}

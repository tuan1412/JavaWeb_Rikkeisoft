package manageruser.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Class nay de log out va xoa session cua user
 * @author Chu lun Kute
 *
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutController() {
        super();
      
    }
	/**
	 * xoa session
	 * chuyen huong ve trang dang nhap
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

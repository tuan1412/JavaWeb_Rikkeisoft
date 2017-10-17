package manageruser.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class de chuyen ve sang listuser ban dau
 * @author Chu lun Kute
 *
 */
public class TopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopController() {
        super();
     
    }
    /**
     * xoa cac thuoc tinh cua form search
     * dua ve trang list user ban dau
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("fullName");
		session.removeAttribute("email");
		session.removeAttribute("groupName");
		response.sendRedirect(request.getContextPath() + "/ListUserController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

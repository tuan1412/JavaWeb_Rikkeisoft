package manageruser.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.model.User;
import manageruser.service.RegistrationService;
import manageruser.service.serviceimpl.EditValidate;


/**
 * Edit info
 * @author Chu lun Kute
 *
 */
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lay thong tin tu form
		User user = new User();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user");
		user.setFullName(request.getParameter("fullName"));
		user.setFullNameKana(request.getParameter("fullNameKana"));
		user.setGender(request.getParameter("gender"));
		user.setEmail(request.getParameter("email"));
		user.setBirthday(request.getParameter("birthday"));
		user.setLinkImage(request.getParameter("linkImage"));
		user.setGroupName(request.getParameter("groupName"));
		user.setNameLevel(request.getParameter("nameLevel"));
		user.setTotal(Integer.parseInt(request.getParameter("total")));	
		user.setEndDate(request.getParameter("endDate"));
		session.setAttribute("user", user);
		//goi dich vu validate
		RegistrationService rService = new EditValidate(user);
		List<String> errors = rService.validate();
		//goi dich vu update neu validate done or nguoc lai
		if (errors.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher("editconfirm.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("errors", errors);
			RequestDispatcher view = request.getRequestDispatcher("edit.jsp");
			view.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

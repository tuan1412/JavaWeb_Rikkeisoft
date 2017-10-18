package manageruser.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.model.RegForm;
import manageruser.service.RegistrationService;
import manageruser.service.serviceimpl.RegistrationServiceImpl;

/**
 * Class thuc hien them mot user
 * @author Chu lun Kute
 *
 */
public class AddNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddNewController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegForm regForm = new RegForm();
		getInfoForm(regForm, request);
		setInfoForm(regForm, request);
		
		RegistrationService regService = new RegistrationServiceImpl(regForm);
		List<String> errors = regService.validate();
		
		if (errors.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/confirm.jsp");
		}else {
			request.setAttribute("errors", errors);
			RequestDispatcher view = request.getRequestDispatcher("register.jsp");
			view.forward(request, response);
		}
		
		
	}
	
	/**
	 * Ham lay thuoc tinh tu form truyen vao regForm
	 * @param regForm
	 * @param request
	 */
	public static void getInfoForm(RegForm regForm, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		regForm.setFullName(request.getParameter("fullName"));
		regForm.setFullNameKana(request.getParameter("fullNameKana"));
		regForm.setGender(request.getParameter("gender"));
		regForm.setEmail(request.getParameter("email"));
		regForm.setLoginName(request.getParameter("loginName"));
		regForm.setPassword(request.getParameter("password"));
		regForm.setConfirmPassword(request.getParameter("confirmPassword"));
		regForm.setBirthday(request.getParameter("birthday"));
		regForm.setTel(request.getParameter("tel"));
		regForm.setLinkImage(request.getParameter("linkImage"));
		regForm.setNameLevel(request.getParameter("nameLevel"));
		regForm.setTotal(request.getParameter("total"));
		regForm.setGroupName(request.getParameter("groupName"));
		regForm.setStartDate(request.getParameter("startDate"));
		regForm.setEndDate(request.getParameter("endDate"));
	}
	/**
	 * Ham dat cac thuoc tinh lay ra tu form
	 */
	public static void setInfoForm(RegForm regForm, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("regForm", regForm);
	}
}

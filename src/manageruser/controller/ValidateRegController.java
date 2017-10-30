package manageruser.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.model.RegForm;
import manageruser.service.ValidateService;
import manageruser.service.UploadService;
import manageruser.service.serviceimpl.ValidateRegFormImpl;
import manageruser.service.serviceimpl.UploadImgService;

/**
 * Class thuc hien validate form dang ki 
 * dieu huong sang confirm insert khi thanh cong
 * 
 * @author Chu lun Kute
 *
 */
@MultipartConfig
public class ValidateRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateRegController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// remove nhung thong tin tu form dang ky cu neu co
		HttpSession session = request.getSession();
		session.removeAttribute("regForm");

		// lay info tu form dang ky
		RegForm regForm = new RegForm();
		getInfoForm(regForm, request);
	
		// validate form
		ValidateService regService = new ValidateRegFormImpl(regForm);
		Map<String, String> errors = regService.validate();

		// xu ly sau validate
		if (errors.isEmpty()) {
			UploadService uploadService = new UploadImgService("linkImage", request);
			regForm.setLinkImage(uploadService.upload());
			setInfoForm(regForm, request);
			response.sendRedirect(request.getContextPath() + "/confirm.jsp");
		} else {
			request.setAttribute("errors", errors);
			setInfoForm(regForm, request);
			RequestDispatcher view = request.getRequestDispatcher("register.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * Ham lay thuoc tinh tu form truyen vao regForm
	 * 
	 * @param regForm
	 * @param request
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getInfoForm(RegForm regForm, HttpServletRequest request) throws IOException, ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
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
		regForm.setLinkImage(request.getPart("linkImage").getSubmittedFileName());
		regForm.setNameLevel(request.getParameter("nameLevel"));
		regForm.setTotal(request.getParameter("total"));
		regForm.setGroupName(request.getParameter("groupName"));
		regForm.setStartDate(request.getParameter("startDate"));
		regForm.setEndDate(request.getParameter("endDate"));

	}

	/**
	 * Ham dat cac thuoc tinh lay ra tu form
	 */
	public void setInfoForm(RegForm regForm, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("regForm", regForm);
	}
}

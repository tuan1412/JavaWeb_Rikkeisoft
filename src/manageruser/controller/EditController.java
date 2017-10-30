package manageruser.controller;


import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manageruser.model.User;
import manageruser.service.ValidateService;
import manageruser.service.UploadService;
import manageruser.service.serviceimpl.ValidateEditForm;
import manageruser.service.serviceimpl.UploadImgService;


/**
 * Lay thong tin tu form edit
 * @author Chu lun Kute
 *
 */
@MultipartConfig
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lay thong tin tu form
		User user = getInfoForm(request);
			
		//goi dich vu validate
		ValidateService rService = new ValidateEditForm(user);
		Map<String, String> errors = rService.validate();
		
		//goi dich vu update neu validate done or nguoc lai
		if (errors.isEmpty()) {
			UploadService uploadService = new UploadImgService("linkImage", request);
			user.setLinkImage(uploadService.upload());
			setInfo(user, request);
			RequestDispatcher view = request.getRequestDispatcher("editconfirm.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("errors", errors);
			setInfo(user, request);
			RequestDispatcher view = request.getRequestDispatcher("edit.jsp");
			view.forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * Dua thong tin tu form vao user
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	private User getInfoForm(HttpServletRequest request) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		user.setUserId(user.getUserId());
		user.setFullName(request.getParameter("fullName"));
		user.setFullNameKana(request.getParameter("fullNameKana"));
		user.setGender(request.getParameter("gender"));
		user.setTel(request.getParameter("tel"));
		user.setEmail(request.getParameter("email"));
		user.setBirthday(request.getParameter("birthday"));
		user.setLinkImage(request.getPart("linkImage").getSubmittedFileName());
		user.setGroupName(request.getParameter("groupName"));
		user.setNameLevel(request.getParameter("nameLevel"));
		user.setTotal(Integer.parseInt(request.getParameter("total")));	
		user.setEndDate(request.getParameter("endDate"));
		return user;	
	}
	/**
	 * Dua thong tin user vao session
	 * @param user
	 * @param request
	 */
	private void setInfo(User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
	}
}

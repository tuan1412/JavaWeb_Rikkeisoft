package manageruser.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.constant.Constant;
import manageruser.model.User;
import manageruser.service.PagingService;
import manageruser.service.serviceimpl.PagingServiceImpl;
import manageruser.service.serviceimpl.PagingServiceOrderImpl;

/**
 * Class nay de hien thi list user theo che do phan trang
 * 
 * @author Chu lun Kute
 *
 */
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListUserController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Kiem tra cac thuoc tinh tim kiem bang session Dua thuoc tinh list user can
	 * hien thi vao JSP
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		String fullName = session.getAttribute("fullName") != null ? (String) session.getAttribute("fullName") : "";
		String email = session.getAttribute("email") != null ? (String) session.getAttribute("email") : "";
		String groupName = session.getAttribute("fullName") != null ? (String) session.getAttribute("groupName") : "";

		String sortType = request.getParameter("sortType") != null ? request.getParameter("sortType") : "";
		String direction = request.getParameter("direction") != null ? request.getParameter("direction") : "";

		int page = (request.getParameter("page") != null) ? (page = Integer.parseInt(request.getParameter("page"))) : 1;

		PagingService pagingService;
		if ("".equals(sortType)) {
			pagingService = new PagingServiceImpl(page, fullName, email, groupName);
		} else {
			pagingService = new PagingServiceOrderImpl(page, fullName, email, groupName, sortType, direction);
		}

		List<User> users = pagingService.getContentPage();
		int noOfSection = pagingService.getNoOfSection();
		int startPage = pagingService.getStartPage();
		int endPage = pagingService.getEndPage();
		int section = pagingService.getCurrentSection();

		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("currentSection", section);
		request.setAttribute("users", users);
		request.setAttribute("noOfSection", noOfSection);
		request.setAttribute("sectionSize", Constant.SECTION_SIZE);
		request.setAttribute("sortType", sortType);
		request.setAttribute("direction", direction);

		RequestDispatcher view = request.getRequestDispatcher("listuser.jsp");
		view.forward(request, response);
	}
}

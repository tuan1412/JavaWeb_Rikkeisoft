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
import manageruser.service.PaginationService;
import manageruser.service.serviceimpl.PaginationServiceImpl;

/**
 * Class nay de hien thi list user theo che do phan trang
 * @author Chu lun Kute
 *
 */
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ListUserController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * Kiem tra cac thuoc tinh tim kiem bang session
	 * Dua thuoc tinh list user can hien thi vao JSP
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullName = "";
		String email = "";
		String groupName = "";
		
		HttpSession session = request.getSession(true);
		if  (session.getAttribute("fullName") != null) {
			fullName = (String) session.getAttribute("fullName");
		};
		if  (session.getAttribute("email") != null) {
			email = (String) session.getAttribute("email");
		};
		if  (session.getAttribute("groupName") != null) {
			groupName = (String) session.getAttribute("groupName");
		};
		String sortType ="";
		if (request.getParameter("sortType") != null) {
			sortType = request.getParameter("sortType");
		}
		String direction="";
		if (request.getParameter("direction") != null) {
			direction = request.getParameter("direction");
		}
	
		int page = 1;
		if(request.getParameter("page") != null) {
             page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<User> users = null;
		PaginationService paginationService = new PaginationServiceImpl(page, fullName, email, groupName, sortType, direction);
		if (!("".equals(sortType))) {
			 users = paginationService.getContentPageWithOrder();
		}else {
			users = paginationService.getContentPage();
		}
		
		int noOfSection = paginationService.getNoOfSection();
		int startPage = paginationService.getStartPage();
		int endPage = paginationService.getEndPage();
		int section = paginationService.getCurrentSection();
	
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

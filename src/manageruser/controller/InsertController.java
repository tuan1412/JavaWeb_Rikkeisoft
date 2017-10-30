package manageruser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageruser.model.RegForm;
import manageruser.service.InsertService;
import manageruser.service.serviceimpl.InsertServiceImpl;

/**
 * Insert them thanh vien
 * dieu huong sang trang thong bao thanh cong
 */

public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//nhan thong tin tu form
		HttpSession session = request.getSession();
		RegForm regForm = (RegForm) session.getAttribute("regForm");
		
		//goi service insert user
		InsertService insertService = new InsertServiceImpl(regForm);
		insertService.insert();
		session.removeAttribute("regForm");
		
		//dieu huong sang trang success
		request.setAttribute("type", "Insert user");
		request.setAttribute("des", "ListUserController");
		RequestDispatcher view = request.getRequestDispatcher("success.jsp");
		view.forward(request, response);
	}

}

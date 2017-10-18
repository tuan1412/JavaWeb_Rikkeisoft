package manageruser.controller;

import java.io.IOException;
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
		HttpSession session = request.getSession();
		RegForm regForm = (RegForm) session.getAttribute("regForm");
		InsertService insertService = new InsertServiceImpl(regForm);
		insertService.insert();
		
		response.sendRedirect(request.getContextPath() + "/ListUserController");
	}

}

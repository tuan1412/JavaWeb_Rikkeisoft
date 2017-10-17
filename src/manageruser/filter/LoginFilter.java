package manageruser.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import manageruser.constant.Constant;

/**
 * Authentication Fitler Chuyen huong khi ng dung chua login
 */

public class LoginFilter implements Filter {
	private List<String> whiteURLs;

	public LoginFilter() {

	}

	public void destroy() {

	}
	/**
	 * voi cac trang can dang nhap chuyen huong ve trang dang nhap
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if (checkWhiteURL(path)) {
			chain.doFilter(req, res);
		} else {
			HttpSession session = request.getSession(false);
			String userInfo = (String) session.getAttribute(Constant.LOGGED_IN_USER);
			if (userInfo != null) {
				chain.doFilter(req, res);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(req, res);
			}
		}
	}

	/**
	 * Them cac trang khong can dang nhap
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		whiteURLs = new ArrayList<String>();
		whiteURLs.add("/LoginController");
	}
	/**
	 * Kiem tra cac trang khong can dang nhap
	 * @param path
	 * @return
	 */
	private boolean checkWhiteURL(String path) {
		boolean isWhiteURL = false;
		for (String whiteURL : whiteURLs) {
			isWhiteURL = "/".equals(path) || path.contains(whiteURL) ? true : false;
			if (isWhiteURL)
				break;
		}
		return isWhiteURL;
	}

}

package dominos.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominos.DAO.IUserDao;
import dominos.DAO.UserDao;
import dominos.OOP.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().startsWith("Cart")) {
				int productID = Integer.parseInt(cookie.getValue());
				User user = (User) request.getSession().getAttribute("user");
				String userID = user.getUsername();
				IUserDao userDao = UserDao.getInstance();
				userDao.insertIntoProductUsers(userID, productID);
				String cname = cookie.getName();
				Cookie cookieDelt = new Cookie(cname, "");
				cookieDelt.setMaxAge(0);
				response.addCookie(cookieDelt);
			}
		}
		response.sendRedirect("./shoppingcart.jsp");
	}
}

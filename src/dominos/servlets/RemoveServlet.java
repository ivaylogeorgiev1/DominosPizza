package dominos.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominos.DAO.IProductDAO;
import dominos.DAO.ProductDAO;
import dominos.OOP.Product;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveServlet() {
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
				String cname = cookie.getName();
				Cookie cookieDelt = new Cookie(cname, "");
				cookieDelt.setMaxAge(0);
				response.addCookie(cookieDelt);
			}
		}
		response.sendRedirect("./shoppingcart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IProductDAO pd = ProductDAO.getInstance();
		Enumeration<String> idOfUsername = request.getParameterNames();
		while (idOfUsername.hasMoreElements()) {
			String id = (String) idOfUsername.nextElement();
			pd.deleteOrder(id);
		}
		response.sendRedirect("./profileadmin.jsp");
	}

}

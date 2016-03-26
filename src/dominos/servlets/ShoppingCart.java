package dominos.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominos.DAO.IProductDAO;
import dominos.DAO.ProductDAO;
import dominos.OOP.Product;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(false) == null) {
			response.sendRedirect("./");
			return;
		}
		response.sendRedirect("./shoppingcart.jsp");
		// int idProduct;
		// IProductDAO pDao = ProductDAO.getInstance();
		// Product product;
		// PrintWriter pw = response.getWriter();
		// for (Cookie cookie : request.getCookies()) {
		// if (cookie.getName().startsWith("Cart")) {
		// idProduct = Integer.parseInt(cookie.getValue());
		// System.out.println(idProduct);
		// product = pDao.selectProduct(idProduct);
		// pw.print(product.getName());
		// String cname=cookie.getName();
		// Cookie cookieDelt=new Cookie(cname, "");
		// cookieDelt.setMaxAge(0);
		// response.addCookie(cookieDelt);
		// }
		// }
		// pw.close();
	}
}

package dominos.servlets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominos.DAO.UserDao;
import dominos.OOP.Product;
import dominos.OOP.User;

/**
 * Servlet implementation class menyToOrder
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null) {
			resp.sendRedirect("./login.html");
			return;

		} else {
			Enumeration<String> enumeration = req.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String idProduct = (String) enumeration.nextElement();
				System.out.print("Parameter = " + idProduct);
				Cookie cookie = new Cookie("Cart" + idProduct
						+ Math.random(), idProduct);
				resp.addCookie(cookie);
			}
			resp.sendRedirect("./menuproducts.jsp");
		}
		// Product product = (String) req.getSession().getAttribute("user");

		// UserDao.getInstance().buyThisProduct(user,
		// new Product(0, product, price), quantity);
		// doGet(req, resp);
	}
}

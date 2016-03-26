package dominos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominos.DAO.IUserDao;
import dominos.DAO.UserDao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession(false) == null) {
			String username = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String firstName = request.getParameter("first");
			String lastName = request.getParameter("last");
			String restaurant = request.getParameter("rest");
			String phone = request.getParameter("phone");
			// Set<String> validatin=new HashSet<String>();
			// validatin.add(name);
			boolean isValid = true;
			Map<String, String[]> validationMap = new HashMap<String, String[]>();
			validationMap = request.getParameterMap();
			for (String name : validationMap.keySet()) {
				for (String value : validationMap.get(name)) {
					System.out.println(value);
					if (value.equals("")) {
						isValid = false;
						// setAttrubite
						break;
					}
				}
			}
			if (isValid == false) {
				response.sendRedirect("./registration");
				return;
			}

			IUserDao userDao = UserDao.getInstance();
			if (!userDao.isThereSuchAUser(username, email)) {
				userDao.registerUser(username, password, email, firstName,
						lastName, restaurant, phone);
				response.sendRedirect("./");
			} else {
				PrintWriter pw = response.getWriter();
				// response.sendRedirect("./");
				pw.print("<body bgcolor='#9999CC'>");
				pw.print("<script language='javascript'>");
				pw.print("alert( 'This user or email already exist!' );");
				pw.print("</script>");
				response.setContentType("text/html");
				pw.print("<html><head><style type='text/css'>" + "div{"
						+ "text-align: center;}</style></head>");

				pw.print("<body><div><form action='./register.html' method='post'><input type='submit' value='Try again'</input></form></div></body></html>");
			}
		} else {
			response.sendRedirect("./");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.print("<html>Please fill in the registration from right!"
				+ "There shouldnt be empty fields");
		pw.print("<form action='./register.html' method='post'><input type='submit' value='Try again'</input></form></html>");
	}
}

package dominos.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominos.DAO.DBException;
import dominos.DAO.IUserDao;
import dominos.DAO.InvalidUserException;
import dominos.DAO.UserDao;
import dominos.OOP.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// response.getWriter().append("Served at:
	// ").append(request.getContextPath());
	// }

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		if (request.getSession(false) == null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			IUserDao userDao = UserDao.getInstance();

			User user;
			try {
				user = userDao.loginUser(username, password);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("./");
			} catch (DBException e) {
				e.printStackTrace();
				response.getWriter().println("<h1>database error</h1>");
			} catch (InvalidUserException e) {
				response.getWriter()
						.println(
								"<h1> Invalid user or password</h1><a href = './login.html'>Try again</a>");
			}
		} else {
			response.sendRedirect("./");
		}
	}
}

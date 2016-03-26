package dominos.DAO;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletePizza
 */
@WebServlet("/DeletePizza")
public class DeletePizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePizza() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(false) != null) {
			IProductDAO pDao = ProductDAO.getInstance();
			Enumeration<String> idProduct = request.getParameterNames();
			while (idProduct.hasMoreElements()) {
				int idProductInt = Integer.parseInt(idProduct.nextElement());
				pDao.deleteProduct(idProductInt);
			}
		}
		response.sendRedirect("./adminmenuproducts.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

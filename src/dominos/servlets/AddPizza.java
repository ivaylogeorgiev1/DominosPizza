package dominos.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dominos.DAO.IProductDAO;
import dominos.DAO.ProductDAO;

/**
 * Servlet implementation class AddPizza
 */
@WebServlet("/AddPizza")
public class AddPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// if(request.getSession(false!=null))
		PrintWriter pw = response.getWriter();
		IProductDAO pDao = ProductDAO.getInstance();
		String name = request.getParameter("product");
		String price = request.getParameter("price");
		String desc = request.getParameter("desc");
		Part filePart = request.getPart("photo");
		InputStream inputStream = null;
		if (filePart != null) {
			inputStream = filePart.getInputStream();
			System.out.println("FILEE "+ filePart);
		}
		if (name == null || name.equals("") || price == null
				|| inputStream == null || price.equals("") || desc == null
				|| desc.equals("")) {
			pw.print("<body bgcolor='#9999CC'>");
			System.out.println("Price " + price);
			System.out.println("name " + name);
			pw.print("<script language='javascript'>");
			pw.print("alert( 'Invalid info for the pizza! Fill in all fields!' );");
			pw.print("</script>");
			response.setContentType("text/html");
			pw.print("<html><head><style type='text/css'>" + "div{"
					+ "text-align: center;}</style></head>");

			pw.print("<body><div><form action='./adminmenuproducts.jsp' method='post'><input type='submit' value='Try again'</input></form></div></body></html>");
			
		} else {
			pDao.addProduct(name, Double.parseDouble(price), desc, inputStream);
			inputStream.close();
			response.sendRedirect("./adminmenuproducts.jsp");
		}
	}

}

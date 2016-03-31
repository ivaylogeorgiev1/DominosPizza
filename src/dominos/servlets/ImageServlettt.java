package dominos.servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlettt
 */
@WebServlet("/images/YES/*")
public class ImageServlettt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageServlettt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");

		String pathToWeb = "D:\\images";
		System.out.println(getServletContext().getRealPath(File.separator));
		File f = new File(pathToWeb + "\\"+request.getParameter("photoname"));
		BufferedImage bi = ImageIO.read(f);
		OutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		out.close();

	}

}

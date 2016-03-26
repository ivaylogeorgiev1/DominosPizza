<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping cart</title>
<style>
table, tr, td {
	text-align: center;
	font-style: oblique;
	padding: 10px;
	border: 3px solid black;
	border-collapse: collapse;
	padding: 10px;
	font-style: oblique;
	padding: 10px;
}
</style>
</head>
<body>

	<%@ page import="dominos.DAO.*"%>
	<%@ page import="dominos.OOP.Product"%>
	<%@ page import="java.io.PrintWriter"%>
	<jsp:include page="basemenu.jsp" />
	<form action="./RemoveServlet" method="get">
		<table align="center">
			<tr>

				<%
					int idProduct;
					IProductDAO pDao = ProductDAO.getInstance();
					Product product;
					PrintWriter pw = response.getWriter();
					for (Cookie cookie : request.getCookies()) {
						if (cookie.getName().startsWith("Cart")) {
							idProduct = Integer.parseInt(cookie.getValue());
							System.out.println(idProduct);
							product = pDao.selectProduct(idProduct);
				%>
				<td><%=product.getName()%> <%=product.getPrice()%> BGN</td>


				<td><input type="submit" value="Remove"></td>
			</tr>
			<%
				pw.print("<br/>");
					}
				}
			%>
		</table>
	</form>
	<form action="./OrderServlet" method="get">
		<table align="center">
			<tr>
				<td><input type="submit" value="ORDER!"></td>
			</tr>
		</table>
	</form>


</body>
</html>
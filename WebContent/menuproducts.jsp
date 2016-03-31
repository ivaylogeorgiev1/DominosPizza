<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<style>
table, tr, td {
	padding: 2px;
	border: 2px solid black;
	border-collapse: collapse;
}

hr {
	border: 0;
	border-bottom: 1px solid black;
	clear: both;
	display: block;
	height: 0;
	margin: 0 auto 10px auto;
	padding-top: 10px;
	max-width: 1000px;
	width: 100%;
}
</style>
</head>
<body>
	<%@ page import="java.util.List"%>
	<%@ page import="dominos.OOP.*"%>
	<%@ page import="dominos.DAO.*"%>
	<jsp:include page="basemenu.jsp" />

	<div class='container'>
		<div class="row">
			<%
				List<Product> products = UserDao.getInstance().getProducts();
				IProductDAO pDAO = ProductDAO.getInstance();
				for (Product p : products) {
					String photoLocation = pDAO.getPhoto(p.getId());
			%>

			<div class='col-lg-13 bg-success'>
				<img src='./images/YES?photoname=<%=photoLocation%>' height='400'
					width='400' class="btn btn-success"> Description:
				<%=p.getDecription()%>
				<p>
				<%=p.getName()%>
				Price
				<%=p.getPrice()%>
				BGN
				<form method='post' action='./MenuServlet'>
					<input class="btn btn-success btn-lg" type='submit'
						value='Add to Shopping Cart' name=<%=p.getId()%>></input>

				</form>
				</p>
				<hr>
				<%
					}
				%>

			</div>
		</div>

		<br /> <a href='./index.jsp'>Back to homepage</a> <br />
		<form method='get' action='./ShoppingCart'>
			<input class="btn btn-default" type='submit' value='GoToShoppingCart'>
		</form>
	</div>
</body>
</html>
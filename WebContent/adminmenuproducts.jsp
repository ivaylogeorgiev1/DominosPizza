<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>

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


	<div id="Foo" class="collapse">
		<table align="center" style="word-spacing:">
			<tr>
				<td><form action="./AddPizza" method="post"
						enctype="multipart/form-data">
						<br /> <input type="text" name="product"
							placeholder="Product name" /> <br /> <input type="text"
							name="price" placeholder="Product price" /> <br />
						<textarea rows="4" cols="50" name="desc" placeholder="Descrition"
							style="height: 200px" maxlength="400"></textarea>
						<br /> <input type="file" name="photo" placeholder="picture" />
						<br />
						<button>Add to Menu!</button>
					</form></td>

			</tr>
		</table>
	</div>


	<div align="center">
		<a href="#Foo" class="btn btn-default" data-toggle="collapse">Make
			changes </a>
	</div>
	
	<div class='container' >
		<div class="row">
			<%
				List<Product> products = UserDao.getInstance().getProducts();
				IProductDAO pDAO = ProductDAO.getInstance();
				//byte[] photoBytes = null;
				//File file = new File("./images/temp.jpg");
				//OutputStream output = new BufferedOutputStream(
				//		new FileOutputStream(file));
				for (Product p : products) {
					String photoLocation = "./images" + pDAO.getPhoto(p.getId());
					//output.write(photoBytes);
			%>

			<div class='col-lg-13 bg-success'>

				<img src='<%=photoLocation%>' height='400' width='400'>
				Description:
				<%=p.getDecription()%>
				<p>
					<%=p.getName()%>
					Price
					<%=p.getPrice()%>
					BGN
				<form method='post' action='./MenuServlet'>
					<input class="btn btn-default" type='submit'
						value='Add to Shopping Cart' name=<%=p.getId()%>></input>
				</form>
				<form method='get' action='./DeletePizza'>
					<input class="btn btn-default" type='submit' value='Delete Pizza'
						name=<%=p.getId()%>></input>
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
			<button class="btn btn-default">Go to shopping cart</button>
		</form>
	</div>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>
<%@page import="dominos.OOP.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="basemenu.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
<style> .container {
    width: 900px;
  }</style>
</head>
<body>
	<%
		if (request.getSession(false) != null) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				String username = user.getUsername();
				String email = user.getEmail();
				String restaurant = user.getRestaurant();
				String address = user.getAddress();
				String name = user.getName();
	%>
	<div class="container" >
		<div class="row">
			<div class='col-lg-6 bg-success'>
				Username:
				<%=username%>
				</br> email: &nbsp;
				<%=email%>
				</br> restaurant: &nbsp;
				<%=restaurant%>

				</br> address: &nbsp;
				<%=address%>
				</br> Name: &nbsp;
				<%=name%>


			</div>
			<div id="Foo" class="collapse">
				<table align="center" style="word-spacing:">
					<tr>
						<td><form action="" method="post">
								<input type="password" name="password" placeholder="password" />
								<br /> <input type="text" name="first" placeholder="First name" />
								<br /> <input type="text" name="last" placeholder="address" />
								<br /> <input type="text" name="rest"
									placeholder="Restaurant for ordering" /><br /> <input
									type="text" name="phone" placeholder="phone number" /> <br />
								<button>Confirm</button>
							</form></td>

					</tr>
				</table>
			</div>

		</div>

	</div>


	<%
		}
		}

		else {
			response.sendRedirect("./login.html");
		}
	%>




	<div align="center">
		<a href="#Foo" class="btn btn-default" data-toggle="collapse">Make
			changes </a>
	</div>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>
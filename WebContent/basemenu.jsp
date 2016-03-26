<!DOCTYPE html>
<%@ page session="false"%>
<%@ page import="dominos.OOP.*"%>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<title>Liberteri Italiano Pizza</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">

<!--[if IE 6]>
		<link rel="stylesheet" type="text/css" href="css/ie6.css">
	<![endif]-->
</head>
<body>
	<%
		boolean isAdmin = false;
		if (request.getSession(false) != null) {
			String username = null;
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				username = user.getUsername();
				if (user.getType().equalsIgnoreCase("admin")) {
					isAdmin = true;
				}
	%>
	<div style="text-align: center;">
		<h3>
			Hello
			<%=username%></h3>
	</div>
	<%
		}
		}
		String pageToRedirect = null;
		String linkToPage = null;
		String loggedProfile = null;
		String menuLink = "./menuproducts.jsp";
		HttpSession sessionn = request.getSession(false);
		System.out.println("Sesion: " + sessionn);
		if (sessionn == null) {
			pageToRedirect = "Login";
			linkToPage = "./login.html";
			loggedProfile = "./login.html";
		} else {
			pageToRedirect = "Logout";
			linkToPage = "./LogoutServlet";
			if (isAdmin) {
				menuLink = "./adminmenuproducts.jsp";
				loggedProfile = "./profileadmin.jsp";
			} else {
				loggedProfile = "./profile.jsp";
			}

		}
	%>

	<div id="header">
		<div>
			<ul class="first">
				<li><a href=<%=linkToPage%>><%=pageToRedirect%> </a></li>
				<li><a href=<%=menuLink%>>Everyday Menu</a></li>
			</ul>
			<div>
				<a href="index.jsp"><img src="images/logo.jpg" alt="Logo"></a>
			</div>
			<ul>
				<li><a href="about.html">About</a></li>
				<li><a href=<%=loggedProfile%>>Profile</a></li>
			</ul>
		</div>
		<span></span>
	</div>
</body>
</html>
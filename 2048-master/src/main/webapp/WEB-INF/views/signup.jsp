<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="/public-resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/public-resources/css/site.css">
<link rel="stylesheet" href="/public-resources/css/login.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
<title>Register Spring2048</title>
</head>
<body>
	<div class="common-wrapper">
		<header class="border-down">
			<div class="container-fluid center">
				<a title="Spring2048" href="/"><img class="img-responsive" id="logo" alt="logo" src="/public-resources/image/logo.png"></img></a>
			</div>
		</header>
		<div class="container-fluid center">
			<form class="form-signin" action="/user/signup" method="post">
				<h3 class="form-signin-heading">Register!</h3>
				<input type="text" id="username" name="username" class="form-control" placeholder="Username" required="required" autofocus="autofocus"></input>
				<input type="password" id="password" name="password" class="form-control" placeholder="Password" required="required"></input>
				<button class="btn btn-success btn-block" type="submit" id="submit">Sign&nbsp;&nbsp;&nbsp;&nbsp;Up</button>
				<a href="/user/signin">Login directly</a>
				<c:if test="${error != null }">
				  <div class="alert alert-danger" id="errorMessage" role="alert">${error }</div>
				</c:if>
			</form>
		</div>
		<footer class="center">
			<section id="copyright">2015</section>
		</footer>
	</div>

	<script src="/public-resources/js/jquery.min.js"></script>
	<script src="/public-resources/js/bootstrap.min.js"></script>
</body>
</html>
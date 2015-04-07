<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Score Dashboard</title>

  <link href="/public-resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/public-resources/css/bootstrap-overwrite.css" rel="stylesheet" type="text/css">
  <link href="/public-resources/css/main.css" rel="stylesheet" type="text/css">
  <link href="/public-resources/css/game.css" rel="stylesheet" type="text/css">
  <link rel="shortcut icon" href="favicon.ico">
</head>
<body>
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <p class="navbar-text width100percent">
        <span class="pull-right">
          <a href="/play2048" class="navbar-link">Back to Play!</a>
        </span>
      </p>
    </div>
  </nav>
  <div class="container s-container">
    <p>
      <c:choose>
        <c:when test="${myScore != null }">
          Your Highest Score is <strong>${myScore.score }</strong><br>Happened on <strong>${myScore.date }</strong>.
        </c:when>
        <c:otherwise>
          You haven't played yet, try to <a href="/play2048">PLAY</a> right now!
        </c:otherwise>
      </c:choose>
    </p>
  
    <table class="table table-bordered table-hover">
      <tr class="success">
        <th>#</th>
        <th>Username</th>
        <th>Score</th>
        <th>Score Date</th>
      </tr>
      <c:if test="${scoreList != null}">
        <c:forEach items="${scoreList }" var="score" varStatus="scoreStatus">
          <tr>
            <td>${scoreStatus.index + 1 }</td>
		        <td>${score.username }</td>
		        <td>${score.score }</td>
		        <td>${score.date }</td>
		      </tr>
        </c:forEach>
      </c:if>
    </table>
  </div>
</body>
</html>
<%@ include file="services/jstl.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.time.LocalTime" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>EXEMPLE JERSY-AJAX-JPA</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css?sinc=<% out.println(LocalTime.now()); %>" />
</head>
<body>
<%@ include file="components/add.jsp" %>
<%@ include file="components/update.jsp" %>
<%@ include file="components/delete.jsp" %>
<%@ include file="components/table.jsp" %>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js?sinc=<% out.println(LocalTime.now()); %>"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String str = "Hello Everyone";
	String str1 = "Hi";
%>
<h1><%= str %> <%= str1 %> </h1>
<center>
	<%
		for(int i=1; i<= 6; i++) {
	%>
		<font size="<%= i %>">Hello World!</font><br />
	<%
		}
	%>
</center>

<%--
<?php
	$str = 'Hello Everyone';
	echo '<h1>' . str . '</h1>';
?>
--%>
 
</body>
</html>
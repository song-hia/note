<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/list.jsp"/>
<jsp:include page="/WEB-INF/views/${section}"/>
</body>
</html>
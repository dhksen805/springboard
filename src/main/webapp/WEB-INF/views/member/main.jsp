<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty sessionScope.id}">
	<c:redirect url="/member/login"/>
</c:if>
<h1>WebContent/member/main.jsp</h1>
${sessionScope.id }님 로그인 하셨습니다.
<input type="button" value="로그아웃" 
onclick='location.href="<c:url value='/member/logout'/>"'><br>
<a href="<c:url value='/member/info'/>">회원정보조회</a><br>
<a href="<c:url value='/member/update'/>">회원정보수정</a><br>
<a href="<c:url value='/member/delete'/>">회원정보삭제</a><br>

<c:if test="${!(empty sessionScope.id)}">
	<c:if test="${sessionScope.id  eq 'admin' }">
		<a href="<c:url value='/member/list'/>">회원목록</a><br>
	</c:if>
</c:if>

<%
// 임의로 admin을 관리자로 설정
// 세션값이 있으면
// 세션값이 "admin"같으면  회원목록이 보이게 설정
// if(id!=null){
// 	if(id.equals("admin")){
// 	}
// }
%>
</body>
</html>


















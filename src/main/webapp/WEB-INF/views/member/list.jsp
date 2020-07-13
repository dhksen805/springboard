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
<h1>WebContent/member/list.jsp</h1>
<%
// 세션값 가져오기 
String id=(String)session.getAttribute("id");
// 세션값이 없으면  loginForm.jsp 이동 
// 세션값이 "admin"이 아니면 
//  loginForm.jsp 이동 
if(id==null){
// 	loginForm.jsp 이동 
// 	response.sendRedirect("loginForm.jsp");
}else{
	//세션값이 있으면
	if(!id.equals("admin")){
// 		loginForm.jsp 이동 
// 		response.sendRedirect("loginForm.jsp");
	}
}

//MemberDAO 객체생성
// MemberDAO mdao=new MemberDAO();
// 배열 자바API  List 인터페이스 => 상속  ArrayList 클래스
//             여러개 기억장소에 모든형을 저장
//              처음 10개 기억장소 만들어지고 값 추가가 되어지면 10개씩 기억장소 추가
// List memberList =    getMemberList() 호출
// List memberList=mdao.getMemberList();
%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
<c:forEach var="mb" items="${mbList }">
	<tr><td>${mb.id }</td>
	  <td>${mb.pass }</td>
	  <td>${mb.name }</td>
	  <td>${mb.reg_date }</td></tr>
</c:forEach>
</table>
</body>
</html>








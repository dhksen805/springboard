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
<h1>WebContent/board/content.jsp</h1>
<table border="1">
<tr><td>글번호</td><td>${bb.num }</td><td>작성일</td><td>${bb.date }</td></tr>
<tr><td>글쓴이</td><td>${bb.name }</td><td>조회수</td><td>${bb.readcount }</td></tr>
<tr><td>제목</td><td colspan="3">${bb.subject }</td></tr>
<tr><td>파일</td><td colspan="3">
<a href="../upload/<%//=bb.getFile() %>"><%//=bb.getFile() %></a>
<img src="../upload/<%//=bb.getFile() %>" width="100" height="100">
<a href="file_down.jsp?file_name=<%//=bb.getFile() %>"><%//=bb.getFile() %></a></td></tr>
<tr><td>내용</td><td colspan="3">${bb.content }</td></tr>
<tr><td colspan="4">
<input  type="button" value="답글쓰기" onclick="location.href='<c:url value="/board/reWrite?num=${bb.num}&re_ref=${bb.re_ref}&re_lev=${bb.re_lev}&re_seq=${bb.re_seq}"/>'">
<input  type="button" value="글수정" onclick="location.href='<c:url value="/board/update?num=${bb.num}&pageNum=${pageNum }"/>'">
<input  type="button" value="글삭제" onclick="location.href='<c:url value="/board/delete?num=${bb.num}&pageNum=${pageNum }"/>'">
<input  type="button" value="글목록" onclick="location.href='<c:url value="/board/list?pageNum=${pageNum }"/>'"></td></tr>
</table>
</body>
</html>
















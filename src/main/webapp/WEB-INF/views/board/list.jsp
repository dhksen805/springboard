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
<h1>WebContent/board/list.jsp</h1>
<h3><a href="<c:url value='/board/write'/>">글쓰기</a></h3>
<h1>글목록 [ 전체글개수 : ${pb.count } ]</h1>
<table border="1">
<tr><td>글번호</td><td>글제목</td><td>작성자</td><td>조회수</td><td>작성일</td></tr>
<c:forEach var="bb" items="${boardList }">
	<tr><td>${bb.num }</td>
	<td>
	<c:if test="${bb.re_lev > 0}">
		<c:set var="wid" value="${bb.re_lev * 10 }"/>
		<img src="<c:url value='/resources/img/level.gif'/>" width="${wid }">
		<img src="<c:url value='/resources/img/re.gif'/>">
	</c:if>
<a href="<c:url value='/board/content?num=${bb.num}&pageNum=${pb.pageNum}'/>">${bb.subject }</a></td><td>${bb.name }</td>
	<td>${bb.readcount }</td><td>${bb.date }</td></tr>
</c:forEach>
</table>

<c:if test="${pb.startPage >  pb.pageBlock}">
<a href="<c:url value='/board/list?pageNum=${pb.startPage -  pb.pageBlock}'/>">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}" step="1">
	<a href="<c:url value='/board/list?pageNum=${i}'/>">${i }</a>
</c:forEach>
<c:if test="${pb.endPage < pb.pageCount}">
<a href="<c:url value='/board/list?pageNum=${pb.startPage +  pb.pageBlock}'/>">[다음]</a>
</c:if>

</body>
</html>













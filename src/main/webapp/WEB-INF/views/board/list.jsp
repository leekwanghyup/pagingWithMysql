<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/head.jspf" %>

<div id="board_wrap">
	<h2>게시물목록</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
	<c:choose>
	<c:when test="${!empty boardList}">
	<c:forEach items="${boardList }" var="b">
		<tr>
			<td class="bno">${b.bno}</td>
			<td class="subject">
				<a href="#">${b.subject}</a>
			</td>
			<td class="writer">${b.writer}</td>
		</tr>
	</c:forEach>
	</c:when>
	<c:otherwise>
		<tr>
			<td colspan="4">게시물이 존재하지 않습니다.</td>
		</tr>
	</c:otherwise>
	</c:choose>
	</table>
	<div class="pagination">
		<c:if test="${startPage != 1}">
			<a href="?curPage=${startPage-1}">이전페이지</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="${contextPath}/board/list?curPage=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${endPage ne pageCnt}">
			<a href="?curPage=${endPage+1}">다음페이지</a>		
		</c:if>
	</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jspf" %>
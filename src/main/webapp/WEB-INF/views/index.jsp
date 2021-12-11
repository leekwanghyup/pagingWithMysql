<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/head.jspf" %>

<h2>메인페이지</h2>

<a href="${contextPath}/board/list">게시물 보러가기</a> <br>
<a href="${contextPath}/board/get">게시물 조회페이지</a> <br>
<a href="${contextPath}/board/register">게시물 쓰기 페이지</a> <br>
<a href="${contextPath}/board/modify">게시물 수정 페이지</a> <br>

<%@ include file="/WEB-INF/views/layout/footer.jspf" %>
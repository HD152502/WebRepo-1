<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<ul class="navbar-nav mr-auto">
<li class="nav-item" onmouseover="menu_over(this);" onmouseout="menu_out(this);">
<a class="nav-link" href="${ contextPath }/session.do">메뉴1</a>
</li>
<li class="nav-item" onmouseover="menu_over(this);" onmouseout="menu_out(this);">
<a class="nav-link" href="${ contextPath }/list.do">메뉴2</a>
</li>
<li class="nav-item" onmouseover="menu_over(this);" onmouseout="menu_out(this);">
<a class="nav-link" href="event.html">메뉴3</a>
</li>
</ul>
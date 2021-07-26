<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
   <nav>
      <h1 onclick="location.href='/index'">Note</h1>
      <div>
          <button onclick="location.href='/writeForm'">글쓰기</button>
      </div>
   </nav>
   <form action="searchlist" method="post">
      <div id="search">
          <input type="text" name="search" placeholder="Search all notes">
      </div>
   </form>
   <div id="list" style="overflow: scroll;">
       <c:forEach var="list" items="${list}">
       <ul onclick="location.href='/read?id=${list.id}'">
           <li>
           <p overflow: hidden;text-overflow: ellipsis;>${list.memo}</p>
           </li>
           <li style="font-size: small;">${list.write_date}</li>
       </ul>
       </c:forEach>
   </div>
</aside>
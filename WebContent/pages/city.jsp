<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%> 
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>City management</title>
</head>
<body>
<h1>City Management Page</h1>
<h3>Add a new city<br></h3>
<form action="cityAddAction" method="post">
<pre>
City name:   <input name="newCity.name" /> 
Postal code: <input name="newCity.code" ><input type="submit" value="Add"/>
</pre>

</form>
<div id="a">
<h3>City List</h3>
  <table border=1 width=400>
  <tr align=center >
  <td>No</td>
   <td>City Name</td>
   <td>Post Code</td>
 	<td>Delete</td>
  </tr>
  <c:forEach items="${listCity}" var="u" varStatus="status">
   <tr align=center>
   <td><c:out value="${status.index+1}"/></td>
    <td><c:out value="${u.name}"/></td>
    <td><c:out value="${u.postalCode}"/></td>
    <td><a href="cityDeleteAction.action?idCityToDelete=${u.id}">[x]</a></td>
   </tr>
  </c:forEach>
 </table>
</div>
<h3>Selector</h3>
<s:form action="cityChoose" method="post">
<s:select name="cityDepart" list="listCity" listValue="name" listKey="id" headerKey="0" headerValue="City">

</s:select>
<s:submit value="submit" name="submit" />
 </s:form>
<a href="logout.action">logout sessionId = <%= session.getId() %></a>

</body>
</html>
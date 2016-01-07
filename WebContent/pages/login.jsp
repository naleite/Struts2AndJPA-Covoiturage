<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<s:text name="Please login:" />
   <s:form action="login" method="post">
  
   <s:textfield key="Username" name="user.username" />
   <s:fielderror fieldName="username" />
   <s:password key="Password" name="user.password" />
   <s:fielderror fieldName="password" />
   <s:submit key="submit" />
   </s:form>
  <a href="/pages/createUser.jsp">Create new User</a>
</body>
</html>
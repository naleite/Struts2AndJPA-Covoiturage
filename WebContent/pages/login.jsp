<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.errors {
	background-color:#FFCCCC;
	border:1px solid #CC0000;
	width:400px;
	margin-bottom:8px;
}
.errors li{ 
	list-style: none; 
}
</style>

<title>Login</title>
</head>
<body>

<s:text name="Please login:" />
   <s:form action="login" method="post">
  
   <s:textfield key="Username" name="user.username" />
   <s:password key="Password" name="user.password">
   </s:password>
   
   <s:submit value="Login" />
   
   </s:form>
  <div class="errors">
      <s:fielderror/>
   </div>
   
  <a href="createUser.jsp">Create new User</a>
</body>
</html>
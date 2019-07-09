<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <form action="<c:url value="/dang-nhap" />" method="post">
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="inputEmail" name="userName" placeholder="Username" required="required" autofocus="autofocus" class="form-control">
              <label for="inputEmail">Username</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="inputPassword" name="password" placeholder="Password" required="required" class="form-control">
              <label for="inputPassword">Password</label>
            </div>
          </div>
          <div class="form-group">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me">
                Remember Password
              </label>
            </div>
          </div>
          <!-- <button 
          <a class="btn btn-primary btn-block" >Login</a> >
          </button> -->
          
          <input type="submit" name="Login" class="btn btn-primary btn-block" value="submit">
          
          <input type="hidden" value="login" id="login" name="action">
          
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
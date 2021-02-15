<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.79.0">
    <title>Signin Template Â· Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


    

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="/user/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form action="/user/login/check" method="post">
    <img class="mb-4" src="../assets/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    <label for="inputEmail" class="visually-hidden">User ID ${mid}</label>
    <input type="text" name="mid" class="form-control" placeholder="User ID" required autofocus 
    value="${mid}">
    <label for="inputPassword" class="visually-hidden">Password</label>
    <input type="password" name="mpw" class="form-control" placeholder="Password" required>
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" name="remember" value="ok"> Remember me
      </label>
      <br></br> 
     <c:if test="${loginFail == 1}">
      <span style="color:red">로그인에 실패했습니다.</span>
     </c:if>
     <c:if test="${signupFail == 0}">
      <span style="color:green">회원가입에 성공했습니다.</span>
     </c:if>
    </div>
      
    <button class="w-100 btn btn-lg btn-primary" type="submit">Log in</button>

  </form>
    <form action="/user/member/signup" method="get">
    <div style="line-height:3">
      <button class="w-100 btn btn-lg btn-info large" type="submit">Sign Up</button>
        <p class="mt-5 mb-3 text-muted">&copy;TEAM KERORO 2021</p>
        </div>
    </form>
</main>


    
  </body>
</html>

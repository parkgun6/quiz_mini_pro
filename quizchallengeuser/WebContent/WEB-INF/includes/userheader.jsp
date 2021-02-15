<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.79.0">
    <title>Navbar Template · Bootstrap v5.0</title>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbars/">

    

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
    <link href="/user/navbar.css" rel="stylesheet">
  </head>
  <body>
    
<main>
  
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="/user/home/main">IT Study Challenge</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav me-auto mb-2 mb-sm-0">
          <li class="nav-item active">
            <a class="nav-link" aria-current="page" href="/user/home/main">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">My Page</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">통계</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/user/qnaboard/list">QnA</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/user/myhistory/list">나의 Challenge</a>
          </li>
 
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle " href="#" id="dropdown03" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown03">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
          

          
        </ul>
        <form>
          <input class="form-control" type="text" placeholder="Search" aria-label="Search">
        </form>
        
<form action = "/user/login/logout" method = 'post'>
  <div class="form-horizontal">
    <div class="col-sm-offset-2 col-sm-11">
      <button type="submit" class="btn btn-danger" "align-items-right">Log out</button>
    </div>
  </div>
</form>
      </div>
    </div>
  </nav>

 


 
 
  <div class="container-xl mb-4">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yyyyy
  Date: 2022/8/6
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        body{
            background-color: bisque;
        }

        .formClass{
            text-align: center;
            margin-top: 200px;
        }
        h2{
            text-align: center;
            margin-top: 200px;
        }
        div{
            color: red;
        }
    </style>
</head>
<body>
<h2>登录</h2>
<form action="/cookie-session2/loginServlet" method="post" class="formClass">
    account: <input type="text" name="account" value="${cookie.account.value}"><div>${username_err}</div><br>
    password:<input type="password" name="password" value="${cookie.password.value}"><br><br>
    <input type="checkbox" name="remember" value="1" id="remember">是否记住密码<br>
    <input type="submit" value="登录"><input type="reset" value="重置"><a href="/cookie-session2/register.jsp">没有账号？点击注册</a> <br>

</form>

</body>
</html>

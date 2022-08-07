<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yyyyy
  Date: 2022/8/6
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <style>
        *{
            padding: 0;
            margin:0;
            box-sizing: border-box;
        }
        body{
            background-color: bisque;
            text-align: center;
            margin-top: 200px;
        }
        body h2{
            text-align: center;
        }
        div{
            color: red;
        }
    </style>
</head>
<body>
<h2>注册</h2>
<form action="/cookie-session2/registerServlet" method="post" id="registerForm">
    account:<input type="text" name="account"><div>${register_err}</div><br>
    password:<input type="password" name="password_first"><br>
    check:<input type="password" name="password_second"><div>${password_err}</div><br><br>

    验证码：
    <input type="text" name="verifiedImage"><img src="/cookie-session2/imageServlet" id="checkImage"><a href="#" id="changeImage">看不清楚，换一张</a> <br>

        <input type="submit" value="注册"><br><br>

    <a href="/cookie-session2/login.jsp">点击登录</a> <h3 align="center">${success}</h3>
</form>
</body>
<script>
document.getElementById("changeImage").onclick = function () {
    document.getElementById("checkImage").src = "/cookie-session2/imageServlet?" + new Date().getMilliseconds();

    document.getElementById("checkImage").onclick=function (){
        document.getElementById("checkImage").src = "/cookie-session2/imageServlet?" + new Date().getMilliseconds();
    }
}

</script>

</html>

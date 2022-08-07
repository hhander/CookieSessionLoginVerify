<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yyyyy
  Date: 2022/8/6
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectAll</title>
</head>
<body>
<h1>${user.account} ："欢迎你"${test}</h1>
<input type="button" value="新增" id="addButton">
<hr>
<table border="1" cellspacing="0" width="800">
    <tr align="center">
        <th>品牌</th>
        <th>公司名</th>
        <th>排序</th>
        <th>描述</th>
        <th>状态</th>
        <th>菜单</th>
    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.orderd}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status==1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status==0}">
                <td>禁用</td>
            </c:if>
            <td><a href="#">修改</a> &emsp; <a href="#">删除</a> </td>
        </tr>
        <br>
    </c:forEach>

</table>
</body>
<script>
    var addButton = document.getElementById("addButton");
    addButton.onclick = function ()
    {
        location.href="";
    }
</script>
</html>

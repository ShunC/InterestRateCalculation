<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/3/11
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Interest</title>
    <style type="text/css">
        body{
            color : rgba(33, 157, 196, 0.8);
            font-size: 50px;;
            margin: 20px auto;;
        }

    </style>
</head>
    <foot size=5 color="Navy" align="center" >Success Interest!</foot></br>
    <table bgcolor="1" cellpadding="0" cellspacing="5" border="silver" align="center">
        <tr>
            <td>
                <foot size=5 color="Navy" align="center">本利和 ： </foot>
                <%=session.getAttribute("compound").toString()%>
            </td>
        </tr>

    </table>
</body>
</html>

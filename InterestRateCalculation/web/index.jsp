<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/3/11
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Compound Interest</title>
    <style type="text/css">
      body{
        color : rgba(33, 157, 196, 0.8);
        font-size : 50px;
        margin: 20px auto;;
      }
    </style>
    <script type="text/javascript">
      function check(form){
        if (document.forms.compoundInterest.principal.value == ""){
          alert("请输入本金 ！");
          document.forms.compoundInterest.principal.focus();
          return false;
        }
        if (document.forms.compoundInterest.interestRate.value == ""){
          alert("请输入利率 ！");
          document.forms.compoundInterest.interestRate.focus();
          return false;
        }
        if (document.forms.compoundInterest.year.value == ""){
          alert("请输入年份 ！");
          document.forms.compoundInterest.year.focus();
          return false;
        }
      }
    </script>
  </head>
  <body>
  <form action="<%=request.getContextPath()%>/InterestRateServlet" method="post" name="compoundInterest">
    <table bgcolor="1" cellpadding="0" cellspacing="5" border="silver" align="center">
      <tr>
        <td align="center" >本金 ： </td>
        <td><input type="text" name="principal"/></td>
      </tr>
      <tr>
        <td align="center">利率 ： </td>
        <td><input type="text" name="interestRate"/></td>
      </tr>
      <tr>
        <td align="center">年份 ： </td>
        <td><input type="text" name="year"/></td>
      </tr>
      <tr>
        <td>利息类型 ：</td>
        <td>
        <input type="radio" name="interest" value="compound"/>复利
        <input type="radio" name="interest" value="single"/>单利
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">计算类型 ：</td>
      </tr>
      <tr>
        <td colspan="2" align="center" >
          <a href="<%=request.getContextPath()%>/index.jsp" name="change" >利息和</a>
          <a href="<%=request.getContextPath()%>/Jsp/time.jsp" name="change" >时间</a>
          <a href="<%=request.getContextPath()%>/Jsp/principal.jsp" name="change" >本金</a>
          <a href="<%=request.getContextPath()%>/Jsp/interest.jsp" name="change" >利率</a>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" name="提交" onclick="return check(this);"/>
          <input type="reset" name="重置"/>
        </td>
      </tr>
    </table>
  </form>
  </body>
</html>

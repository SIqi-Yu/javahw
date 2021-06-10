<%--
  Created by IntelliJ IDEA.
  User: 15726
  Date: 2021/4/1
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.MyProject.Beer" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.jar.Attributes" %>

<html>
<head>
    <title>Beer Recommended JSP</title>
</head>
<body>
<%

    List<Beer> style=(List<Beer>) request.getAttribute("styles");
    out.print("Beer Selection Advice");
    for(Beer brand:style){
        out.println("<br/>try:"+brand);
    }

%>

</body>
</html>
<%-- 
    Document   : Welcome
    Created on : 10 Jun, 2017, 1:46:19 PM
    Author     : saichaithanyasaraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<style type="text/css">
.first{color:#990000;text-align:center;background:yellow;float:left}
</style>
</head>
<body>
<center><h1> hi...${user.firstName} ${user.lastName} !</h1></center>
<div class="first">


<body bgcolor="#E6F3FF">

<table width="100%" border="10">


<tr>
    <td width="200"><a href="Compose.jsp">ComposeMail </a></td>
</tr>
<tr>
    <td width="200"><a href="readmails.jsp" target='fbody'>Inbox </a></td>
</tr>
<tr>
<td width="200"><a href="sentitems.html" target="f4">SentItems</td>
</tr>
<tr>
<td width="200"><a href="contacts.html" target="f4">Contacts</td>
</tr>
<tr>
<td width="200"><a href="logout.html" target="f4">LogOut</td>
</tr>
</table>
</body>
</html>

</div>





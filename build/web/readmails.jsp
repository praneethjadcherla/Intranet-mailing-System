<%-- 
    Document   : readmails
    Created on : 10 Jun, 2017, 1:05:03 PM
    Author     : saichaithanyasaraf
--%>

<%@page import="com.intranet.service.MailDAOImpl"%>
<%@page import="com.intranet.model.Mail"%>
<%@page import="com.intranet.DAO.MailDAO"%>
<%@page import="com.intranet.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            User user=(User)session.getAttribute("user");
            MailDAO md=new MailDAOImpl();
            for(Mail m:md.read(user)){
         %>
         
         <table>
             <tr>
                 <td>
                     <%=m.getTo()%>
                 </td>
                 <td>
                     <%=m.getFrom()%>
                 </td>
                 <td>
                     <%=m.getSubject()%>
                 
                 </td>
             </tr>
         </table>
                     <%
            }
                     %>
    </body>
    
</html>

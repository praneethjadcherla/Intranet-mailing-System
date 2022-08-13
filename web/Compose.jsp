<%-- 
    Document   : Compose.jsp
    Created on : 10 Jun, 2017, 5:56:14 PM
    Author     : saichaithanyasaraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Compose </title>
<body>
    
    <form name="f" action="Mail">
<table>
    <tr>
       <td >From:                   
           <input type="text" name="from" value="${user.mailId}" size="102"></td>
					           </tr>
    <tr>
       <td >TO:                   
      <input type="text" name="to" size="102"></td>
					           </tr>
    <tr>				 
	<td >sub:			                     
                    <input type="text" name="subject" size="102"></td>
	</tr>
	<tr>
                <td ><font color="blue">Attaching a file:  <input name="file" type="file">Choose
                </font></td>
               	</tr>
                <tr>
               <td>message:</td>
                </tr>
               <tr>
               <td><textarea name="message" cols="102" rows="10"></textarea></td>
               </tr>
			   <tr>
               <td >



<tr>
<td><input type="submit" value="send" ></td> <br>  
</tr>
<tr>
<td><input type="submit" value="cancel" ></td>
</tr>
</table>
    </form>
</body>
</html>
<%-- 
    Document   : updateRecord2
    Created on : Nov 3, 2015, 8:54:49 PM
    Author     : John Phillips
--%>

<%@page import="model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Superuser Healthstar Careweb</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
    </head>
    <body>
        <h1><a href="home.html">Patient SuperCare Stars</a></h1>
        <h2>Update Userfolk Record</h2>
        <form action="update" method="get">
            <% User patient = (User) request.getAttribute("patient");%>
            Patient Id: <input type="text" name="userId" value="<%= patient.getUserId() %>" readonly>
            <br><br>
            Email: <input type="text" name="email" size="30" value="<%= patient.getEmail() %>" required>
            <br><br>
            Blood Sugar: <input type="number" name="bloodSugar" value="<%= patient.getBloodSugar() %>" required>
            <br><br>
            Date: <input type="text" name="date" size="30" value="<%= patient.getDate() %>" required>
            <br><br>            
            Event: <input type="text" name="event" size="30" value="<%= patient.getEvent()%>" required>
            <br><br>
            Health: <input type="text" name="health" size="30" value="<%= patient.getHealth()%>" required>
            <br><br>
            Notes: <input type="text" name="notes" size="30" value="<%= patient.getNotes()%>" required>
            <br><br>
            

            <input type="hidden" name="action" value="updateRecord2">

            <input type="submit" name="submit" value="Submit">
            <br><br>
        </form>
    </body>
</html>

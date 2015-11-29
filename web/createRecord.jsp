<%-- 
    Document   : createRecord
    Created on : Nov 3, 2015, 5:19:26 PM
    Author     : John Phillips
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Superfantastic Healthcare</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
        
        <link rel="stylesheet" href="code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"> </script>
    </head>
    <body>
        <h1><a href="home.html">Patient Superstar HealthWeb</a></h1>
        <h2>Create New Patient Record</h2>
        <form action="create" method="get">

            Email: <input type="text" name="email" size="30" placeholder="Enter email" required>
            <br><br>
            BloodSugar: <input type="number" name="bloodSugar" placeholder="Blood Sugar" required>
            <br><br>       
            Date: <input type="text" name="date" size="8" placeholder="format as yyyymmdd" required>
            <br><br>
            Event: <input type="text" name="event" size="30" placeholder="Inciting Incident" required>
            <br><br>
            Health: <input type="text" name="health" size="30" placeholder="Health Status" required>
            <br><br>
            Notes: <input type="text" name="notes" size="30" placeholder="Other Notes..." required>
            <br><br>
            

            <input type="hidden" name="action" value="createRecord">

            <input type="submit" name="submit" value="Submit">
            <br><br>
        </form>
    </body>
</html>


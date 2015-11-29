<%-- 
    Document   : createRecord
    Created on : Nov 3, 2015, 5:19:26 PM
    Author     : John Phillips
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>faceBase</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
        
        <link rel="stylesheet" href="code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"> </script>
    </head>
    <body>
        <h1><a href="home.html">FaceBase</a></h1>
        <h2>Create New Face Record</h2>
        <form action="create" method="get">

            Email: <input type="text" name="name" size="20" placeholder="Enter name" required>
            <br><br>
            <input type="hidden" name="rating" value="50">
            Date: <input type="text" name="eyebrowRow" size="5" placeholder="brow" required>
            <br><br>
            Event: <input type="text" name="eyeRow" size="5" placeholder="eyes" required>
            <br><br>
            Health: <input type="text" name="mouthRow" size="5" placeholder="mouth" required>
            <br><br>
            Notes: <input type="text" name="quote" size="60" placeholder="Quote or Blurb" required>
            <br><br>
            

            <input type="hidden" name="action" value="createRecord">

            <input type="submit" name="submit" value="Submit">
            <br><br>
        </form>
    </body>
</html>


<%-- 
    Document   : editnote
    Created on : Jan. 31, 2022, 6:22:29 p.m.
    Author     : Lucky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>Edit Note</h2>
        
        <label for="title">Title:</label>
            <input type="text" name="title" id="title">
            <label for="content">Content:</label>
            <textarea rows="5" cols="30" name="content"></textarea>
            
            <button type="submit">Save</button>
    </body>
</html>

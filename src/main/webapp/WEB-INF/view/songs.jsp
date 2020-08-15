<%-- 
    Document   : songs
    Created on : Aug 14, 2020, 9:11:41 AM
    Author     : ruben
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search for Songs</title>
    </head>
    <body>
        <h1>Search Spotify for Songs</h1>
        <form>
            Enter song title: <input type="text" name="songName" value="" />
            <br/>
            <input type="submit" value="Find Song" name="findSong" />
        </form>
        <a href='./index.jsp'>Home</a>
        <%Map<String, List<String>> result = (Map<String, List<String>>) request.getAttribute("songResults");
            if (result != null) {
                if (!result.isEmpty()) {%>
        <h2>Results</h2>
        <table>
            <tr>
                <th><b>Title</b></th>
                <th><b>Album</b></th>
                <th><b>Release Date</b></th>
            </tr>
            <%for (String track : result.keySet()) {%>

            <tr>
                <td><%=track%></td>
                <% for (String albumInfo:result.get(track)) {%>
                <td><%=albumInfo%></td>
                <%}%>
            </tr>
            <%}%>
        </table>
                    <%} else { %>
                    <b>No songs found.</b>
                <%}}%>

    </body>
</html>

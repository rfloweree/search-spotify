<%-- 
    Document   : artists
    Created on : Aug 14, 2020, 9:11:15 AM
    Author     : ruben
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

        <h1>Search Spotify for Artists</h1>
        <form>
            Enter Artist name: <input type="text" name="artistName" value="" />
            <br/>
            <input type="submit" value="Find Artist" name="findArtist" />
        </form>
        <a href='./index.jsp'>Home</a>
        <%Map<String, List<List<String>>> result = (Map<String, List<List<String>>>) request.getAttribute("artistResults");
            if (result != null) {
                if (!result.isEmpty()) {%>
        <h2>Results</h2>
        <%for (String artist : result.keySet()) {%>
        <b><%=artist%></b>
        <%if (result.get(artist).isEmpty()) {%>
        <p>
            <b>No albums found.</b>
        </p>
        <%} else {%>
        <table>
            <tr>
                <th><b>Album</b></th>
                <th><b>Release Date</b></th>
                <th><b>Artist</b></th>
            </tr>
            <%for (List<String> albums : result.get(artist)) {%>
            <tr>
                <%for (String albumInfo : albums) {%>
                <td><%=albumInfo%></td>
                <%}%>
            </tr>
            <%}%>
        </table>
        <%}
                        }
                    } else {%>
        <b>No artists found.</b>
        <%}
                        }%>

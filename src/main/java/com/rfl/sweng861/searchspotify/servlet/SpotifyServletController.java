package com.rfl.sweng861.searchspotify.servlet;

import com.rfl.sweng861.searchspotify.search.SearchService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet class for the Spotify Search App. This is the intermediary object
 * that will handle the RESTful requests.
 *
 * @author Ruben F. Loweree Jr.
 */
@WebServlet(name = "SpotifyServlet",
        loadOnStartup = 1,
        urlPatterns = {"/artists",
            "/songs"
        })
public class SpotifyServletController extends HttpServlet {
    private SearchService searchService = null;//Replace with the call to service instance.
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/artists")) {
            String artistName = request.getParameter("artistName");
            if (artistName != null) {
                Map<String, List<List<String>>> artists = searchService.searchByArtist(artistName);
                request.setAttribute("artistResults", artists);
            }
        } else if (userPath.equals("/songs")){
            String songName = request.getParameter("songName");
            if (songName != null) {
                Map<String, List<String>> tracks = searchService.searchByTrack(songName);
                request.setAttribute("songResults", tracks);
            }
        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //NOT USED Since nothing is being posted to the servers.
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for the Search Spotify.";
    }

}

package com.rfl.sweng861.searchspotify.search;

import java.util.List;
import java.util.Map;

/**
 * Search service to be called from a Servlet or controller to make requests to
 * servers for search information. This service provide the higher level calls
 * to make specific search queries.
 * 
 * @author Ruben F. Loweree Jr.
 */
public interface SearchService {
    /**
     * Search method for artist names. This will connect to the server and 
     * request data. It will return the results in a map to be displayed in any
     * UI.
     * @param search Artist name string. This is passed by the GET 
     * request.
     * @return Map of Strings to display the found artists, their albums, 
     * and the release date of of each album.
     */
    public Map<String, List<List<String>>> searchByArtist(String search);
    /**
     * Search method for song titles. This will connect to the server and 
     * request data. It will return the results in a map to be displayed in any
     * UI.
     * @param search Song title string. This is passed by the GET 
     * request.
     * @return 
     */
    public Map<String, List<String>> searchByTrack(String search);
}

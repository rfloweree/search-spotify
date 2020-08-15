package com.rfl.sweng861.searchspotify.search.spotify;

import com.rfl.sweng861.searchspotify.search.SearchService;
import java.util.List;
import java.util.Map;

/**
 * Search services for making search requests to the Spotify. This uses the
 * Spotify Web API wrapper to handle requests to the server. This also handles
 * refining the search results to return to the client side for display.
 *
 * @author Ruben F. Loweree Jr.
 */
public class SpotifyService implements SearchService {
    /**
     * Search method for artist names. This will connect to the server and
     * request data. It will return the results in a map to be displayed in any
     * UI.
     *
     * @param search Artist name string. This is passed by the GET request.
     * @return Map of Strings to display the found artists, their albums, and
     * the release date of of each album.
     */
    @Override
    public Map<String, List<List<String>>> searchByArtist(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Search method for song titles. This will connect to the server and 
     * request data. It will return the results in a map to be displayed in any
     * UI.
     * @param search Song title string. This is passed by the GET 
     * request.
     * @return 
     */
    @Override
    public Map<String, List<String>> searchByTrack(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

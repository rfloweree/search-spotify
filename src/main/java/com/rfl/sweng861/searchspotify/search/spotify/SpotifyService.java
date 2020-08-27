package com.rfl.sweng861.searchspotify.search.spotify;

import com.rfl.sweng861.searchspotify.search.SearchService;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hc.core5.http.ParseException;

/**
 * Search services for making search requests to the Spotify. This uses the
 * Spotify Web API wrapper to handle requests to the server. This also handles
 * refining the search results to return to the client side for display.
 *
 * @author Ruben F. Loweree Jr.
 */
public class SpotifyService implements SearchService {
    /**
     * Client Id for registered app.
     */
    private static final String CLIENT_ID = "enter app client id here";
    /**
     * Client secret key for registered app.
     */
    private static final String CLIENT_SECRET = "enter app client secret here";
    /**
     * Spotify api wrapper.
     */
    private static final SpotifyApi SPOTIFY_API = new SpotifyApi.Builder()
                .setClientId(CLIENT_ID)
                .setClientSecret(CLIENT_SECRET)
                .build();
    /**
     * Service singletion.
     */
    private static SpotifyService spotifyService;
    /**
     * Method retrieves the singleton of this service.
     * @return 
     */
    public static SpotifyService instance() {
        if (spotifyService == null) {
            spotifyService = new SpotifyService();
        } 
        return spotifyService;
    }
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
        authenticate();//Authenticate and set access token.
        Paging<Artist> artistPaging = null;
        Map<String, List<List<String>>> map = new HashMap<>();
        try {
            /* Use the Spotifty API to search for a given artist and return a 
             * Paging object that conatins all found artists. 
             */
            artistPaging = SPOTIFY_API.searchArtists(search)
                    .build()
                    .execute();
            System.out.println("Total: " + artistPaging.getTotal());
            /* Iterate through the list of artists so that another search can 
             * be done on the artists' albums. */            
            for (Artist artist : artistPaging.getItems()) {
                List<List<String>> albums = new ArrayList<>();
                /* This will find the albums for each artist. This object can be
                 * used to find album names and release dates. */
                Paging<AlbumSimplified> albumSimplifiedPaging = 
                        SPOTIFY_API.getArtistsAlbums(artist.getId())
                                .album_type("album")
                                .build()
                                .execute();
                for (AlbumSimplified album : albumSimplifiedPaging.getItems()) {                   
                    List<String> albumInfo = new ArrayList<>();
                    albumInfo.add(album.getName());
                    albumInfo.add(album.getReleaseDate());
                    albums.add(albumInfo);
                }
                /* Place list of albums into the map for each artist. */
                map.put(artist.getName(), albums);
            }
        } catch (IOException | SpotifyWebApiException | ParseException ex) {
            System.out.println("Error: " + ex.getMessage());
            Logger.getLogger(SpotifyService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return map;
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
        authenticate();//Authenticate and set access token.
        Paging<Track> trackPaging = null;
        Map<String, List<String>> tracks = new HashMap<>();
        try {
            /* Use the Spotifty API to search for a given song and return a 
             * Paging object that conatins all found song titles. 
             */
            trackPaging = SPOTIFY_API.searchTracks(search)
                    .build()
                    .execute();
            /* Iterate through the tracks to be mapped to the a list of album
             * details, album name, date of relase, artists. 
             */
            for (Track track : trackPaging.getItems()) {
                List<String> albumInfo = new ArrayList<>();
                albumInfo.add(track.getAlbum().getName());
                albumInfo.add(track.getAlbum().getReleaseDate());
                /* Iterate through the list of Artists. For simplicity, they 
                 * will be appended and separated by commas. 
                 */
                StringBuilder stringBuilder = new StringBuilder();
                for (ArtistSimplified artist : track.getAlbum().getArtists()) {
                    /* TODO this can be replaced with Groovy script. This will
                     * allow handling this data to be easier to share with the 
                     * front end display.
                     */
                  stringBuilder.append(artist.getName()).append(",");
                }
                albumInfo.add(stringBuilder.toString());
                tracks.put(track.getName(), albumInfo);
            }
        } catch (IOException | SpotifyWebApiException | ParseException ex) {
            System.out.println("Error: " + ex.getMessage());
            Logger.getLogger(SpotifyService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return tracks;
    }
    /**
     * Method to authenticate the client credentials to access spotify. This
     * communicates with the Spotify API to receive an access token. Once it
     * received, the token is set to give access to the client.
     *
     * Note: this is a convenience method since each call to the Spotify API
     * needs to have an access token.
     */
    private void authenticate() {
        try {
           ClientCredentials clientCredentials = SPOTIFY_API.clientCredentials()
                    .build()
                    .execute();
            SPOTIFY_API.setAccessToken(clientCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException | ParseException ex) {
            Logger.getLogger(SpotifyService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rfl.sweng861.searchspotify.search.spotify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ruben
 */
public class SpotifyServiceTest {
    
    public SpotifyServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchByArtist method, of class SpotifyService.
     */
    @Test
    public void testSearchByArtist() {
        System.out.println("searchByArtist");
        String search = "Queens of the Stone Age";
        Map<String, List<List<String>>> expResult = null;
        Map<String, List<List<String>>> result = SpotifyService.instance().searchByArtist(search);
        assertEquals(expResult, result);
        assertTrue(!result.isEmpty());
//        assertEquals(expResult, result);
    }
    /**
     * Test of searchBySrtist method, of class SpotifyService.
     * This tests the method returns an empty list if not results can be found.
     */
    @Test
    public void testSearchByArtistNotFound() {
        System.out.println("searchByArtist - Empty");
        String search = "aqvwyt5";//erroneous string.
        Map<String, List<List<String>>> result = SpotifyService.instance().searchByArtist(search);
        assertTrue(result.isEmpty());
    }
    /**
     * Test of searchByTrack method, of class SpotifyService.
     */
    @Test
    public void testSearchByTrack() {
                System.out.println("searchByTrack");
        String search = "Jolene";
        /*
        TODO this code can be replaced with Groovy script.
        */
        Map<String, List<String>> expResult = new HashMap<>();
        expResult.put("Jolene", new ArrayList<String>());
        expResult.get("Jolene").add("Finally Going Home");
        expResult.get("Jolene").add("2014-05-01");
        expResult.get("Jolene").add("The Petersens,");
        expResult.put("Jolene - Dumplin' Remix", new ArrayList<String>());
        expResult.get("Jolene - Dumplin' Remix").add("Dumplin' Original Motion Picture Soundtrack");
        expResult.get("Jolene - Dumplin' Remix").add("2018-11-30");
        expResult.get("Jolene - Dumplin' Remix").add("Dolly Parton,");
        expResult.put("Jolene (Glee Cast Version)", new ArrayList<String>());
        expResult.get("Jolene (Glee Cast Version)").add("Glee: The Music, The Complete Season Three");
        expResult.get("Jolene (Glee Cast Version)").add("2012-08-28");
        expResult.get("Jolene (Glee Cast Version)").add("Glee Cast,");
        expResult.put("Jolene (Live) [Pass the Jar - Zac Brown Band and Friends Live from the Fabulous Fox Theatre in Atlanta]", new ArrayList<String>());
        expResult.get("Jolene (Live) [Pass the Jar - Zac Brown Band and Friends Live from the Fabulous Fox Theatre in Atlanta]").add("Pass the Jar - Zac Brown Band and Friends from the Fabulous Fox Theatre in Atlanta (Live)");
        expResult.get("Jolene (Live) [Pass the Jar - Zac Brown Band and Friends Live from the Fabulous Fox Theatre in Atlanta]").add("2010-05-04");
        expResult.get("Jolene (Live) [Pass the Jar - Zac Brown Band and Friends Live from the Fabulous Fox Theatre in Atlanta]").add("Zac Brown Band,");
        expResult.put("Jolene - Live", new ArrayList<String>());
        expResult.get("Jolene - Live").add("Pine Hollow (Live)");
        expResult.get("Jolene - Live").add("2018-02-23");
        expResult.get("Jolene - Live").add("The Staves,");
        expResult.put("Jolene (feat. Dolly Parton)", new ArrayList<String>());
        expResult.get("Jolene (feat. Dolly Parton)").add("PTX Vol. IV - Classics");
        expResult.get("Jolene (feat. Dolly Parton)").add("2017-04-07");
        expResult.get("Jolene (feat. Dolly Parton)").add("Pentatonix,");
        expResult.put("Jolene - New String Version [from the Dumplin' Original Motion Picture Soundtrack]", new ArrayList<String>());
        expResult.get("Jolene - New String Version [from the Dumplin' Original Motion Picture Soundtrack]").add("Dumplin' Original Motion Picture Soundtrack");
        expResult.get("Jolene - New String Version [from the Dumplin' Original Motion Picture Soundtrack]").add("2018-11-30");
        expResult.get("Jolene - New String Version [from the Dumplin' Original Motion Picture Soundtrack]").add("Dolly Parton,");
        expResult.put("Jolene - Music From The Spotify Original Series \"Music Happens Here\"", new ArrayList<String>());
        expResult.get("Jolene - Music From The Spotify Original Series \"Music Happens Here\"").add("Jolene (Music From The Spotify Original Series \"Music Happens Here\")");
        expResult.get("Jolene - Music From The Spotify Original Series \"Music Happens Here\"").add("2017-12-05");
        expResult.get("Jolene - Music From The Spotify Original Series \"Music Happens Here\"").add("Maddie & Tae,");
        Map<String, List<String>> result = SpotifyService.instance().searchByTrack(search);
        assertTrue(!result.isEmpty());
        assertEquals(expResult, result);
    }
    /**
     * Test of searchByTrack method, of class SpotifyService.
     * This tests the method returns an empty list if not results can be found.
     */
    @Test
    public void testSearchByTrackNotFound() {
        System.out.println("searchByTrack - Empty");
        String search = "aqvwyt5";//erroneous string.
        Map<String, List<String>> result = SpotifyService.instance().searchByTrack(search);
        assertTrue(result.isEmpty());
    }    
}

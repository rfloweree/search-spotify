/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rfl.sweng861.searchspotify.search.spotify;

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
        String search = "";
        SpotifyService instance = new SpotifyService();
        Map<String, List<List<String>>> expResult = null;
        Map<String, List<List<String>>> result = instance.searchByArtist(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByTrack method, of class SpotifyService.
     */
    @Test
    public void testSearchByTrack() {
        System.out.println("searchByTrack");
        String search = "";
        SpotifyService instance = new SpotifyService();
        Map<String, List<String>> expResult = null;
        Map<String, List<String>> result = instance.searchByTrack(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

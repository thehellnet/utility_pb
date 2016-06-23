package org.thehellnet.utility.gaming.pb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sardylan on 22/06/16.
 */
public class HashTest {

    private String input;
    private String expected;
    private String actual;

    @Test
    public void testMd5() throws Exception {
        input = "hello";
        expected = "5d41402abc4b2a76b9719d911017c592";
        actual = Hash.md5(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGuid() throws Exception {
        input = "HEEXU3XAG6EZ7JPXFDFD";
        expected = "069ca5c3f5c175c9c47d6fb6e9bc5259";
        actual = Hash.guid(input, HashSeed.COD2);
        assertEquals(expected, actual);

        input = "hello";
        expected = "7055600532732a46b9c3c8d7d2f00bbb";
        actual = Hash.guid(input, HashSeed.COD2);
        assertEquals(expected, actual);
    }
}
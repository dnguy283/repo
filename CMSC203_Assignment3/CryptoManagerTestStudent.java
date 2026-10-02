/*
 Class: CMSC-203-23011
 Program: Assignment #3
 Instructor: Huseyin Aygun
 Summary of Description: (Create three methods to encrypt and decrypt text.) 
 Due Date: 10/12/2026 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Daniel Nguyen
 */
package BobsCircus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBoundsTrue() {
        assertTrue(CryptoManager.isStringInBounds("GOODBYE WORLD"));
    }

    @Test
    public void testIsStringInBoundsFalse() {
        assertFalse(CryptoManager.isStringInBounds("goodbye world"));
    }

    @Test
    public void testCaesarEncryptionDecryption() {
        String text = "GOODBYE";
        int key = 4;
        String encrypted = CryptoManager.caesarEncryption(text, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);
        assertEquals(text, decrypted);
    }

    @Test
    public void testVigenereEncryptionDecryption() {
        String text = "TESTING TESTING";
        String key = "KEY";
        String encrypted = CryptoManager.vigenereEncryption(text, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(text, decrypted);
    }

    @Test
    public void testPlayfairEncryptionDecryption_NoDuplicates() {
        String text = "JAVA HARD";
        String key = "CIPHER";

        assertEquals(text.toUpperCase(),
            CryptoManager.playfairDecryption(
                CryptoManager.playfairEncryption(text, key), key));
    }
}

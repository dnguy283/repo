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


/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by students
    	String plain = "";
    	
    	for (int i = 0; i < plainText.length(); i++)
    	{
    		char plainChar = plainText.charAt(i);
    		char keyChar = key.charAt(i % key.length());
    		
    		int shift = keyChar - LOWER_RANGE;
    		
    		char Encrypted = (char)(((plainChar + shift - LOWER_RANGE) % RANGE) + LOWER_RANGE);
    		plain += Encrypted;
    	}
    	return plain;

    

    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
    	String plain = "";
        for (int i = 0; i < encryptedText.length(); i++) 
        {
            char plainChar = encryptedText.charAt(i);
            char keyChar = key.charAt(i % key.length());
            int shift = keyChar - LOWER_RANGE;
            char Encrypted = (char)(((plainChar - shift - LOWER_RANGE + RANGE) % RANGE) + LOWER_RANGE);
            plain += Encrypted;
        }
        return plain;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
    	
         //to be implemented by students
    	String matrix = "";
        boolean[] tracking = new boolean[256];
        
        for (int i = 0; i < key.length(); i++)
        {
            char keyChar = key.charAt(i);
            if (!tracking[keyChar])
            {
                matrix += keyChar;
                tracking[keyChar] = true;
            }
        }
        
        for (int i = 0; i < ALPHABET64.length(); i++)
        {
            char alphaChar = ALPHABET64.charAt(i);
            if (!tracking[alphaChar])
            {
                matrix += alphaChar;
                tracking[alphaChar] = true;
            }
        }

        String plain = "";
        for (int i = 0; i < plainText.length(); i += 2)
        {
            char c1 = plainText.charAt(i);
            char c2 = 'X';
            if (i + 1 < plainText.length())
            {
                c2 = plainText.charAt(i + 1);
            }
            
            if (c1 == c2)
            {
                c2 = 'X';
                i--; 
            }
            
            int idx1 = matrix.indexOf(c1);
            int idx2 = matrix.indexOf(c2);
            int r1 = idx1 / 8;
            int col1 = idx1 % 8;
            int r2 = idx2 / 8;
            int col2 = idx2 % 8;
            
            if (r1 == r2)
            {
                col1 = (col1 + 1) % 8; 
                col2 = (col2 + 1) % 8;
            }
            else if (col1 == col2)
            {
                r1 = (r1 + 1) % 8; 
                r2 = (r2 + 1) % 8;
            }
            else
            {
                int temp = col1; 
                col1 = col2; 
                col2 = temp;
            }
            
            char Encrypted1 = matrix.charAt(r1 * 8 + col1);
            char Encrypted2 = matrix.charAt(r2 * 8 + col2);
            plain += Encrypted1;
            plain += Encrypted2;
        }
        return plain;
    }

    // Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
    	
    	
		 //to be implemented by students
        String matrix = "";
        boolean[] tracking = new boolean[256];
        for (int i = 0; i < key.length(); i++)
        {
            char keyChar = key.charAt(i);
            if (!tracking[keyChar])
            {
                matrix += keyChar;
                tracking[keyChar] = true;
            }
        }
        for (int i = 0; i < ALPHABET64.length(); i++)
        {
            char alphaChar = ALPHABET64.charAt(i);
            if (!tracking[alphaChar])
            {
                matrix += alphaChar;
                tracking[alphaChar] = true;
            }
        }
        String rawDecrypted = "";
        for (int i = 0; i < encryptedText.length(); i += 2)
        {
            char c1 = encryptedText.charAt(i);
            char c2 = encryptedText.charAt(i + 1);
            int idx1 = matrix.indexOf(c1);
            int idx2 = matrix.indexOf(c2);
            int r1 = idx1 / 8;
            int col1 = idx1 % 8;
            int r2 = idx2 / 8;
            int col2 = idx2 % 8;
            if (r1 == r2)
            {
                col1 = (col1 - 1 + 8) % 8; 
                col2 = (col2 - 1 + 8) % 8;
            }
            else if (col1 == col2)
            {
                r1 = (r1 - 1 + 8) % 8; 
                r2 = (r2 - 1 + 8) % 8;
            }
            else
            {
                int temp = col1; 
                col1 = col2; 
                col2 = temp;
            }
            rawDecrypted += matrix.charAt(r1 * 8 + col1);
            rawDecrypted += matrix.charAt(r2 * 8 + col2);
        }
        String plain = "";
        for (int i = 0; i < rawDecrypted.length(); i += 2)
        {
            char c1 = rawDecrypted.charAt(i);
            char c2 = rawDecrypted.charAt(i + 1);
            plain += c1;
            if (i + 2 == rawDecrypted.length() && c2 == 'X')
            {
            }
            else if (c2 == 'X' && i + 2 < rawDecrypted.length() && rawDecrypted.charAt(i + 2) == c1)
            {
            }
            else
            {
                plain += c2;
            }
        }
        return plain;
        }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
    	
    	String plain = "";
    	
    	for (int i = 0; i < plainText.length(); i++)
    	{
    		char plainChar = plainText.charAt(i);
    		//add to the plain character by however much prompted (%26 to handle wrap around)
    		char Encrypted = (char)(((plainChar + key - LOWER_RANGE)%RANGE) + LOWER_RANGE);
    		plain+=Encrypted;
    	}
    	return plain;
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
	//to be implemented by students
  	String plain = "";
    	
    	for (int i = 0; i < encryptedText.length(); i++)
    	{
    		char plainChar = encryptedText.charAt(i);
    		
    		int shift = key%RANGE;
    		char Encrypted = (char)(((plainChar - shift - LOWER_RANGE + RANGE)%RANGE) + LOWER_RANGE);
    		plain+=Encrypted;
    	}
    	return plain;
    }    

}

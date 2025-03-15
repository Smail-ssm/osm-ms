package com.osm.securityservice.util;


import java.security.SecureRandom;
import java.util.Base64;

public class TokenUtil {

    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a secure random token using SecureRandom.
     * @return the generated token as a Base64-encoded string.
     */
    public static String generateResetToken() {
        byte[] tokenBytes = new byte[24];  // 24 bytes will give us a 32-character Base64 string
        random.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes); // URL safe Base64
    }
}

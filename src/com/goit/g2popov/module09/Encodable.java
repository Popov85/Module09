package com.goit.g2popov.module09;

/**
 * Interface {@code Encodable} specifies a service for text coding
 * This service is able to code/decode a phrase using Caesar algorithm
 * @author  Andrii Popov
 */

public interface Encodable {
        char[] ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int MAX_INDEX = ALPHABET_LOWER.length;
        int MIN_SHIFT = 3;

        void cipher(boolean isToCipher);
}

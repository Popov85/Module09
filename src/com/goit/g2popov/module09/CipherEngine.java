package com.goit.g2popov.module09;

/**
 * Class {@code CipherEngine} realizes an interface for coding/decoding a text by means of Caesar algorithm
 * Class is able to cipher a phrase and decipher this phrase back
 * Limitations:
 * It works only with English alphabet
 * Shift range lies within [3-25]
 * @author  Andrii Popov
 */

public class CipherEngine implements Encodable {

        //A text snippet to be coded/decoded
        private String statement;
        // Shift range [3-26]
        private int shift;

        public CipherEngine(String statement, int shift) throws IllegalArgumentException {
                this.statement = statement;
                if (shift < MIN_SHIFT || shift > MAX_INDEX-1)
                        throw new IllegalArgumentException();
                this.shift = shift;
        }

        public void setStatement(String statement) {
                this.statement = statement;
        }

        public String getStatement() {
                return statement;
        }

        /**
         * Realizes the Caesar algorithm for coding and decoding
         * @param isToCipher - whether you will cipher or decipher, true for coding, false for decoding
         */
        public void cipher(boolean isToCipher) {
                StringBuilder output = new StringBuilder();
                int size = statement.length();
                String alphabet;
                String[] data;
                int position, actualPosition;
                for (int i = 0; i < size; i++){
                        char c = statement.charAt(i);
                        if (c == ' ') {
                                output.append(" ");
                        } else {
                                data = getData(c);
                                alphabet = data[0];
                                position = Integer.parseInt(data[1]) ;
                                actualPosition = getActualPosition(position, isToCipher);
                                output.append(getChar(actualPosition, alphabet, c));
                        }
                }
                this.statement = output.toString();
        }

        private int getActualPosition(int position, boolean decipher) {
                int newPosition;
                int actualPosition;
                if (decipher) {
                        newPosition = position + shift;
                        if (newPosition > MAX_INDEX-1) {
                                actualPosition = newPosition - MAX_INDEX;
                        } else {
                                actualPosition = newPosition;
                        }
                }
                else {
                        newPosition = position - shift;
                        if (newPosition < 0) {
                                actualPosition = MAX_INDEX+newPosition;
                        } else {
                                actualPosition = newPosition;
                        }
                }
                return actualPosition;
        }

        private String[] getData(char c) {
                int positionInLower = findPositionInLower(c);
                int positionInUpper = findPositionInUpper(c);
                String[] data = new String[2];
                data[0] = "Unknown alphabet";
                data[1] = String.valueOf(-1);
                if (positionInLower != -1) {
                        data[0] = "LOWER";
                        data[1] = String.valueOf(positionInLower);
                }
                if (positionInUpper != -1) {
                        data[0] = "UPPER";
                        data[1] = String.valueOf(positionInUpper);
                }
                return data;
        }

        private char getChar(int position, String alphabet, char c) {
                if (alphabet.equals("LOWER")) {
                        return ALPHABET_LOWER[position];
                }
                else if (alphabet.equals("UPPER")) {
                        return ALPHABET_UPPER[position];
                }
                else {
                        // Unknown alphabet
                        return c;
                }
        }

        private int findPositionInLower(Character c) {
                for (int i = 0; i < MAX_INDEX; i++){
                      if (ALPHABET_LOWER[i]==c) {
                              return i;
                      }
                }
                return -1;
        }

        private int findPositionInUpper(Character c) {
                for (int i = 0; i < MAX_INDEX; i++){
                        if (ALPHABET_UPPER[i]==c) {
                                return i;
                        }
                }
                return -1;
        }

        @Override
        public String toString() {
                return statement.toString();
        }
}

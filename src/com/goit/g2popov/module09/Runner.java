package com.goit.g2popov.module09;

/**
 * Created by Андрей on 25.06.2016.
 */
public class Runner {
        public static void main(String[] args) {

                String sentence = "The quick brown fox jumps over the lazy dog!";
                try {
                        CipherEngine engine = new CipherEngine(sentence,8);
                        System.out.println("Initial sentence is:\n" + sentence);
                        engine.cipher(true);
                        System.out.println("Coded sentence is:\n"+ engine.toString());
                        engine.cipher(false);
                        System.out.println("DeCoded sentence is:\n"+ engine.toString());
                } catch (IllegalArgumentException e) {
                        System.out.println("Failed to create an object. Shift is out of the range!");
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }
}

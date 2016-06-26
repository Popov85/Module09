package com.goit.g2popov.module09;

/**
 * Class {@code Runner} Module 09
 * Task. Encrypt/decrypt objects from module03 by means of Caesar algorithm
 **/
public class Runner {
        public static void main(String[] args) {
                Client client = new Client("Mr Jack","Simpson","Canada, Toronto, Portland ave., 15/96","jacky.simpson90@gmail.com");
                System.out.println("Encrypted personal info: ");
                System.out.println(client.toString());
                System.out.println("Decrypted personal info: ");
                System.out.println(client.decrypt());
        }
}

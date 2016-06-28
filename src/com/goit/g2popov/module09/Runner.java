package com.goit.g2popov.module09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class {@code Runner} Module 09
 * Task. Encrypt/decrypt objects from module03 by means of Caesar algorithm
 **/
public class Runner {
        public static void main(String[] args) {
                List<Client> clients = new ArrayList<Client>();
                try {
                        Client client = new Client("Mr Jack", "Simpson", "Canada, Toronto, Portland ave., 15/96", "jacky.simpson90@gmail.com");
                        clients.add(client);
                        System.out.println("Encrypted personal info: ");
                        System.out.println(client.toString());
                        System.out.println("Decrypted personal info: ");
                        System.out.println(client.decrypt());
                        Client client2 = new Client("Mrs Amanda", "Stivenson", "USA, New York, Embankment ave., 21/75", "amanda.stivensom95@gmail.com");
                        clients.add(client2);
                        System.out.println("Clents are: "+Arrays.toString(clients.toArray()));
                } catch (IllegalArgumentException e) {
                        System.out.println("Failed to create a CipherEngine object. Shift is out of the range!");
                }
        }
}

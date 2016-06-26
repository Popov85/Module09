package com.goit.g2popov.module09;

/**
 * Class {@code Client} keeps info about a buyer of the online shop
 * @author  Andrii Popov
 */

public class Client {

        private static CipherEngine encryptionEngine = new CipherEngine("",3);

        private String name;
        private String surname;
        private String address;
        private String email;

        public Client(String name, String surname, String address, String email) {
                encryptionEngine.setStatement(name);
                this.name = encryptionEngine.cipher(true);
                encryptionEngine.setStatement(surname);
                this.surname = encryptionEngine.cipher(true);
                encryptionEngine.setStatement(address);
                this.address = encryptionEngine.cipher(true);
                encryptionEngine.setStatement(email);
                this.email = encryptionEngine.cipher(true);
        }

        public String getName() {
                encryptionEngine.setStatement(this.name);
                return encryptionEngine.cipher(false);
        }


        public String getSurname() {
                encryptionEngine.setStatement(this.surname);
                return encryptionEngine.cipher(false);
        }

        public String getAddress() {
                encryptionEngine.setStatement(this.address);
                return encryptionEngine.cipher(false);
        }

        public String getEmail() {
                encryptionEngine.setStatement(this.email);
                return encryptionEngine.cipher(false);
        }

        @Override
        public String toString() {
                return "Name: ["+this.name+"] " + "Surname: ["+this.surname+"] "
                                + "Address: [" + this.address + "] " + "E-mail: [" + this.email+"]";
        }

        public String decrypt() {
                return "Name: ["+this.getName()+"] " + "Surname: ["+this.getSurname()+"] "
                                + "Address: [" + this.getAddress() + "] " + "E-mail: [" + this.getEmail()+"]";
        }
}

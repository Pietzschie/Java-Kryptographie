package Aufgabe3;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Aufg3Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Aufg3 test = new Aufg3();

        //key erzeugung
        test.generateKeyPair(2000);
        System.out.println("Public Key:\n");
        System.out.println(test.getPublicKey() + '\n');
        System.out.println("Private Key:\n");
        System.out.println(test.getPrivateKey() + '\n');

        //verschluesselung
        Base64.Encoder encoder = Base64.getEncoder();
        String plainText = "test test";
        byte[] cipherText = test.encrypt(plainText);
        System.out.println("Verschluesselung von " + "'" + plainText + "'" + ":\n");
        System.out.println(encoder.encodeToString(cipherText) + '\n');

        //entschluesseln
        System.out.println("Entschluesselung vom obigen Chiffrat:\n");
        System.out.println(test.decrypt(cipherText));
    }
}

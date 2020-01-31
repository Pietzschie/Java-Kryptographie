package Aufgabe3;

import java.util.Base64;

public class Aufg3Test {
  public static void main(String[] args) throws Exception {
	Aufg3 test = new Aufg3();
	
	//key erzeugung
	test.generateKeyPair(2000);
	System.out.println("Public Key:");
	System.out.println("\u001B[32m" + test.getPublicKey() + "\u001B[0m" + '\n');
	System.out.println("Private Key:");
	System.out.println("\u001B[32m" + test.getPrivateKey() + "\u001B[0m" + '\n');
	
	//verschluesselung
	Base64.Encoder encoder = Base64.getEncoder();
	String plainText = "Test Text zum testen";
	byte[] cipherText = test.encrypt(plainText);
	System.out.println("Verschluesselung von " + "'" + plainText + "'" + ":");
	System.out.println("\u001B[32m" + encoder.encodeToString(cipherText) + "\u001B[0m" + '\n');
	
	//entschluesseln
	System.out.println("Entschluesselung vom obigen Chiffrat:");
	System.out.println("\u001B[32m" + test.decrypt(cipherText) + "\u001B[0m");
  }
}

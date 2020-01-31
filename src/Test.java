import Aufgabe1.*;
import Aufgabe2.*;
import Aufgabe3.*;
import Aufgabe4.*;

import java.util.Base64;

public class Test {
  public static void main(String[] args) throws Exception {
	String pText = "Sipro macht Spass";
	String key = "Mega krass sicherer guter Key!!!";
	System.out.println("Aufgabe1: Kryptographische Hashfunktion");
	Hashfunction hashFunc = new Hashfunction();
	String hash = hashFunc.createHash(pText, 0);
	System.out.println(String.format("Plain Text: %s\nHash: %s", pText, hash));
	
	System.out.println("\n\nAufgabe 2: Symmetrische Verschlüsselung");
	AES256 aes = new AES256();
	String cText = aes.encrypt(pText, aes.stringToKey(key));
	String dText = aes.decrypt(cText, aes.stringToKey(key));
	System.out.println(String.format("Plain Text: %s\nCipher Text (key: %s): %s\nDecrypted Cipher Text(key: %s): %s", pText, key, cText, key, dText));
	
	System.out.println("\n\nAufgabe 3: Asymmetrische Verschlüsselung");
	Aufg3 rsa = new Aufg3();
	rsa.generateKeyPair(512);
	String pubK = rsa.getPublicKey();
	String privK = rsa.getPrivateKey();
	byte[] cByte = rsa.encrypt(pText);
	dText = rsa.decrypt(cByte);
	System.out.println(String.format("Private Key: %s\nPublic Key: %s", privK, pubK));
	System.out.println(String.format("Plain Text: %s\nCipher Text: %s\nDecrypted Cipher Text: %s", pText, Base64.getEncoder().encodeToString(cByte),  dText));
 
	System.out.println("\n\nAufgabe 4: Digitale Signatur");
	DigitalSignature digSig = new DigitalSignature();
	digSig.generateKeyPair();
	digSig.createSign(pText);
  }
}

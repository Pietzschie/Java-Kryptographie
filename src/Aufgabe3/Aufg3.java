package Aufgabe3;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class Aufg3 {
  private KeyPair rsaKeyPair;
  
  public void generateKeyPair(int keySize) throws Exception {
	KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	keyPairGen.initialize(keySize);
	this.rsaKeyPair = keyPairGen.generateKeyPair();
  }
  
  public String getPublicKey() {
	Base64.Encoder encoder = Base64.getEncoder();
	return encoder.encodeToString(this.rsaKeyPair.getPublic().getEncoded());
  }
  
  public String getPrivateKey() {
	Base64.Encoder encoder = Base64.getEncoder();
	return encoder.encodeToString(this.rsaKeyPair.getPrivate().getEncoded());
  }
  
  public byte[] encrypt(String plainText) throws Exception {
	PublicKey publicKey = this.rsaKeyPair.getPublic();
	Cipher rsa = Cipher.getInstance("RSA");
	rsa.init(Cipher.ENCRYPT_MODE, publicKey);
	return rsa.doFinal(plainText.getBytes());
  }
  
  public String decrypt(byte[] cipherText) throws Exception {
	PrivateKey privateKey = this.rsaKeyPair.getPrivate();
	Cipher rsa = Cipher.getInstance("RSA");
	rsa.init(Cipher.DECRYPT_MODE, privateKey);
	return new String(rsa.doFinal(cipherText));
  }
}

package Aufgabe2;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES256 {
  private static final String ALGORITHM = "AES";
  private static final String MODE = "AES/CBC/PKCS5Padding";
  
  public String encrypt(String plainText, SecretKey key) {
	SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), ALGORITHM);
	IvParameterSpec ivSpec = new IvParameterSpec(getInitVector());
	
	byte[] cipherText = new byte[0];
	try {
	  Cipher cipher = Cipher.getInstance(MODE);
	  cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
	  cipherText = cipher.doFinal(plainText.getBytes());
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
	  e.printStackTrace();
	}catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
	  System.err.println("Der übergebene Key ist nicht zulässig!");
	  e.printStackTrace();
	}
	
	return Base64.getEncoder().encodeToString(cipherText);
  }
  
  public String encrypt(String plainText) {
	return encrypt(plainText, genKey());
  }
  
  public String decrypt(String cipherText, SecretKey key) {
	SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), ALGORITHM);
	IvParameterSpec ivSpec = new IvParameterSpec(getInitVector());
	
	byte[] decrypted = new byte[0];
	try {
	  Cipher cipher = Cipher.getInstance(MODE);
	  cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
	  decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
	  e.printStackTrace();
	}catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
	  System.err.println("Der übergebene Key ist nicht zulässig!");
	  e.printStackTrace();
	}
	
	return new String(decrypted);
  }
  
  public SecretKey stringToKey(String keyString) {
	return new SecretKeySpec(keyString.getBytes(), ALGORITHM);
  }
  
  public static SecretKey genKey() {
	KeyGenerator keyGen = null;
	try {
	  keyGen = KeyGenerator.getInstance(ALGORITHM);
	  keyGen.init(256);
	}catch (NoSuchAlgorithmException e) {
	  e.printStackTrace();
	}
	
	return keyGen.generateKey();
  }
  
  private byte[] getInitVector() {
	//byte[] randomBytes = new byte[length];
	//new SecureRandom().nextBytes(randomBytes);
	byte[] randomBytes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	return randomBytes;
  }
}

package Aufgabe3;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class Aufg3 {
    private KeyPair rsaKeyPair;

    public void generateKeyPair(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(keySize);
        this.rsaKeyPair = keyPairGen.generateKeyPair();
    }

    public KeyPair getKeyPair() {
        return rsaKeyPair;
    }

    public String encrypt(String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        PublicKey publicKey = this.rsaKeyPair.getPublic();
        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = rsa.doFinal(plainText.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(cipherText);
    }

    public String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        PrivateKey privateKey = this.rsaKeyPair.getPrivate();
        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = rsa.doFinal(cipherText.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(plainText);

    }
}

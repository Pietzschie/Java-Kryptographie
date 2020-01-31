package Aufgabe4;

import java.security.*;
import java.util.Base64;

public class DigitalSignature {
    private int keysize = 2000; //2000 is the keysize
    private PrivateKey privateKey; //private key from KeyPair
    private PublicKey publicKey; // public key form KeyPair
    private KeyPair rsaKeyPair; //KeyPair
    private KeyPairGenerator keyPairGen; //Generator to generate Keypair

    //This Methode is used to genaerate a keypair, it throws some Exceptions
    //such as "NoSuchAlgorihmenException"
    //initilalize rsaKeyPAir, publickey, private Key
    public void generateKeyPair() throws Exception{
        keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(keysize);

        //createsKeyPair Public and Private Key
        rsaKeyPair = keyPairGen.generateKeyPair();
        privateKey = rsaKeyPair.getPrivate();
        publicKey = rsaKeyPair.getPublic();
    }

    public void createSign(String plainText) throws Exception{
        //creates a Signature with this privateKey
        Signature rsa = Signature.getInstance("SHA256withRSA");
        rsa.initSign(privateKey);

        //SignatureBytes
        rsa.update(plainText.getBytes());
        byte[] signature = rsa.sign();
        Base64.Encoder encoder = Base64.getEncoder();
        String digest = encoder.encodeToString(signature);

        /*This Part is for Verifying our Signature
        We create a new Signature and initialize it with our public key
        then we are "updating" our MessageByteArray into the Signature Object
        */
        Signature pubSic = Signature.getInstance("SHA256withRSA");
        pubSic.initVerify(publicKey);
        pubSic.update(plainText.getBytes());

        //printing the result
        System.out.println("Signature: " + digest);
        System.out.print("Is this Signature verfied: ");
        if(pubSic.verify(signature)) System.out.println("Yes");
        else System.out.println("No");
    }


}

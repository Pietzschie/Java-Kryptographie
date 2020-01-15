package Aufgabe1;

import java.security.MessageDigest;

public class Hashfunction {
    String plaintext;
    String hashtext = "";

    public void createHash(String plaintext, int offset) throws Exception{
        this.plaintext = plaintext;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(plaintext.getBytes());
        hashtext = toHexString(md.digest(), offset);
    }

    public boolean verfiy(String hash){
        return hash.equals(hashtext);
    }

    public void dumpHash(){
        if (hashtext.equals("")) System.out.println("Die Nachricht wurde noch nicht verschlüsselt!!");
        else {
            System.out.println("Nachricht: " + plaintext);
            System.out.println("Verschlüsselt: " + hashtext);
            System.out.println("");
        }
    }

    private String toHexString(byte[] data, int offset){
        if(offset < 0) offset = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < data.length; i++){
            sb.append(String.format("%02X", data[i]));
            if((offset > 0) && (i+1<data.length) && ((i+1) % offset == 0)){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

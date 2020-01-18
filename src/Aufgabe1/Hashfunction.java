package Aufgabe1;

import java.security.MessageDigest;

public class Hashfunction {
    String plainText;
    String hashText = "";

    public String createHash(String plainText, int offset) throws Exception{
        this.plainText = plainText;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(plainText.getBytes());
        hashText = toHexString(md.digest(), offset);
        return hashText;
    }

    public boolean verfiy(String hash, String toHash){
        String h1 = hash.replaceAll("\\s+", "");
        String h2 = toHash.replaceAll("\\s+", "");
        return h1.equals(h2);
    }

    public void dumpHash(){
        if (hashText.equals("")) System.out.println("Die Nachricht wurde noch nicht verschlüsselt!!\n");
        else {
            System.out.println("Nachricht: " + plainText);
            System.out.println("Hash: " + hashText + "\n");
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

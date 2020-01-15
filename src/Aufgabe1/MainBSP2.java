package Aufgabe1;

import java.security.MessageDigest;

public class MainBSP2 {

    public static void main(String[] args) throws Exception{
        String m1 = "Kryptographie ";
        String m2 = "macht ";
        String m3 = "Spaß!!!!";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(m1.getBytes());
        md.update(m2.getBytes());
        md.update(m3.getBytes());
        byte[] digest = md.digest();

        System.out.println("Message: " + m1 + m2 + m3);
        System.out.println("Digest.: " + toHexString(digest, 2));
    }



    protected static String toHexString(byte[] data, int offset){
        if(offset < 0){
            offset=0;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<data.length; i++){
            sb.append(String.format("%02X", data[i]));
            if((offset > 0) && (i+1<data.length) && ((i+1) % offset == 0)){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}

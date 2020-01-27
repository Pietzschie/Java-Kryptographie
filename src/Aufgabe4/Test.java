package Aufgabe4;

public class Test {
    public static void main(String[] args) {
        DigitalSignature ds = new DigitalSignature();
        try{
            ds.generateKeyPair();
            ds.createSign("Auf entspannter Basis");
            //System.out.println(ds.verify(ds.createDigitalSignature(),ds.createDigitalSignature()));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

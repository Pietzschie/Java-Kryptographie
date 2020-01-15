package Aufgabe1;

public class Aufgabe1Code {

    public static void main(String[] args) throws Exception{
        Hashfunction hf = new Hashfunction();
        hf.createHash("Bruder muss los",2 );
        System.out.println(hf.verfiy("DFE1 63E5 511F D78C 6AC8 342C FB72 73DC 027E 9FDE FF28 067E 3776 29D3 2F45 79AB"));
        hf.dumpHash();
        hf.createHash("Jetzt is anders", 2);
        hf.dumpHash();

    }

}

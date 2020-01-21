package Aufgabe1;

import java.util.Scanner;

public class Aufgabe1Code {

    public static void main(String[] args) throws Exception{
       /* Hashfunction hf = new Hashfunction();
        System.out.println(hf.createHash("Bruder muss los",2 ));
        System.out.println(
                hf.verfiy("DFE1 63E5 511F D78C 6AC8 342C FB72 73DC 027E 9FDE FF28 067E 3776 29D3 2F45 79AB",
                        hf.createHash("Bruder muss los", 0)));
        hf.dumpHash();
        hf.createHash("Jetzt is anders", 2);
        hf.dumpHash();

        */
        Hashfunction hf = new Hashfunction();
        Scanner sc = new Scanner(System.in);

        int offset = 0;

        while(true){
            System.out.println("1-- Create Hash");
            System.out.println("2-- Verfiy Hash");
            System.out.println("3-- Exit Programm");
            System.out.print(">>> "); //Prompt;
            int i = sc.nextInt();
            sc.nextLine();

            switch(i){
                case 1: System.out.println("Message to Hash: ");
                        System.out.print(">>> ");
                        String hash = sc.next();
                        sc.nextLine();

                        System.out.println("Any Offset for the Hash String:");
                        printPrompt();
                        offset = sc.nextInt();
                        sc.nextLine();
                        System.out.println("");

                        hf.createHash(hash, offset);
                        hf.dumpHash();
                        break;
                case 2: System.out.println("Note: A hashstring with spaces in between is okay!!");
                        System.out.println("Hash to verfiy:");
                        printPrompt();
                        String hash1 = sc.nextLine();

                        System.out.println("Known Hash:");
                        printPrompt();
                        String hash2 = sc.nextLine();

                        if(hf.verfiy(hash1,hash2)) System.out.println("Hashes are the same :D");
                        else System.out.println("Hash is not verified!  :(");

                        System.out.println("");
                        break;
                case 3: sc.close();
                        System.exit(0);
                        break;
                default: System.out.println("Invalid Input");
            }
        }

    }

    public static void printPrompt(){
        System.out.print(">>>");
    }
}

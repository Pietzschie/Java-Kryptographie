package Aufgabe1;

import java.util.Scanner;

public class Aufgabe1Code {
  
  public static void main(String[] args) throws Exception {
	Hashfunction hf = new Hashfunction();
	Scanner sc = new Scanner(System.in);
	
	while (true) {
	  System.out.println("1-- Create Hash");
	  System.out.println("2-- Verfiy Hash");
	  System.out.println("3-- Exit Programm");
	  printPrompt();
	  
	  int i;
	  try {
		i = sc.nextInt();
		sc.nextLine();
	  }catch (Exception e) {
		i = -1;
	  }
	  
	  switch (i) {
		case 1:
		  System.out.println("Message to Hash: ");
		  System.out.print(">>> ");
		  String hash = sc.next();
		  sc.nextLine();
		  
		  System.out.println("Any Offset for the Hash String:");
		  printPrompt();
		  int offset = 0;
		  try {
			offset = sc.nextInt();
		  }catch (Exception e) {
			System.out.println("Invalid offset");
			System.out.println("Created Hash with default Offset (offset = 0)");
		  }
		  
		  sc.nextLine();
		  System.out.println();
		  
		  hf.createHash(hash, offset);
		  hf.dumpHash();
		  break;
		case 2:
		  System.out.println("Note: A hashstring with spaces in between is okay!!");
		  System.out.println("Hash to verfiy:");
		  printPrompt();
		  String hash1 = sc.nextLine();
		  
		  System.out.println("Known Hash:");
		  printPrompt();
		  String hash2 = sc.nextLine();
		  System.out.println();
		  
		  if (hf.verfiy(hash1, hash2)) System.out.println("Hashes are the same :D");
		  else System.out.println("Hash is not verified!  :(");
		  
		  System.out.println();
		  break;
		case 3:
		  sc.close();
		  System.exit(0);
		  break;
		default:
		  System.out.println("Invalid Input");
		  System.out.println();
	  }
	}
	
  }
  
  public static void printPrompt() {
	System.out.print(">>>");
  }
}

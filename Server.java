package randomnumberg;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;



public class server {

    

	public static void main(String[] args) {
    	ServerSocket ss;
    	Socket sokett;
    	int guesnum;
    	int hak=3;
        try {
        	System.out.println("client bekleniyor.");
        	ss = new ServerSocket(5506);
			  sokett = ss.accept();
			 
			
			   
			   Random randomnumber = new Random();	
			   int rnd = randomnumber.nextInt(10)+1;
			   System.out.println("Random sayi "+rnd);
			   
			   while(hak != 0 ) {

					  BufferedReader gelen = new BufferedReader(new InputStreamReader(sokett.getInputStream()));
					  guesnum = Integer.parseInt(gelen.readLine());
					   System.out.println("client tahmin "+guesnum);
				  
					  if( guesnum > rnd) {
						  hak--;
						  if(hak == 0){
							   
							  	PrintStream giden = new PrintStream(sokett.getOutputStream());
								
								System.out.println("Yanl��-Tahmin Edilmesi Beklenen sayi:"+rnd);
								giden.println("Yanl��-Tahmin Edilmesi Beklenen sayi:"+rnd);
						  }
							else {
						PrintStream giden = new PrintStream(sokett.getOutputStream());
						System.out.println("D���r");
						giden.println("D���r");
						}
						
					} else if( guesnum < rnd) {
						hak--;
						if(hak == 0){
							   
							PrintStream giden = new PrintStream(sokett.getOutputStream());
							
							System.out.println("Yanl��-Tahmin Edilmesi Beklenen sayi:"+rnd);
							giden.println("Yanl��-Tahmin Edilmesi Beklenen sayi:"+rnd);
						}
						else {
						PrintStream giden = new PrintStream(sokett.getOutputStream());
						System.out.println("Y�kselt");
						giden.println("Y�kselt");}
						
						
					} else{
						
						PrintStream giden = new PrintStream(sokett.getOutputStream());
						
						System.out.println("Do�ru");
						giden.println("Do�ru");
						hak=0;
						
						
					}
					
					 
					
				}
			   
			   
			   
			   
			   
			   
        	System.exit(0);
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

}
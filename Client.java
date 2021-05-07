package randomnumberg;


import java.io.*;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
    	String gelen = null;
    	int k = 3;
    	BufferedReader server ;
    
    	
    	try {                                                                   
    	Socket soket = new Socket("127.0.0.1",5506);             
    	
    	 PrintStream out = new PrintStream(soket.getOutputStream());
    	 System.out.print("Tahmin Bekleniyor\n");
    	 while(k!=0) {
    		 k--;
    	   BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));	
    	   int sayi =Integer.parseInt(in.readLine());
			 out.println(sayi);
			 
			 
				server = new BufferedReader(new InputStreamReader(soket.getInputStream()));
				gelen = server.readLine();
		    	   System.out.println(gelen); 
		    	if(gelen.equals("Doðru")) {
		    		break;
		    	}
		    	 
		    	   
    	 }
		    	   soket.close();
    	} catch (Exception e) {
    		
    	}
    }

}
package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class passenger {
  
    Scanner sc=new Scanner(System.in);
   

    String createNewPassenger(String usernamePassenger, String passwordPassenger, String emailPassword, String phonePassenger, String gengerPassenger) {

//        sc.close();
        
        Connector c=new Connector();
        c.addPassenger(usernamePassenger,passwordPassenger,emailPassword,phonePassenger,gengerPassenger);
        
        
        return usernamePassenger;
    }

    public void bookBus(String source, String dest, String busno, String passengerUsername) {
    	Connector c=new Connector();
    	ArrayList<String> id =new ArrayList<>();
        id.add(source);
        id.add(dest);
        id.add(passengerUsername);
        id.add(busno);
        Collections.shuffle(id);
        int freeSeats=c.checkSeatAvailability(busno);
        if(freeSeats>0) {
        	String bookingID=String.join("",id);
            c.addBooking(busno,source,dest,passengerUsername,bookingID);
            c.reduceSeatCount(busno,freeSeats-1);
        }
        else{
        	System.out.println("no seats available sorry");
        }
        

    } 

        
    

  

	public void viewBookingList(String p) {
		Connector c=new Connector();
		c.fetchPassengerBooking(p);
	}

	public void cancelBus(String cancel) {
		Connector c=new Connector();
		c.cancelPassengerBooking(cancel);
		
	}
	public void showlist(String source, String dest) {
		Connector c=new Connector();
        c.showListBus(source,dest);

		
	}


	public void sortDisplay(int sortPrice, String source, String dest) {
		Connector c=new Connector();
		if(sortPrice==1) {
     		c.sortedListPrice(sortPrice,source,dest);
     	}
     	else {
     		c.sortedListPrice(sortPrice,source,dest);
     	}
	}






	public void filterDisplay(int filterOption, String source, String dest) {
		Connector c=new Connector();
		c.filterBy(filterOption,source,dest);
	}

	public String verifyPassenger(String tempUserPassenger, String tempPasswordPassenger) {
		Connector c1=new Connector();
        String r=c1.verifyPassenger(tempUserPassenger, tempPasswordPassenger);
//         System.out.println(r);
         return(r);
		
	}
}

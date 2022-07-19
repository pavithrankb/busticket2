package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class passenger {
  
    Scanner sc=new Scanner(System.in);
   

   

    public void bookBus(String p) {
        boolean contin=true;
        while(contin){
        String dest,source;
        System.out.println("enter the source");
        source=sc.next();
        System.out.println("enter the dest");
        dest=sc.next();
        Connector c=new Connector();
        c.showListBus(source,dest);
        System.out.println("press 1 to access sorting and filtering menu or 2 to continue");
        int sort=sc.nextInt();
        if(sort==1) {
        	System.out.println("sort by");
        	System.out.println("		1)price low to high");
        	System.out.println("		2)price high to low");
        	int sortPrice=sc.nextInt();
        	if(sortPrice==1) {
        		c.sortedListPrice(sortPrice,source,dest);
        	}
        	else {
        		c.sortedListPrice(sortPrice,source,dest);
        	}
        	System.out.println("filter by (check all that apply)");
        	System.out.println("		1)all AC");
        	System.out.println("		2)all nonAC");
        	System.out.println("		3)all sleeper");
        	System.out.println("		4)all seater");
        	System.out.println("		5)AC seater");
        	System.out.println("		6)non AC seater");
        	System.out.println("		7)AC sleeper");
        	System.out.println("		8)non AC sleeper");
        	int filterOption=sc.nextInt();
        	c.filterBy(filterOption,source,dest);
        	
        	
   
        }
        System.out.println("enter the bus number which you want to book");
        String busno=sc.next();
        ArrayList<String> id =new ArrayList<>();
        id.add(source);
        id.add(dest);
        id.add(p);
        id.add(busno);
        Collections.shuffle(id);
        String bookingID=String.join("",id);
        c.addBooking(busno,source,dest,p,bookingID);  
        System.out.println("do you want to book another ticker y/n");
        String s=sc.next();
        if(s.equals("n")) {
        	contin=false;
        }

    } 
        }
    

  

	public void viewBookingList(String p) {
		Connector c=new Connector();
		c.fetchPassengerBooking(p);
	}

	public void cancelBus(String p) {
		System.out.println("Your booking");
		viewBookingList(p);
		System.out.println("enter the bus id to cancel the bus");
		String cancel=sc.next();
		Connector c=new Connector();
		c.cancelPassengerBooking(cancel);
		System.out.println("the new list of your booking from our software");
		viewBookingList(p);
		
	}
}

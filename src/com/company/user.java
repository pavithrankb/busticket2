package com.company;


import java.util.Scanner;



public class user {
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
		System.out.println("hola");
	}
	public String verifyManager(String tempUser, String tempPassword) {
        Connector c=new Connector();
        String r=c.verifyOwner(tempUser,tempPassword);
        System.out.println(r);
        return(r);

	}
	public String createNewManager(String username, String password, String email_id, String ph_no, String gen) {
        
        Connector c=new Connector();
        c.addOwner(username,password,email_id,ph_no,gen);
        
        
        return username;
		
	}


    
//    public void addBus(String s){
////    	System.out.println(s+"recievied this");
//  
//    	String busno,busname,source,dest;
//        int totalseats,freeseats,fare,AC,sleeper;
//        System.out.println("enter the bus number");
//        busno=sc.next();
//        System.out.println("enter the bus name");
//        busname=sc.next();
//        System.out.println("enter the total number of seats");
//        totalseats=sc.nextInt();
//        System.out.println("enter the total free seats");
//        freeseats=sc.nextInt();
//        System.out.println("enter the bus fare");
//        fare=sc.nextInt();
//        System.out.println("enter the bus source");
//        source=sc.next();
//        System.out.println("enter the bus dest");
//        dest=sc.next();
//        System.out.println("AC =1 non AC=0");
//        AC=sc.nextInt();
//        System.out.println("sleeper=1 seater=0");
//        sleeper=sc.nextInt();
//        Connector c=new Connector();
//        c.addBus(busno,busname,totalseats,freeseats,fare,source,dest,s,AC,sleeper);
//        
//
//    }

//    public void deleteBus(String s) {
//        System.out.println("enter the bus number to remove");
//        viewBusList(s);
//        System.out.println("enter the bus you want to delete");
//        String delbus= sc.next();
//        Connector c=new Connector();
//        c.delBus(delbus);
//        viewBusList(s);
//    }
//
//    public void viewBusList(String s) {
//        Connector c=new Connector();
//        c.busList(s);
//
//    }
//
//    public void viewPassengerList(String s) {
//    	System.out.println("here are your buses enter the desired bus number ");
//    	viewBusList(s);
//    	String passcheck=sc.next();
//    	Connector c=new Connector();
//    	c.showPassengerList(passcheck);
//    	
//    	
//
//
//    }
}

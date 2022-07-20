package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ui {

    private String verifyManager(String tempUser, String tempPassword) {
    	user u1=new user();
    	return (u1.verifyManager(tempUser,tempPassword));
 
    }
    private String createNewManager() {
        String username,password,email_id,ph_no,gen;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the username");
        username=sc.next();
        System.out.println("enter the password");
        password=sc.next();
        System.out.println("enter the email id");
        email_id=sc.next();
        System.out.println("enter the phone number");
        ph_no=sc.next();
        System.out.println("enter the gender");
        gen=sc.next();
//        sc.close();
        user u1=new user();
        return (u1.createNewManager(username,password,email_id,ph_no,gen));

    }


    public static void main(String[] args) {

            String username,password,s=null;

            int opt_page1,opt_page2;
            ui ui1=new ui();
       
            
        while(true){
        	
            System.out.println("page 1");
            System.out.println("choose 1) Manager  ");
            System.out.println("       2) Passenger");
            Scanner sc=new Scanner(System.in);
            opt_page1=sc.nextInt();
            if(opt_page1==1) {
                System.out.println("page 2");
                System.out.println("1)old user");
                System.out.println("2)new user");
                int opt1_page2 = sc.nextInt();
         
                
                if (opt1_page2 == 1) {
                	int var=1;
                	while(var==1) {
                    System.out.println("enter the username and password");
                    username = sc.next();
                    password = sc.next();
                    s = ui1.verifyManager(username, password);
//                    System.out.println(s+"inside main");
                    
                    if (!s.equals("error")) {
                        System.out.println("verified");
                        var=0;
                    } else {
                        System.out.println("not verified");

                    }
                }
                	}
                else
                {
                    s = ui1.createNewManager();
                }
                boolean cont = true;
                while (cont)
                    if (!s.equals(null)) {
                        System.out.println("page 3");
                        System.out.println("Manager menu");
                        System.out.println("choose 1)Add bus");
                        System.out.println("       2)Delete bus");
                        System.out.println("       3)View bus list");
                        System.out.println("       4)Passenger list");
                        System.out.println("       5) go to main menu");
                        opt_page2 = sc.nextInt();
                        bus b=new bus();
                        if (opt_page2==1) {
                        	String busno,busname,source,dest;
                            int totalseats,freeseats,fare,AC,sleeper;
                            System.out.println("enter the bus number");
                            busno=sc.next();
                            System.out.println("enter the bus name");
                            busname=sc.next();
                            System.out.println("enter the total number of seats");
                            totalseats=sc.nextInt();
                            System.out.println("enter the total free seats");
                            freeseats=sc.nextInt();
                            System.out.println("enter the bus fare");
                            fare=sc.nextInt();
                            System.out.println("enter the bus source");
                            source=sc.next();
                            System.out.println("enter the bus dest");
                            dest=sc.next();
                            System.out.println("AC =1 non AC=0");
                            AC=sc.nextInt();
                            System.out.println("sleeper=1 seater=0");
                            sleeper=sc.nextInt();
//                        	f.addBus(s);
                        	b.addBus(busno,busname,totalseats,freeseats,fare,source,dest,s,AC,sleeper);
                        	System.out.println("enter the stops from beginning to end");
                        	ArrayList<String> stops=new ArrayList<>();
                        	ArrayList<Integer> stopsCost=new ArrayList<>();
                        	ArrayList<String> stopsEnd=new ArrayList<>();
                        	ArrayList<Integer> freeSeats=new ArrayList<>();
                        	int numberStops= sc.nextInt();
                        	for(int i=0;i<numberStops;i++)
                        	{
                        		System.out.println("enter the stop start "+(i+1));
                        		String tempStop=sc.next();
                        		System.out.println("enter the stop end "+(i+1));
                        		String tempStopend=sc.next();
                				System.out.println("enter the cost for each stop");
                        		int cost=sc.nextInt();
                        		System.out.println("enter the freeseats for each stop");
                        		int free=sc.nextInt();
                        		stopsCost.add(cost);
                        		stops.add(tempStop);
                        		stopsEnd.add(tempStopend);
                        		freeSeats.add(free);
                        	}
                        	b.addStops(busno,numberStops,stops,stopsCost,stopsEnd,freeSeats);
                        	
                        }
                        else if(opt_page2==2) {
                        	System.out.println("enter the bus number to remove");
                	        b.viewBusList(s);
                	        System.out.println("enter the bus you want to delete");
                	        String delbus= sc.next();
                        	b.deleteBus(s,delbus);
                        }
                        else if(opt_page2==3) {
                        	b.viewBusList(s);
                        }
                        else if(opt_page2==4) {
                        	System.out.println("here are your buses enter the desired bus number ");
                	    	b.viewBusList(s);
                	    	String passcheck=sc.next();
                        	b.viewPassengerList(s,passcheck);
                        }
                        else {
                        	cont=false;
                        }

                       
                    }

            }
            else if(opt_page1==2){
                {
                    System.out.println("page 2");
                    System.out.println("1)old user");
                    System.out.println("2)new user");
                    int opt1_page2 = sc.nextInt();
                    String passengerUsername=null;
                    if (opt1_page2 == 1) {
                    	int var=1;
                    	while(var==1) {
                        System.out.println("enter the username and password");
                        username = sc.next();
                        password = sc.next();
                        passengerUsername = ui1.verifyPassenger(username, password);
                        if (!passengerUsername.equals("error")) {
                            System.out.println("verified");
                            var=0;
                        } else {
                        	
                            System.out.println("not verified");

                        }
                    }
                    	}
                    else
                    {
                        passengerUsername= ui1.createNewPassenger();

                    }
                    boolean cont = true;
                    while (cont)
                        if (!passengerUsername.equals("error")) {
                            System.out.println("page 3");
                            System.out.println("Passenger menu");
                            System.out.println("choose 1)Book bus");
                            System.out.println("       2)cancel booking");
                            System.out.println("       3)view my booking");
                            System.out.println("       4)go to main menu");
                            opt_page2 = sc.nextInt();
                            passenger p1=new passenger();
                            if (opt_page2 == 1) {
                            	
                            	
                            	
                            	
                            	
                            	 boolean contin=true;
                                 while(contin){
                                 String dest,source;
                                 System.out.println("enter the source");
                                 source=sc.next();
                                 System.out.println("enter the dest");
                                 dest=sc.next();
                                 passenger pass = new passenger();
                                 pass.showlist(source,dest);
                                 System.out.println("press 1 to access sorting and filtering menu or 2 to continue");
                                 int sort=sc.nextInt();
                                 if(sort==1) {
                                 	System.out.println("sort by");
                                 	System.out.println("		1)price low to high");
                                 	System.out.println("		2)price high to low");
                                 	int sortPrice=sc.nextInt();
                                 	pass.sortDisplay(sortPrice,source,dest);
                                 	
                                 	System.out.println("filter by enter which applies");
                                 	System.out.println("		1)all AC");
                                 	System.out.println("		2)all nonAC");
                                 	System.out.println("		3)all sleeper");
                                 	System.out.println("		4)all seater");
                                 	System.out.println("		5)AC seater");
                                 	System.out.println("		6)non AC seater");
                                 	System.out.println("		7)AC sleeper");
                                 	System.out.println("		8)non AC sleeper");
                                 	int filterOption=sc.nextInt();
                                 	pass.filterDisplay(filterOption,source,dest);
                                 	
                                 	
                                 }
                                 System.out.println("enter the bus number which you want to book");
                                 String busno=sc.next();
                                 pass.bookBus(source,dest,busno,passengerUsername);  
                                 System.out.println("do you want to book another ticker y/n");
                                 String wannaContinue=sc.next();
                                 if(wannaContinue.equals("n")) {
                                 	contin=false;
                                 }
                                 
                                 }
                            	 
                            } else if (opt_page2 == 2) {
                        		System.out.println("Your booking");
                        		p1.viewBookingList(passengerUsername);
                        		System.out.println("enter the bus id to cancel the bus");
                        		String cancel=sc.next();
                        		p1.cancelBus(cancel);
                        		System.out.println("the new list of your booking ");
                        		p1.viewBookingList(passengerUsername);

                            } else if (opt_page2 == 3) {
                                p1.viewBookingList(passengerUsername);
                            } else {
                                cont = false;
                            }
                        }
                }

            }

        }
        
        }

    private String createNewPassenger() {
        String usernamePassenger,passwordPassenger,emailPassword,phonePassenger,gengerPassenger;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the username");
        usernamePassenger=sc.next();
        System.out.println("enter the password");
        passwordPassenger=sc.next();
        System.out.println("enter the email id");
        emailPassword=sc.next();
        System.out.println("enter the phone number");
        phonePassenger=sc.next();
        System.out.println("enter the gender");
        gengerPassenger=sc.next();
        passenger pass=new passenger();
        String username=pass.createNewPassenger(usernamePassenger,passwordPassenger,emailPassword,phonePassenger,gengerPassenger);

        return username;
    }

    private String verifyPassenger(String tempUserPassenger, String tempPasswordPassenger) {
    	passenger p1=new passenger();
    	return (p1.verifyPassenger(tempUserPassenger, tempPasswordPassenger));
        
    }
}
package com.company;


import java.util.Scanner;

public class ui {

    private String verifyManager(String tempUser, String tempPassword) {
        
        Connector c=new Connector();
        String r=c.verifyOwner(tempUser,tempPassword);
        System.out.println(r);
        return(r);
        
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
        
        
        Connector c=new Connector();
        c.addOwner(username,password,email_id,ph_no,gen);
        
        
        return username;

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
                        user f=new user();
                        if (opt_page2==1) {
                        	f.addBus(s);
                        }
                        else if(opt_page2==2) {
                        	f.deleteBus(s);
                        }
                        else if(opt_page2==3) {
                        	f.viewBusList(s);
                        }
                        else if(opt_page2==4) {
                        	f.viewPassengerList(s);
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
                    String p=null;
                    if (opt1_page2 == 1) {
                    	int var=1;
                    	while(var==1) {
                        System.out.println("enter the username and password");
                        username = sc.next();
                        password = sc.next();
                        p = ui1.verifyPassenger(username, password);
                        if (!p.equals("error")) {
                            System.out.println("verified");
                            var=0;
                        } else {
                            System.out.println("not verified");

                        }
                    }
                    	}
                    else
                    {
                        p= ui1.createNewPassenger();

                    }
                    boolean cont = true;
                    while (cont)
                        if (!p.equals("error")) {
                            System.out.println("page 3");
                            System.out.println("Passenger menu");
                            System.out.println("choose 1)Book bus");
                            System.out.println("       2)cancel booking");
                            System.out.println("       3)view my booking");
                            System.out.println("       4)go to main menu");
                            opt_page2 = sc.nextInt();
                            passenger p1=new passenger();
                            if (opt_page2 == 1) {
                                p1.bookBus(p);
                            } else if (opt_page2 == 2) {
                                p1.cancelBus(p);
                            } else if (opt_page2 == 3) {
                                p1.viewBookingList(p);
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
//        sc.close();
        
        Connector c=new Connector();
        c.addPassenger(usernamePassenger,passwordPassenger,emailPassword,phonePassenger,gengerPassenger);
        
        
        return usernamePassenger;
    }

    private String verifyPassenger(String tempUserPassenger, String tempPasswordPassenger) {
    	 Connector c1=new Connector();
         String r=c1.verifyPassenger(tempUserPassenger, tempPasswordPassenger);
         System.out.println(r);
         return(r);
        
    }
}
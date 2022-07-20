package com.company;

import java.util.ArrayList;

public class bus {

	public void addBus(String busno, String busname, int totalseats, int freeseats, int fare, String source,
			String dest, String s, int ac, int sleeper) {
		Connector c=new Connector();
        c.addBus(busno,busname,totalseats,freeseats,fare,source,dest,s,ac,sleeper);
		
	}
	   public void deleteBus(String s, String delbus) {
	        Connector c=new Connector();
	        c.delBus(delbus);
	        viewBusList(s);
	    }
	    public void viewBusList(String s) {
	        Connector c=new Connector();
	        c.busList(s);

	    }

	    public void viewPassengerList(String s, String passcheck) {
	    	Connector c=new Connector();
	    	c.showPassengerList(passcheck);
	    	
	    	


	    }
		public void addStops(String busno, int numberStops, ArrayList<String> stops, ArrayList<Integer> stopsCost, ArrayList<String> stopsEnd, ArrayList<Integer> freeSeats) {
			Connector c=new Connector();
			c.addStops(busno,numberStops,stops,stopsCost,stopsEnd,freeSeats);
			
			
		}
 



}

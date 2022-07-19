package com.company;

import java.util.ArrayList;

public class bus {
    private String busNo;
    private String busName;
    private ArrayList<passenger> passengerArrayListforbus=new ArrayList<>();
    private int totalseats;
    private int seatsfree;
    private int fare;
    private String source;
    private String dest;

    public bus(String busNo, String busName, int totalseats, int seatsfree, int fare,String source,String dest) {
        this.busNo = busNo;
        this.busName = busName;
        this.totalseats = totalseats;
        this.seatsfree = seatsfree;
        this.fare = fare;
        this.source=source;
        this.dest=dest;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public ArrayList<passenger> getPassengerArrayListforbus() {
        return passengerArrayListforbus;
    }

    public void setPassengerArrayListforbus(ArrayList<passenger> passengerArrayListforbus) {
        this.passengerArrayListforbus = passengerArrayListforbus;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

    public int getSeatsfree() {
        return seatsfree;
    }

    public void setSeatsfree(int seatsfree) {
        this.seatsfree = seatsfree;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "bus{" +
                "busNo='" + busNo + '\'' +
                ", busName='" + busName + '\'' +
                ", passengerArrayList=" + passengerArrayListforbus +
                ", totalseats=" + totalseats +
                ", seatsfree=" + seatsfree +
                ", fare=" + fare +
                '}';
    }


}

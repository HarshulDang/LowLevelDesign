package com.practice.basicridesharingapplication;




public class Ride {
    enum RideStatus {IDLE, CREATED, WITHDRAWN, COMPLETED}

    static final int AMT_PER_KM = 20;
    int id;
    int origin, dest;
    int seats;
    RideStatus rideStatus;

    public Ride() {

        id = origin = dest = 0;
        rideStatus = RideStatus.IDLE;
    }

    public double calculateFare(boolean isPriorityRider) {

        int dist = dest - origin;
        if(seats < 2) {
            return dist * AMT_PER_KM * (isPriorityRider ? 0.75 : 1);
        }

        return dist * seats * AMT_PER_KM * (isPriorityRider ? 0.5 : 0.75);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

}

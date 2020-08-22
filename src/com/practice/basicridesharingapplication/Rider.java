package com.practice.basicridesharingapplication;
import java.util.*;

public class Rider extends Person {

    private List<Ride> allRides;
    private Ride currentRide;

    public Rider(String name) {
        this.name = name;

    }

    public void createRide(int id, int origin, int dest, int seats) {

        if(origin >= dest) {
            System.out.println("Wrong values of origin and destination. Can't create ride");
            return;
        }
        allRides = new LinkedList<>();
        currentRide = new Ride();

        currentRide.setId(id);
        currentRide.setOrigin(origin);
        currentRide.setDest(dest);
        currentRide.setSeats(seats);
        currentRide.setRideStatus(Ride.RideStatus.CREATED);
        allRides.add(currentRide);
    }

    public void updateRide(int id, int origin, int dest, int seats) {

        Iterator<Ride> itr = allRides.iterator();
        Ride r = null;
        while(itr.hasNext()) {
            r = itr.next();
            if(r.getId() == id) {
                break;
            }
        }

        if(r == null) {
            return;
        }

        if(r.getRideStatus() != Ride.RideStatus.CREATED) {
            return;
        }
        /*int i = 0;
        for (; i < allRides.size(); ++i) {
            if(allRides.get(i).getId() == id) {
                break;
            }
        }

        if(allRides.get(i).getRideStatus() != Ride.RideStatus.CREATED) {
            System.out.println("Ride wasn't in progress, Can't update ride");
            return;
        }*/

        /*allRides.get(i).setOrigin(origin);
        allRides.get(i).setDest(dest);
        allRides.get(i).setSeats(seats);*/
            r.setOrigin(origin);
            r.setDest(dest);
            r.setSeats(seats);



    }

    public void withdrawRide(int id) {

        Iterator<Ride> itr = allRides.iterator();
        Ride r = null;
        while(itr.hasNext()) {
            r = itr.next();
            if(r.getId() == id) {
                break;
            }
        }

        if(r == null) {
            return;
        }

        if(r.getRideStatus() != Ride.RideStatus.CREATED) {
            System.out.println("Ride wasn't in progress, Can't withdraw ride");
            return;
        }

        r.setRideStatus(Ride.RideStatus.WITHDRAWN);
        allRides.remove(r);
    }

    public double closeRide(int id) {

        Iterator<Ride> itr = allRides.iterator();
        Ride r = null;
        while(itr.hasNext()) {
            r = itr.next();
            if(r.getId() == id) {
                break;
            }
        }

        if(r == null) {
            return 0;
        }

        if(r.getRideStatus() != Ride.RideStatus.CREATED) {
            System.out.println("Ride wasn't in progress, Can't close ride");
            return 0;
        }

        r.setRideStatus(Ride.RideStatus.COMPLETED);
        return r.calculateFare(allRides.size() >= 10);
    }


}

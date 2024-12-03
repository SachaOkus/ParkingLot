package com.parkinglot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5, 5, 5);

        Vehicle motorcycle = new Motorcycle("MC-123");
        Vehicle car = new Car("CAR-456");
        Vehicle van = new Van("VAN-789");

        System.out.println(parkingLot.parkVehicle(motorcycle)); // True
        System.out.println(parkingLot.parkVehicle(car)); // True
        System.out.println(parkingLot.parkVehicle(van)); // True

        System.out.println("Remaining spots: " + parkingLot.getRemainingSpots());
        System.out.println("Is parking lot full? " + parkingLot.isFull());
        parkingLot.removeVehicle(car);
        System.out.println("Removed car. Remaining spots: " + parkingLot.getRemainingSpots());
        System.out.println("Van spots taken: " + parkingLot.getVanSpotsTaken());
    }
}
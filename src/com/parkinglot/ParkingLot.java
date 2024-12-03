package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int motorcycleSpots;
    private int carSpots;
    private int largeSpots;

    private int usedMotorcycleSpots = 0;
    private int usedCarSpots = 0;
    private int usedLargeSpots = 0;

    private List<Vehicle> parkedVehicles = new ArrayList<>();

    public ParkingLot(int motorcycleSpots, int carSpots, int largeSpots) {
        this.motorcycleSpots = motorcycleSpots;
        this.carSpots = carSpots;
        this.largeSpots = largeSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        switch (vehicle.getType()) {
            case MOTORCYCLE:
                if (usedMotorcycleSpots < motorcycleSpots) {
                    usedMotorcycleSpots++;
                    parkedVehicles.add(vehicle);
                    return true;
                } else if (usedCarSpots < carSpots) {
                    usedCarSpots++;
                    parkedVehicles.add(vehicle);
                    return true;
                } else if (usedLargeSpots < largeSpots) {
                    usedLargeSpots++;
                    parkedVehicles.add(vehicle);
                    return true;
                }
                break;
            case CAR:
                if (usedCarSpots < carSpots) {
                    usedCarSpots++;
                    parkedVehicles.add(vehicle);
                    return true;
                } else if (usedLargeSpots < largeSpots) {
                    usedLargeSpots++;
                    parkedVehicles.add(vehicle);
                    return true;
                }
                break;
            case VAN:
                if (usedLargeSpots + 2 < largeSpots) {
                    usedLargeSpots += 3;
                    parkedVehicles.add(vehicle);
                    return true;
                }
                break;
        }
        return false; // No available spots
    }
    public void removeVehicle(Vehicle vehicle) {
        if (parkedVehicles.remove(vehicle)) {
            switch (vehicle.getType()) {
                case MOTORCYCLE:
                    if (usedMotorcycleSpots > 0) usedMotorcycleSpots--;
                    else if (usedCarSpots > 0) usedCarSpots--;
                    else if (usedLargeSpots > 0) usedLargeSpots--;
                    break;
                case CAR:
                    if (usedCarSpots > 0) usedCarSpots--;
                    else if (usedLargeSpots > 0) usedLargeSpots--;
                    break;
                case VAN:
                    usedLargeSpots -= 3;
                    break;
            }
        }
    }
}


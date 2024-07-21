package org.parking.lot;

import org.parking.lot.vehicle.Vehicle;
import org.parking.lot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
    private final List<ParkingSpot> parkingSpots;
    private final int floor;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);
        Random random = new Random();
        for(int i = 0; i < numSpots; i++) {
            int vehicleTypeNum = random.nextInt(3);
            switch (vehicleTypeNum) {
                case 0:
                    parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
                    break;
                case 1:
                    parkingSpots.add(new ParkingSpot(i, VehicleType.MOTOR_CYCLE));
                    break;
                case 2:
                    parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
                    break;
            }
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle() == vehicle) {
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available" : ("Occupied by: " + spot.getParkedVehicle().getType())));
        }
    }
}

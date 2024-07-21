package org.parking.lot;

import org.parking.lot.vehicle.Vehicle;
import org.parking.lot.vehicle.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    // default motorcycle
    public ParkingSpot(int spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.vehicleType = type;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }
    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getType()  == vehicleType) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalStateException("Parking spot is not available or vehicle type mismatch");
        }
    }

    public synchronized void unParkVehicle() {
        parkedVehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}

package org.parking.lot;

import org.parking.lot.vehicle.Car;
import org.parking.lot.vehicle.MotorCycle;
import org.parking.lot.vehicle.Truck;
import org.parking.lot.vehicle.Vehicle;

public class ParkingLotDemo {
    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1,10));
        parkingLot.addLevel(new Level(2, 10));

        Vehicle car = new Car("TN122321");
        Vehicle motorCycle = new MotorCycle("TN231434");
        Vehicle truck = new Truck("TN343434");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorCycle);
        parkingLot.parkVehicle(truck);

        parkingLot.displayAvailability();

        parkingLot.unParkVehicle(car);

        parkingLot.displayAvailability();
    }
}

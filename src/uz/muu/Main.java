package uz.muu;

import uz.muu.exceptions.EmployeeAlreadyExist;
import uz.muu.exceptions.NoDriverAvailableForBooking;
import uz.muu.exceptions.NoSuchDriver;
import uz.muu.exceptions.NoSuchEmployee;

import java.util.Collection;

public class Main {


    public static void main(String[] args) {
        CarPooling cp = new CarPooling();
        cp.createDriver("Bobur Boburov");
        cp.createDriver("Anvar Anvarov");

        try {
            Driver driver = cp.getDriver("Anvar Anvarov");
            Driver driver2 = cp.getDriver("Anvar Boxodirov");
        } catch (NoSuchDriver e){
            System.err.println("Driver NOT found.");
        }
        Collection<Driver> driversList = cp.getDrivers();

        try {
            cp.addEmployee(123, "Doniyorov Doniyor", "CEO");
            cp.addEmployee(234, "Lazizov Laziz", "CTO");
            cp.addEmployee(234, "Rustamov Rustam", "Manager");
        } catch (EmployeeAlreadyExist e){
            System.err.println("Employee already exist");
        }

        try{
            Employee employee = cp.getEmployee(234);
            Employee employee2 = cp.getEmployee(235);
        } catch (NoSuchEmployee e){
            System.err.println("Employee not fount with that ID");
        }

        try {
            Driver availableDriver = cp.bookDriver(123, "14:00", 2);
            Driver availableDriver2 = cp.bookDriver(234, "14:30", 1);
            Driver availableDriver3 = cp.bookDriver(123, "15:00", 1);
            System.out.println("For checking");
        } catch (NoDriverAvailableForBooking e){
            System.err.println("No driver available for booking");
        }

        try {
            Driver availableDriver = cp.availableDriver("14:00", 1);
        } catch (NoDriverAvailableForBooking e){
            System.err.println("No driver available for booking");
        }

        Collection<TimeSlot> timeSlot = cp.getDriverTimetable("Anvar Anvarov");

        String employeeName = "Anvar Anvarov";
        System.out.println("User " + employeeName + "has booked: " + cp.getNumberOfBookingsByEmployee(employeeName) + " times.");

        cp.printAllBookings();



    }


}

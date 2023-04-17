package uz.muu;

import uz.muu.exceptions.EmployeeAlreadyExist;
import uz.muu.exceptions.NoDriverAvailableForBooking;
import uz.muu.exceptions.NoSuchDriver;
import uz.muu.exceptions.NoSuchEmployee;

import java.util.Collection;

public class CarPooling {
	
	public Driver createDriver(String name) {
		return null;
	}

	public Collection<Driver> getDrivers() {
		return null;
	}

	public Driver getDriver(String name) throws NoSuchDriver {
		return null;
	}

	public void addEmployee(int employeeID, String fullName, String position) throws EmployeeAlreadyExist {
	}

	public Employee getEmployee(int employeeId) throws NoSuchEmployee {
		return null;
	}

	public Driver bookDriver(int employeeID, String startingTime, int duration) throws NoDriverAvailableForBooking {

		return null;
	}

	public Driver availableDriver(String startingTime, int duration) throws NoDriverAvailableForBooking{
		return null;
	}

	public Collection<TimeSlot> getDriverTimetable(String driversName){
		return null;
	}

	public int getNumberOfBookingsByEmployee(String employeeName) {

		return -1;
	}

	public void printAllBookings() {
	}
}

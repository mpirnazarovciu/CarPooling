package uz.muu;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import uz.muu.exceptions.EmployeeAlreadyExist;
import uz.muu.exceptions.NoDriverAvailableForBooking;
import uz.muu.exceptions.NoSuchDriver;
import uz.muu.exceptions.NoSuchEmployee;

import java.util.*;

public class CarPooling {

	Map<Integer, Employee> employeeMap = new HashMap<>();
	List<Driver> driverList = new LinkedList<>();
	List<BookingInformation> biList = new LinkedList<>();
	
	public Driver createDriver(String name) {
		Driver newDriver = new Driver(name);
		driverList.add(newDriver);
		return newDriver;
	}

	public Collection<Driver> getDrivers() {
		return null;
	}

	public Driver getDriver(String name) throws NoSuchDriver {
		for (Driver d :
				driverList) {
			if (d.getName().equals(name)){
				return d;
			}
		}
		throw new NoSuchDriver();
	}

	public void addEmployee(int employeeID, String fullName, String position) throws EmployeeAlreadyExist {
		Employee employee = employeeMap.get(employeeID);
		if (employee == null){
			employeeMap.put(employeeID, new Employee(employeeID, fullName, position));
		} else
			throw new EmployeeAlreadyExist();
	}

	public Employee getEmployee(int employeeId) throws NoSuchEmployee {
		Employee employee = employeeMap.get(employeeId);
		if (employee==null){
			throw new NoSuchEmployee();
		}
		return employee;
	}

	public Driver bookDriver(int employeeID, String startingTime, int duration) throws NoDriverAvailableForBooking {
		Employee employee;
		try {
			employee = getEmployee(employeeID);
		} catch (Exception e){
			e.printStackTrace();
		}
		for (Driver driver :
				driverList) {
			Collection<TimeSlot> driversTimetable = getDriverTimetable(driver.getName());
			TimeSlot currentTimeSlot = timeSlotConverter(startingTime, duration);
			if(checkDriverByTimeSlot(driversTimetable, currentTimeSlot)){
				biList.add(new BookingInformation(employeeID, driver.getName(), startingTime, duration));
				return driver;
			}

		}


		throw new NoDriverAvailableForBooking();
	}

	private boolean checkDriverByTimeSlot(Collection<TimeSlot> driversTimetable, TimeSlot currentTimeSlot) {
		for (TimeSlot bookedTS :
				driversTimetable) {
			if (!checkTimeSlot(bookedTS, currentTimeSlot)){
				return false;
			}
		}
		return true;
	}

	private boolean checkTimeSlot(TimeSlot bookedTS, TimeSlot currentTimeSlot) {
		float hour = bookedTS.getHour();
		if (bookedTS.getMinute()==3){
			hour += 0.5;
		}

		float hourCurrent = currentTimeSlot.getHour();
		if (currentTimeSlot.getMinute() == 3){
			hour += 0.5;
		}

		for (double i = hourCurrent; i < hourCurrent + currentTimeSlot.getDuration(); i+=0.5) {
			for (double j = hour; j < hour + bookedTS.getDuration(); j+=0.5) {
				if (i == j){
					return false;
				}
			}

		}

		return true;
	}

	public Driver availableDriver(String startingTime, int duration) throws NoDriverAvailableForBooking{
		return null;
	}

	public Collection<TimeSlot> getDriverTimetable(String driversName){
		Collection<TimeSlot> timeSlotCollection = new LinkedList<>();
		for (BookingInformation bi:
			 biList) {
			if (bi.getDriverName().equals(driversName)){
				timeSlotCollection.add(bookingInformationToTimeSlot(bi));
			}
		}
		return timeSlotCollection;
	}

	public TimeSlot bookingInformationToTimeSlot(BookingInformation bi){
		return timeSlotConverter(bi.getBookTime(), bi.getDuration());
	}

	public TimeSlot timeSlotConverter(String bookTime, int duration){
		int hour = Integer.parseInt(bookTime.substring(0, 2));
		int minute = Integer.parseInt(bookTime.substring(3, 4));
		return new TimeSlot(hour, minute, duration);
	}

	public int getNumberOfBookingsByEmployee(String employeeName) {

		return -1;
	}

	public void printAllBookings() {
	}
}

package uz.muu;

public class BookingInformation {
    private int employeeID;
    private String driverName;
    private String bookTime;
    private int duration;

    public BookingInformation() {
    }

    public BookingInformation(int employeeID, String driverName, String bookTime, int duration) {
        this.employeeID = employeeID;
        this.driverName = driverName;
        this.bookTime = bookTime;
        this.duration = duration;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBookTime() {
        return bookTime;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

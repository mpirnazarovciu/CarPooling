package uz.muu;

public class Employee {
    private int employeeID;
    private String fullName, position;

    public Employee() {
    }

    public Employee(int employeeID, String fullName, String position) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.position = position;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

package uz.muu;

public class Driver {

	private String name;
	private String startTime = "9:00";
	private String endTime = "18:00";

	public Driver() {
	}

	public Driver(String name) {
		this.name = name;
	}

	public Driver(String name, String startTime, String endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Driver{" +
				"name='" + name + '\'' +
				", startTime='" + startTime + '\'' +
				", endTime='" + endTime + '\'' +
				'}';
	}
}

package uz.muu;

public class TimeSlot {
    private int hour, minute, duration;

    public TimeSlot(int hour, int minute, int duration) {
        this.hour = hour;
        this.minute = minute;
        this.duration = duration;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", duration=" + duration +
                '}';
    }
}

class Time {

    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        normalizeTime();
    }

    public Time sum(Time t1, Time t2) {  // here "Time" represents the return type of method sum which an object of type Time...
        int totalSeconds = (t1.hour * 3600 + t1.minute * 60 + t1.second) +
                           (t2.hour * 3600 + t2.minute * 60 + t2.second);

        int newHour = totalSeconds / 3600;
        totalSeconds %= 3600;
        int newMinute = totalSeconds / 60;
        int newSecond = totalSeconds % 60;

        return new Time(newHour, newMinute, newSecond);
    }

    // Normalize time to keep seconds and minutes within 60, and adjust hours
    private void normalizeTime() {
        if (second >= 60) {
            minute += second / 60;
            second %= 60;
        }
        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }
    }

    // Display the time
    public void displayTime() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }
}

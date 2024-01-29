
public class Time {
    private int hours;
    private int minutes;
    
    public Time(String militaryTime) {
        if (isValidMilitaryTime(militaryTime)) {
            String[] timeParts = militaryTime.split(":");
            this.hours = Integer.parseInt(timeParts[0]);
            this.minutes = Integer.parseInt(timeParts[1]);
        } else {
            throw new IllegalArgumentException("Invalid military time format");
        }
    }

    //validate military time format
    private boolean isValidMilitaryTime(String time) {
        if (time.length() != 5) {
            return false;
        }

        for (int i = 0; i < time.length(); i++) {
            if (i == 2) {
                if (time.charAt(i) != ':') {
                    return false;
                }
            } else {
                if (!Character.isDigit(time.charAt(i))) {
                    return false;
                }
            }
        }

        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));

        return (hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59);
    }

    //converts to conventional time format
    private String toConventionalTime() {
        int conventionalHrs = (hours % 12 == 0) ? 12 : hours % 12;
        String period = (hours < 12) ? "AM" : "PM";
        return String.format("%02d:%02d %s", conventionalHrs, minutes, period);
    }

    //override toString method
    @Override
    public String toString() {
        return toConventionalTime();
    }
}

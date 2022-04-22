package quanlydiemdanh;

import java.util.Calendar;

public class TimeCal {
    public static java.sql.Date addWeek(java.sql.Date currentDay, int Week) {
        int noOfDays = 7 * Week;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date(currentDay.getTime()));
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        return new java.sql.Date(calendar.getTime().getTime());
    }
}

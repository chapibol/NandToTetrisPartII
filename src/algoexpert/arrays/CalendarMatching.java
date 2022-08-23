package algoexpert.arrays;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CalendarMatching {

    public static void main (String [] args){
        StringMeeting dailyBounds1 = new StringMeeting("10:00", "18:30");
        LocalTime start = LocalTime.parse(dailyBounds1.start);
        LocalTime end = LocalTime.parse(dailyBounds1.end);

        List<StringMeeting> meetings = new ArrayList<>();
        meetings.add(new StringMeeting("1:00", "2:30"));

        for(StringMeeting meeting: meetings){
            System.out.println("LatePayments + " + meeting.latePayments);
        }

        System.out.println("1:50 in mins is: " + timeToMinutes("2:50"));

        System.out.println("500 mins to time: " + minutesToStrTime(1200));
    }

    public static String minutesToStrTime(int time){
        int hour = time / 60;
        int minutes = time % 60;
        String minuteStr = minutes < 10 ? "0" + minutes : minutes + "";
        return hour + ":" + minuteStr;
    }

    public static int timeToMinutes(String time){
        String [] splitTime = time.split(":");
        int hoursInMins = Integer.parseInt(splitTime[0]);
        return hoursInMins * 60 + Integer.parseInt(splitTime[1]);
    }

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        // Write your code here.
        System.out.println("Parsed Time: " + LocalTime.parse(dailyBounds1.start));
        System.out.println("Parsed Time: " + LocalTime.parse(dailyBounds1.end));
        return new ArrayList<>();
    }

    static class StringMeeting {
        public Integer latePayments;
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
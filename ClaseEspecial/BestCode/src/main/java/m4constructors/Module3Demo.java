package m4constructors;

import java.util.*;

public class Module3Demo {

    public static void main(String[] args) {

        // DIY
        Calendar calendarOne = new GregorianCalendar(new TimeZone() {
            @Override
            public int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds) {
                return 0;
            }

            @Override
            public void setRawOffset(int offsetMillis) {

            }

            @Override
            public int getRawOffset() {
                return 0;
            }

            @Override
            public boolean useDaylightTime() {
                return false;
            }

            @Override
            public boolean inDaylightTime(Date date) {
                return false;
            }
        }, new Locale("en", "", ""));



        // Using a static factory method
        Calendar calendarTwo = GregorianCalendar.getInstance();

        System.out.println(calendarOne.getTimeInMillis());
        System.out.println(calendarTwo.getTimeInMillis());
    }
}

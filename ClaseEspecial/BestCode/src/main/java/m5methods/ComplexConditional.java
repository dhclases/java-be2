package m5methods;

import java.time.LocalTime;

public class ComplexConditional {

    public static void main(String[] args){

        int hour = getHourOfDay();

        if(isDay(hour)){
            System.out.println("Day time logic");

        } else {
            System.out.println("Night time logic");
        }
    }

    private static boolean isDay(int hour){
        return hour > 6 && hour < 22;
    }

    private static int getHourOfDay() {
        return LocalTime.now().getHour();
    }
}

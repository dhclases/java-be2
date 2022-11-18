package m5methods;


import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.LocalDateTime.now;

public class MethodWithTooManyArguments {

    public static void main(String[] args) {

        // before
        int months = 0;
        int weeks = 0;
        int days = 4;

        long millisSinceEpoch = nowPlusTime(months, weeks, days);
        new Order().setExpirationDate(millisSinceEpoch);

        // after
        new Order().setExpirationDate(nowPlusDays(4));

    }

    private static long nowPlusTime(int months, int weeks, int days) {
        return LocalDateTime.now().plusMonths(months)
                .plusWeeks(weeks)
                .plusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    public static long nowPlusMonths(int months) {
        checkTimeIsValid(months);
        return toEpochMilli(now().plusMonths(months));
    }

    public static long nowPlusWeeks(int weeks) {
        checkTimeIsValid(weeks);
        return toEpochMilli(now().plusWeeks(weeks));
    }

    public static long nowPlusDays(int days) {
        checkTimeIsValid(days);
        return toEpochMilli(now().plusDays(days));
    }

    private static long toEpochMilli(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    private static void checkTimeIsValid(int timeUnit) {
        if (timeUnit <= 0) {
            throw new IllegalArgumentException("Time Unit can't be <= 0. Value passed in: " + timeUnit);
        }
    }
}

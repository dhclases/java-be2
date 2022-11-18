package m3naming.after;

import java.time.Instant;
import java.time.ZoneId;

public class TimeUtils {

    public static void printNowNewYorkTime() {
        String now = Instant.now().atZone(ZoneId.of("America/New_York")).toString();
        System.out.println(now);
    }
}

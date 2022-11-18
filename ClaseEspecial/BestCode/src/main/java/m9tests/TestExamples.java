package m9tests;

import org.junit.Test;
import java.time.ZoneId;

import static java.time.LocalDateTime.now;
import static org.junit.Assert.assertEquals;

public class TestExamples {

    // test that verifies too many things
    @Test
    public void basicMathTest() {

        assertEquals(2, 6 / 3);

        assertEquals(4, 2 * 2);
    }


    @Test
    public void divisionWorks() {
        assertEquals(2, 6 / 3);
    }

    @Test
    public void multiplicationWorks() {
        assertEquals(4, 2 * 2);
    }

    // test using the AAA template
    @Test
    public void testOrderExpirationData() {

        // Arrange
        long tomorrow = nowPlusDays(1);
        Order order = new Order();

        // Act
        order.setExpirationDate(tomorrow);

        // Assert
        assertEquals(order.getExpirationDate(), tomorrow);
    }

    private static long nowPlusDays(int days) {
        return now().plusDays(days).atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }
}

package my.colibear.study._03_tdd_archeture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setup() {
        this.customer = new Customer();
    }

    private void assertFeeAndPoints(double fee, int points) {
        assertEquals(fee, this.customer.getRentalFee());
        assertEquals(points, this.customer.getRentalPoint());
    }

    @Test
    public void RegularMovie_OneDay() throws Exception {
        this.customer.addRental("RegularMovie", 1);
        assertFeeAndPoints(150, 1);
    }

    @Test
    public void RegularMovie_SecondAndThirdDayFree() {
        this.customer.addRental("RegularMovie", 2);
        assertFeeAndPoints(150, 1);
        this.customer.addRental("RegularMovie", 3);
        assertFeeAndPoints(150, 1);
    }

    @Test
    public void RegularMovie_ForDays() {
        customer.addRental("RegularMovie", 4);
        assertFeeAndPoints(300, 2);
    }
}

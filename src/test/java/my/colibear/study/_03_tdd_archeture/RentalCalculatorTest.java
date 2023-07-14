package my.colibear.study._03_tdd_archeture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalCalculatorTest {

    private RentalCalculator rentalCalculator;

    private final String regularMovie = "RegularMovie";
    private final String childMovie = "ChildMovie";

    @BeforeEach
    public void loadRegistry() {
        VideoRegistry.addMovie(regularMovie, VideoRegistry.VideoType.REGULAR);
        VideoRegistry.addMovie(childMovie, VideoRegistry.VideoType.CHILDREN);
    }

    @BeforeEach
    public void setup() {
        this.rentalCalculator = new RentalCalculator();
    }

    private void assertFeeAndPoints(double fee, int points) {
        assertEquals(fee, this.rentalCalculator.getRentalFee());
        assertEquals(points, this.rentalCalculator.getRentalPoint());
    }

    @Test
    public void RegularMovie_OneDay() throws Exception {
        this.rentalCalculator.addRental(this.regularMovie, 1);
        assertFeeAndPoints(150, 1);
    }

    @Test
    public void RegularMovie_SecondsDayFree() {
        this.rentalCalculator.addRental(this.regularMovie, 2);
        assertFeeAndPoints(150, 1);
    }

    @Test
    public void RegularMovie_ThirdDayFree() {
        this.rentalCalculator.addRental(this.regularMovie, 3);
        assertFeeAndPoints(150, 1);
    }

    @Test
    public void RegularMovie_ForDays() {
        this.rentalCalculator.addRental(this.regularMovie, 4);
        assertFeeAndPoints(300, 2);
    }

    @Test
    public void ChildrenMovie_OneDay() {
        this.rentalCalculator.addRental(this.childMovie, 1);
        assertFeeAndPoints(100, 1);
    }

    @Test
    public void ChildrenMovie_forDays() throws Exception {
        // children movie 대여 1회당 1포인트
        this.rentalCalculator.addRental(this.childMovie, 4);
        assertFeeAndPoints(400, 1);
    }

    // 여러 편의 영화 테스트
    @Test
    public void OneRegularOneChildren_ForDays() throws Exception {
        rentalCalculator.addRental(this.regularMovie, 4);   // 3$, 2p
        rentalCalculator.addRental(this.childMovie, 4);     // 4$, 1p
        assertFeeAndPoints(700, 3);
    }

}

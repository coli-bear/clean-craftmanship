package my.colibear.study._03_tdd_archeture;

import java.util.ArrayList;
import java.util.List;

public class RentalCalculator {

    // 영화 여려편을 위해 변경하자.
//    private int days;
//    private String title;
    private final List<Rental> rentals = new ArrayList<>();

    public RentalCalculator() {
    }

    public void addRental(String title, int days) {
//        this.title = title;
//        this.days = days;
        this.rentals.add(new Rental(title, days));
    }

    public int getRentalFee() {
        return this.rentals.stream()
            .mapToInt(Rental::getFee)
            .sum();
    }



    public int getRentalPoint() {
        return this.rentals.stream()
            .mapToInt(Rental::getPoint)
            .sum();
    }
}

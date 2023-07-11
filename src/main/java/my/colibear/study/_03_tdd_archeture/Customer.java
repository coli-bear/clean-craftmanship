package my.colibear.study._03_tdd_archeture;

public class Customer {
    private int days;
    public void addRental(String title, int days) {
        this.days = days;
    }

    public int getRentalFee() {
        return this.applyGracePeriod(150, 3);
    }

    public int getRentalPoint() {
        return this.applyGracePeriod(1, 3);
    }

    private int applyGracePeriod(int amount, int grace) {
        if (this.days > grace) {
            return amount + amount * (this.days - grace);
        }
        return amount;
    }
}

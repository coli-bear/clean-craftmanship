package my.colibear.study._03_tdd_archeture;

public class RegularMovie extends AbstractMovie {
    protected RegularMovie(String title) {
        super(title);
    }

    @Override
    public int getFee(int days, Rental rental) {
        return AbstractMovie.applyGracePeriod(150, days, 3);
    }

    @Override
    public int getPoint(int days, Rental rental) {
        return AbstractMovie.applyGracePeriod(1, days, 3);
    }
}

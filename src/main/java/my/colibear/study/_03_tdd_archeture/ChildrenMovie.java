package my.colibear.study._03_tdd_archeture;

public class ChildrenMovie extends AbstractMovie {

    protected ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public int getFee(int days, Rental rental) {
        return days * 100;
    }

    @Override
    public int getPoint(int days, Rental rental) {
        return 1;
    }
}

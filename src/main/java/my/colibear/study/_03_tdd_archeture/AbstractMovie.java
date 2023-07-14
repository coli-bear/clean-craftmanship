package my.colibear.study._03_tdd_archeture;

public abstract class AbstractMovie implements Movie {
    private final String title;

    protected AbstractMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    protected static int applyGracePeriod(int amount, int days, int grace) {
        return days > grace ? amount + amount * (days - grace) : amount;
    }
}

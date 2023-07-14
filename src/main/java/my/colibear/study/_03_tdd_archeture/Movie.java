package my.colibear.study._03_tdd_archeture;

public interface Movie {
    String getTitle();
    int getFee(int days, Rental rental);
    int getPoint(int days, Rental rental);
}

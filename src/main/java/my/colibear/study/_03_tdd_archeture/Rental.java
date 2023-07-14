package my.colibear.study._03_tdd_archeture;

public class Rental {
    private int days;
//    private String title;
//    private VideoRegistry.VideoType videoType;
    private Movie movie;

    public Rental(String title, int days) {
        this.days = days;
//        this.title = title;
//        this.videoType = VideoRegistry.getType(title);
        this.movie = VideoRegistry.getMovie(title);
    }



//    public int getFee() {
//         드디어 다형성 도입
//        if (this.videoType.isRegular()) {
//            return this.applyGracePeriod( 150, 3);
//        } else {
//            return this.applyGracePeriod( 100, 1);
//        }
//    }

//    public int getPoint() {
//        if (this.videoType.isRegular()) {
//            return this.applyGracePeriod(1, 3);
//        } else {
//            return 1;
//        }
//    }

    public String getTitle() {
        return this.movie.getTitle();
    }

    public int getFee() {
        return this.movie.getFee(this.days, this);
    }

    public int getPoint() {
        return this.movie.getPoint(this.days, this);
    }

//    private int applyGracePeriod( int amount, int grace) {
//        if (this.days > grace) {
//            return amount + amount * (this.days - grace);
//        }
//        return amount;
//    }
}

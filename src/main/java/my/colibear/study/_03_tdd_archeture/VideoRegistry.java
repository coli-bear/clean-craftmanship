package my.colibear.study._03_tdd_archeture;

import java.util.HashMap;
import java.util.Map;

public class VideoRegistry {
    private static final Map<String, VideoType> movieRegistry = new HashMap<>();

    public static Movie getMovie(String title) {
        return switch (VideoRegistry.movieRegistry.get(title)) {
            case REGULAR -> new RegularMovie(title);
            case CHILDREN -> new ChildrenMovie(title);
        };
    }

    public enum VideoType {
        REGULAR, CHILDREN;
//        public boolean isRegular() {
//            return this == REGULAR;
//        }
    }

//    public static VideoType getType(String title) {
//        return VideoRegistry.movieRegistry.get(title);
//    }

    public static void addMovie(String title, VideoType videoType) {
        VideoRegistry.movieRegistry.put(title, videoType);
    }
}

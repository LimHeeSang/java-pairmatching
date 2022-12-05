package pairmatching.domain.model;

public enum Course {

    FRONTEND("프론트엔드"), BACKEND("백엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }
}

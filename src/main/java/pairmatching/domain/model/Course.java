package pairmatching.domain.model;

import java.util.Arrays;

public enum Course {

    FRONTEND("프론트엔드"), BACKEND("백엔드");

    private static final String ERROR_INVALID_COURSE_INPUT = "[ERROR] 백엔드, 프론트엔드 중 입력 가능합니다.";
    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_COURSE_INPUT));
    }

    private boolean isEqualName(String name) {
        return this.name.equals(name);
    }
}

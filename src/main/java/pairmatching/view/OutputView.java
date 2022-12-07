package pairmatching.view;

import pairmatching.domain.model.Course;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;

import java.util.List;

public class OutputView {

    private static final String COURSE_NAME = "과정: ";
    private static final String SEPARATOR = " | ";
    private static final int SEPARATOR_SIZE = 3;
    private static final String MISSION_NAME = "미션:\n";
    private static final String LEVEL_START_SUFFIX = "  - ";
    private static final String LEVEL_START_PREFIX = ": ";
    private static final String SEPARATOR_MARK_LINE = "#############################################";
    private static final int NEW_LINE_SIZE = 1;
    private static final String INIT_MESSAGE = "초기화 되었습니다.";

    private OutputView() {
    }

    public static void printCourseMissionLevel() {
        printSeparatorLine();
        System.out.println(createCourseInfo());
        System.out.println(createLevelInfo());
        printSeparatorLine();
    }

    private static void printSeparatorLine() {
        System.out.println(SEPARATOR_MARK_LINE);
    }

    private static String createCourseInfo() {
        Course[] values = Course.values();
        StringBuilder sb = new StringBuilder(COURSE_NAME);
        for (Course course : values) {
            sb.append(course.getName());
            sb.append(SEPARATOR);
        }
        sb.delete(sb.length() - SEPARATOR_SIZE, sb.length());
        return sb.toString();
    }

    private static String createLevelInfo() {
        StringBuilder sb = new StringBuilder(MISSION_NAME);
        Level[] values = Level.values();
        for (Level level : values) {
            sb.append(missionDto(level));
        }
        sb.delete(sb.length() - NEW_LINE_SIZE, sb.length());
        return sb.toString();
    }

    private static StringBuilder missionDto(Level level) {
        StringBuilder sb = new StringBuilder();
        sb.append(LEVEL_START_SUFFIX).append(level.getName()).append(LEVEL_START_PREFIX);
        for (Mission mission : level.getMissions()) {
            sb.append(mission.getName()).append(SEPARATOR);
        }
        if (!level.isMissionsEmpty()) {
            sb.delete(sb.length() - SEPARATOR_SIZE, sb.length());
        }
        sb.append("\n");
        return sb;
    }

    public static void printPairMatchingResult(List<String> pairMatchResult) {
        for (String pair : pairMatchResult) {
            System.out.println(pair);
        }
    }

    public static void printInit() {
        System.out.println(INIT_MESSAGE);
    }
}

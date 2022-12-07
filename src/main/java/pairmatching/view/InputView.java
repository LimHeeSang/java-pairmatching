package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.model.Course;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;

import java.util.function.Supplier;

public class InputView {

    private static final String INPUT_FEATURE_MESSAGE = "기능을 선택하세요.\n" + "1. 페어 매칭\n" +
            "2. 페어 조회\n" + "3. 페어 초기화\n" + "Q. 종료";
    private static final String REGEX_COURSE_LEVEL_MISSION = ", ";
    private static final String REMATCH_INPUT_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" + "네 | 아니오";
    private static final String INPUT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";
    private static final int SPLIT_INDEX_ZERO = 0;
    private static final int SPLIT_INDEX_ONE = 1;
    private static final int SPLIT_INDEX_TWO = 2;

    private InputView() {
    }

    public static FeatureType inputFeature() {
        System.out.println(INPUT_FEATURE_MESSAGE);
        return FeatureType.from(Console.readLine());
    }

    public static CourseLevelMissionDto inputCourseLevelMission() {
        System.out.println(INPUT_COURSE_LEVEL_MISSION_MESSAGE);
        return createCourseLevelMissionDto(Console.readLine());
    }

    private static CourseLevelMissionDto createCourseLevelMissionDto(String input) {
        String[] splitInput = input.split(REGEX_COURSE_LEVEL_MISSION);
        return new CourseLevelMissionDto(
                Course.from(splitInput[SPLIT_INDEX_ZERO]),
                Level.from(splitInput[SPLIT_INDEX_ONE]),
                Mission.from(splitInput[SPLIT_INDEX_TWO]));
    }

    public static ReMatchType inputRematch() {
        System.out.println(REMATCH_INPUT_MESSAGE);
        return ReMatchType.from(Console.readLine());
    }

    public static <T> T inputMethod(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMethod(supplier);
        }
    }
}

package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.model.Course;
import pairmatching.domain.model.Level;
import pairmatching.domain.model.Mission;

public class InputView {

    private static final String INPUT_FEATURE_MESSAGE = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";
    private static final String REGEX_COURSE_LEVEL_MISSION = ", ";

    private InputView() {
    }

    public static FeatureType inputFeature() {
        System.out.println(INPUT_FEATURE_MESSAGE);
        return FeatureType.from(Console.readLine());
    }

    public static CourseLevelMissionDto inputCourseLevelMission() {
        String input = Console.readLine();
        return createCourseLevelMissionDto(input);
    }

    private static CourseLevelMissionDto createCourseLevelMissionDto(String input) {
        String[] splitInput = input.split(REGEX_COURSE_LEVEL_MISSION);
        return new CourseLevelMissionDto(
                Course.from(splitInput[0]),
                Level.from(splitInput[1]),
                Mission.from(splitInput[2]));
    }
}

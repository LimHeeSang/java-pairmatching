package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_FEATURE_MESSAGE = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    private InputView() {
    }

    public static FeatureType inputFeature() {
        System.out.println(INPUT_FEATURE_MESSAGE);
        return FeatureType.from(Console.readLine());
    }
}

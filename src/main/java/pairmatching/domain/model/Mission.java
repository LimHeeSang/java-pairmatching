package pairmatching.domain.model;

import java.util.Arrays;

public enum Mission {

    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINE_MAP("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTE("배포");

    private static final String ERROR_INVALID_MISSION_INPUT = "[ERROR] 없는 미션입니다.";
    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission from(String name) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_MISSION_INPUT));
    }

    private boolean isEqualName(String name) {
        return this.name.equals(name);
    }
}

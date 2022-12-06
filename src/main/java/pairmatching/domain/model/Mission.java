package pairmatching.domain.model;

public enum Mission {

    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINE_MAP("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTE("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }
}

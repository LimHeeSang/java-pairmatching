package pairmatching.view;

import java.util.Arrays;

public enum FeatureType {

    PAIR_MATCH("1"),
    PAIR_GET("2"),
    PAIR_INIT("3"),
    QUIT("Q");

    private static final String ERROR_INVALID_FEATURE_INPUT = "[ERROR] 1, 2, 3, Q 중 입력 가능합니다.";
    private final String command;

    FeatureType(String command) {
        this.command = command;
    }

    public static FeatureType from(String command) {
        return Arrays.stream(FeatureType.values())
                .filter(featureType -> featureType.isEqualCommand(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_FEATURE_INPUT));
    }

    private boolean isEqualCommand(String command) {
        return this.command.equals(command);
    }
}

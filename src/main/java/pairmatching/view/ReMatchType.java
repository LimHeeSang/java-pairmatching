package pairmatching.view;

import java.util.Arrays;

public enum ReMatchType {

    YES("네"),
    NO("아니오");

    private static final String ERROR_INVALID_REMATCHTYPE_INPUT = "[ERROR] 재매치는 네, 아니오 중 입력 가능합니다.";
    private final String name;

    ReMatchType(String name) {
        this.name = name;
    }

    public static ReMatchType from(String name) {
        return Arrays.stream(ReMatchType.values())
                .filter(reMatchType -> reMatchType.isEqualCommand(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_REMATCHTYPE_INPUT));
    }

    private boolean isEqualCommand(String name) {
        return this.name.equals(name);
    }
}

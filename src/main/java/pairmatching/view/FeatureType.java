package pairmatching.view;

import pairmatching.controller.Feature;
import pairmatching.controller.PairGetFeature;
import pairmatching.controller.PairInitFeature;
import pairmatching.controller.PairMatchFeature;
import pairmatching.controller.QuitFeature;
import pairmatching.domain.service.PairMatchingService;

import java.util.Arrays;

public enum FeatureType {

    PAIR_MATCH("1", new PairMatchFeature()),
    PAIR_GET("2", new PairGetFeature()),
    PAIR_INIT("3",new PairInitFeature()),
    QUIT("Q", new QuitFeature());

    private static final String ERROR_INVALID_FEATURE_INPUT = "[ERROR] 1, 2, 3, Q 중 입력 가능합니다.";
    private final String command;
    private final Feature feature;

    FeatureType(String command, Feature feature) {
        this.command = command;
        this.feature = feature;
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

    public void operate(PairMatchingService pairMatchingService) {
        feature.operate(pairMatchingService);
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}

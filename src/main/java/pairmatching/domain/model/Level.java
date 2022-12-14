package pairmatching.domain.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {

    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL_GAME)),
    LEVEL2("레벨2", Arrays.asList(Mission.SHOPPING_BASKET, Mission.PAYMENT, Mission.SUBWAY_LINE_MAP)),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DISTRIBUTE)),
    LEVEL5("레벨5", Collections.emptyList());

    private static final String ERROR_INVALID_MISSION = "[ERROR] 해당 레벨에 없는 미션입니다.";
    private static final String ERROR_INVALID_LEVEL_INPUT = "[ERROR] 없는 레벨입니다.";
    private final String name;
    private final List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level from(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_LEVEL_INPUT));
    }

    private boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    public void validateMission(Mission mission) {
        if (!missions.contains(mission)) {
            throw new IllegalArgumentException(ERROR_INVALID_MISSION);
        }
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public boolean isMissionsEmpty() {
        return missions.size() == 0;
    }
}

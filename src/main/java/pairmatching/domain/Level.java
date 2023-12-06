package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL_GAME)),
    LEVEL2("레벨2", Arrays.asList(Mission.CART, Mission.PAYMENT, Mission.SUBWAY_PATH)),
    LEVEL3("레벨3", Collections.EMPTY_LIST),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DISTRIBUTION)),
    LEVEL5("레벨5", Collections.EMPTY_LIST);

    private final String name;
    private final List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level from(String string) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(string))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효한 입력이 아닙니다"));
    }
}

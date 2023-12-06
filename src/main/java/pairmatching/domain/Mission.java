package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_PATH("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTION("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission from(String string) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.name.equals(string))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효한 입력이 아닙니다"));
    }
}

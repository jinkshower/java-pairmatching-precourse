package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String string) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(string))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효한 입력이 아닙니다"));
    }
}

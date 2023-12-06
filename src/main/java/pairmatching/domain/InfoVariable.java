package pairmatching.domain;

import java.util.Objects;

public class InfoVariable {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public InfoVariable(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public boolean isBackend() {
        return course == Course.BACKEND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InfoVariable that = (InfoVariable) o;
        return course == that.course && level == that.level && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}

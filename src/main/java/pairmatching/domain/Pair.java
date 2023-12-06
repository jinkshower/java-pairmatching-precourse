package pairmatching.domain;

import java.util.List;
import java.util.StringJoiner;

public class Pair {

    private final List<Crew> pair;

    public Pair(List<Crew> pair) {
        this.pair = pair;
    }

    public String getPairNames() {
        StringJoiner stringJoiner = new StringJoiner(" : ");
        for (Crew crew: pair) {
            stringJoiner.add(crew.getName());
        }
        return stringJoiner.toString();
    }
}

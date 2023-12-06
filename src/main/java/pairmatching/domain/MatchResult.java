package pairmatching.domain;

import java.util.List;

public class MatchResult {

    private final InfoVariable infoVariable;
    private final List<Pair> pairs;

    public MatchResult(InfoVariable infoVariable, List<Pair> pairs) {
        this.infoVariable = infoVariable;
        this.pairs = pairs;
    }


}

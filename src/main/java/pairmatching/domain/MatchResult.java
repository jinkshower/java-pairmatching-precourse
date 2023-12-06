package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatchResult {

    private final InfoVariable infoVariable;
    private final List<Pair> pairs;

    public MatchResult(InfoVariable infoVariable, List<Pair> pairs) {
        this.infoVariable = infoVariable;
        this.pairs = pairs;
    }

    public boolean hasSameInfoVariable(InfoVariable otherInfoVariable) {
        return infoVariable.equals(otherInfoVariable);
    }

    public InfoVariable getInfoVariable() {
        return infoVariable;
    }

    public List<Pair> getPairs() {
        return new ArrayList<>(pairs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchResult that = (MatchResult) o;
        return Objects.equals(infoVariable, that.infoVariable) && Objects.equals(pairs, that.pairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infoVariable, pairs);
    }
}

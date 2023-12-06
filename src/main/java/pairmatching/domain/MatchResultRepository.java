package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MatchResultRepository {

    private static List<MatchResult> results = new ArrayList<>();

    public static void add(MatchResult matchResult) {
        results.add(matchResult);
    }

    public static String getMatchResult(InfoVariable infoVariable) {
        return covertToString(FindByInfo(infoVariable));
    }

    public static MatchResult FindByInfo(InfoVariable infoVariable) {
        return results.stream()
                .filter(matchResult -> matchResult.hasSameInfoVariable(infoVariable))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효한 입력이 아닙니다"));
    }

    private static String covertToString(MatchResult matchResult) {
        List<Pair> result = matchResult.getPairs();
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Pair pair: result) {
            stringJoiner.add(pair.getPairNames());
        }
        return stringJoiner.toString();
    }
}

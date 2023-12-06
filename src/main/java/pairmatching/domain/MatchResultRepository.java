package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MatchResultRepository {

    private static List<MatchResult> results = new ArrayList<>();

    public static void add(MatchResult matchResult) {
        results.add(matchResult);
    }

    public static void reassign(MatchResult matchResult) {
        results.set(FindIndex(matchResult), matchResult);
    }

    public static String getMatchResult(InfoVariable infoVariable) {
        return covertToString(FindByInfo(infoVariable));
    }

    private static int FindIndex(MatchResult othermatchResult) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).equals(othermatchResult)) {
                return i;
            }
        }
        return 0;
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
        for (Pair pair : result) {
            stringJoiner.add(pair.getPairNames());
        }
        return stringJoiner.toString();
    }

    public static boolean hasResult(InfoVariable infoVariable) {
        return FindByInfo(infoVariable) != null;
    }

    public static boolean isEmpty() {
        return results.isEmpty();
    }

    public static void clear() {
        results = new ArrayList<>();
    }
}

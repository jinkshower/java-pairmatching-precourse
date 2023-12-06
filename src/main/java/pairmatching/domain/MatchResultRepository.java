package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResultRepository {

    private static List<MatchResult> results = new ArrayList<>();

    public static void add(MatchResult matchResult) {
        results.add(matchResult);
    }
}

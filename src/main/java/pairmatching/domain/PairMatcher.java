package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PairMatcher {

    private List<Crew> crews;
    private List<Pair> pairs;

    public PairMatcher(List<Crew> crews) {
        this.crews = crews;
    }

    public void execute() {
        crews = Randoms.shuffle(crews);
        pairs = new ArrayList<>();
        // 홀수 페어 계산 반복문
        int partitionSize = 2;
        for (int i = 0; i < crews.size(); i += partitionSize) {
            if (i == crews.size() - 3) {
                pairs.add(new Pair((crews.subList(i, crews.size())));
                break;
            }
            pairs.add(new Pair(crews.subList(i, i + partitionSize)));
        }
    }


}

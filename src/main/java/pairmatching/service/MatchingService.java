package pairmatching.service;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewNameReader;
import pairmatching.domain.InfoVariable;
import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResultRepository;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatcher;

public class MatchingService {

    private final CrewNameReader crewNameReader;
    private List<Crew> backendCrew;
    private List<Crew> frontendCrew;

    public MatchingService(CrewNameReader crewNameReader) {
        this.crewNameReader = crewNameReader;
    }

    public void assignCrew() {
        backendCrew = createCrew(crewNameReader.getBackendCrewNames(), Course.BACKEND);
        frontendCrew = createCrew(crewNameReader.getFrontendCrewNames(), Course.FRONTEND);
    }

    private List<Crew> createCrew(List<String> crewNames, Course course) {
        return crewNames.stream()
                .map(string -> new Crew(course, string))
                .collect(Collectors.toList());
    }

    public void service(InfoVariable infoVariable) {
        if (infoVariable.isBackend()) {
            MatchResult matchResult = new MatchResult(infoVariable, pairMatch(backendCrew));
            MatchResultRepository.add(matchResult);
            return;
        }
        MatchResult matchResult = new MatchResult(infoVariable, pairMatch(frontendCrew));
        MatchResultRepository.add(matchResult);
    }

    private List<Pair> pairMatch(List<Crew> crews) {
        PairMatcher pairMatcher = new PairMatcher(crews);
        return pairMatcher.execute();
    }

    public String getMatchResult(InfoVariable infoVariable) {
        return MatchResultRepository.getMatchResult(infoVariable);
    }
}

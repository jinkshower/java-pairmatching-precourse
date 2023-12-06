package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.CrewNameReader;
import pairmatching.domain.InfoVariable;
import pairmatching.domain.Level;
import pairmatching.domain.MatchResultRepository;
import pairmatching.domain.Mission;
import pairmatching.domain.ProgramCommand;
import pairmatching.domain.ReinitializingCommand;
import pairmatching.service.MatchingService;
import pairmatching.util.ExceptionHandler;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private MatchingService matchingService;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchingService = new MatchingService(new CrewNameReader());
        matchingService.assignCrew();
    }

    public void run() {
        ProgramCommand programCommand = ExceptionHandler.repeatUntilValid(this::handleProgramCommand);
        if (programCommand == ProgramCommand.PAIR_MATCHING) {
            matchPair();
        }
        if (programCommand == ProgramCommand.PAIR_QUERY) {
            searchPair();
        }
        if (programCommand == ProgramCommand.PAIR_INITIALIZATION) {
            resetMatch();
        }
    }

    private void matchPair() {
        InfoVariable infoVariable = ExceptionHandler.repeatUntilValid(this::handleInfoChoice);
        if (!MatchResultRepository.isEmpty() && MatchResultRepository.hasResult(infoVariable)) {
            reinitialize(infoVariable);
        }
        matchingService.service(infoVariable);
        outputView.printMatchResult(matchingService.getMatchResult(infoVariable));
        run();
    }

    private void searchPair() {
        outputView.printInfo();
        InfoVariable infoVariable = ExceptionHandler.repeatUntilValid(this::handleInfoChoice);
        outputView.printMatchResult(matchingService.getMatchResult(infoVariable));
        run();
    }

    private void resetMatch() {
        MatchResultRepository.clear();
        outputView.printClearMessage();
        run();
    }

    private void reinitialize(InfoVariable infoVariable) {
        ReinitializingCommand reinitializingCommand = ExceptionHandler.repeatUntilValid(this::handleReinitializing);
        if (reinitializingCommand == ReinitializingCommand.YES) {
            matchingService.rematch(infoVariable);
            outputView.printMatchResult(matchingService.getMatchResult(infoVariable));
            run();
            return;
        }
    }

    private InfoVariable handleInfoChoice() {
        String input = inputView.readChoice();

        String[] split = input.replace(" ","").split(",");
        return new InfoVariable(Course.from(split[0]), Level.from(split[1]), Mission.from(split[2]));
    }
    private ProgramCommand handleProgramCommand() {
        String input = inputView.readCommand();
        return ProgramCommand.from(input);
    }

    private ReinitializingCommand handleReinitializing() {
        String input = inputView.readReinitialize();
        return ReinitializingCommand.from(input);
    }
}

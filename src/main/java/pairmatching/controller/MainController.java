package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.CrewNameReader;
import pairmatching.domain.InfoVariable;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.ProgramCommand;
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
    }

    public void run() {
        ProgramCommand programCommand = ExceptionHandler.repeatUntilValid(this::handleProgramCommand);
        if (programCommand == ProgramCommand.PAIR_MATCHING) {
            matchPair();
        }
    }

    private void matchPair() {
        InfoVariable infoVariable = ExceptionHandler.repeatUntilValid(this::handleInfoChoice);
        matchingService.assignCrew();
        matchingService.service(infoVariable);
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
}

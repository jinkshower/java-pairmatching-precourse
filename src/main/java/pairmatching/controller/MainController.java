package pairmatching.controller;

import java.util.List;
import pairmatching.domain.CrewNameReader;
import pairmatching.domain.ProgramCommand;
import pairmatching.util.ExceptionHandler;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CrewNameReader crewNameReader = new CrewNameReader();

        ProgramCommand programCommand = ExceptionHandler.repeatUntilValid(this::handleProgramCommand);
        if (programCommand == ProgramCommand.PAIR_MATCHING) {
            matchPair();
        }
    }

    private void matchPair() {
        System.out.println("matched");
    }

    private ProgramCommand handleProgramCommand() {
        String input = inputView.readCommand();
        return ProgramCommand.from(input);
    }
}

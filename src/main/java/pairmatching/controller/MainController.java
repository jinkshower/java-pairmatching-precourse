package pairmatching.controller;

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
        ProgramCommand programCommand = ExceptionHandler.repeatUntilValid(this::handleProgramCommand);
        System.out.println(programCommand);
    }

    private ProgramCommand handleProgramCommand() {
        String input = inputView.readCommand();
        return ProgramCommand.from(input);
    }
}

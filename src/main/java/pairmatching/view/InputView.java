package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public String readCommand() {
        System.out.println("기능을 선택하세요.");
        return Console.readLine();
    }
}

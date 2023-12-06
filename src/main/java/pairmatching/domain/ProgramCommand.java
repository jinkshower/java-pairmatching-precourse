package pairmatching.domain;

import java.util.Arrays;
import javax.swing.Popup;

public enum ProgramCommand {

    PAIR_MATCHING("1"),
    PAIR_QUERY("2"),
    PAIR_INITIALIZATION("3"),
    QUIT("Q");

    private final String command;

    ProgramCommand(String command) {
        this.command = command;
    }

    public static ProgramCommand from(String string) {
        return Arrays.stream(ProgramCommand.values())
                .filter(programCommand -> programCommand.command.equals(string))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효한 입력이 아닙니다"));
    }
}

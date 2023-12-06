package pairmatching.domain;

import java.util.Arrays;

public enum ReinitializingCommand {

    YES("네"),
    NO("아니오");

    private final String command;

    ReinitializingCommand(String command) {
        this.command = command;
    }

    public static ReinitializingCommand from(String string) {
        return Arrays.stream(ReinitializingCommand.values())
                .filter(reinitializingCommand -> reinitializingCommand.command.equals(string))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효한 입력이 아닙니다"));
    }
}

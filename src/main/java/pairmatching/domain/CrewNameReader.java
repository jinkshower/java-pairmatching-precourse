package pairmatching.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewNameReader {

    private static final String BACKEND_FILE = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE = "src/main/resources/frontend-crew.md";

    private final List<String> backendCrewNames;
    private final List<String> frontendCrewNames;

    public CrewNameReader() {
        this.backendCrewNames = readLines(BACKEND_FILE);
        this.frontendCrewNames = readLines(FRONTEND_FILE);
    }

    public List<String> readLines(String filename) {
        try {
            File text = new File(filename);
            List<String> result = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(text));
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                result.add(string);
            }
            return result;
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽을 수 없습니다");
        }
    }

    public List<String> getBackendCrewNames() {
        return new ArrayList<>(backendCrewNames);
    }

    public List<String> getFrontendCrewNames() {
        return new ArrayList<>(frontendCrewNames);
    }
}

package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String NAME_INPUT_DESCRIPTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_INPUT_DESCRIPTION = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    public static String[] inputNames() throws IOException {
        System.out.println(NAME_INPUT_DESCRIPTION);
        String rawNames = br.readLine();
        return rawNames.split(DELIMITER);
    }

    public static int inputMoveCount() throws IOException {
        System.out.println(MOVE_COUNT_INPUT_DESCRIPTION);
        String moveCount = br.readLine();
        return Integer.parseInt(moveCount);
    }
}


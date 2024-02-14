package racingcar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import racingcar.model.Car;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private List<Car> carList;
    private String[] names;
    private int moveCount;

    public void init() throws IOException {
        readCarNames();
        readMoveCount();
        initCars(names);
    }

    private void readCarNames() throws IOException {
        boolean nameInput = false;
        while (!nameInput) {
            nameInput = getCarNames();
        }
    }

    private boolean getCarNames() throws IOException {
        try {
            names = InputView.inputNames();
            Validator.validateCarName(names);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void readMoveCount() throws IOException {
        boolean moveCountInput = false;
        while (!moveCountInput) {
            moveCountInput = getMoveCount();
        }
    }

    private boolean getMoveCount() throws IOException {
        try {
            moveCount = InputView.inputMoveCount();
            Validator.validateMoveCount(moveCount);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void initCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }

    private void playRound() {
        for (Car car: carList) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber >= 4) {
                car.move();
            }
            OutputView.printPosition(car);
        }
    }


}

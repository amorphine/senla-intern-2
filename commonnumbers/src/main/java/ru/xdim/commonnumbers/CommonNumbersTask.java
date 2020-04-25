package ru.xdim.commonnumbers;

import ru.xdim.common.Task;
import ru.xdim.common.input.InputHelper;
import ru.xdim.commonnumbers.dto.TwoIntegersDTO;

public class CommonNumbersTask implements Task {
    private final InputHelper<TwoIntegersDTO> inputHelper;

    public CommonNumbersTask() {
        this.inputHelper = new InputHelper<>(new TwoIntegersInputValidator());
    }

    @Override
    public void run() {
        final TwoIntegersDTO numbers = inputHelper.getValue();

        System.out.println("GCD: " + numbers.findGCD());

        System.out.println("LCM: " + numbers.findLCM());
    }
}

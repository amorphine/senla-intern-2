package ru.xdim.parity;

import ru.xdim.common.Task;
import ru.xdim.common.input.InputHelper;
import ru.xdim.common.input.validators.SingleNumberValidator;

public final class ParityTask implements Task {
    private final InputHelper<Integer> numberInputHelper;

    private final String numberIsEvenMessage = "Number is even";
    private final String numberIsOddMessage = "Number is odd";

    public ParityTask() {
        this.numberInputHelper = new InputHelper<>(new SingleNumberValidator());
    }

    public void run() {
        int userInput = numberInputHelper.getValue();

        System.out.println(userInput % 2 == 0 ? this.numberIsEvenMessage : this.numberIsOddMessage);
    }
}

package ru.xdim.palindrome;

import ru.xdim.common.Task;
import ru.xdim.common.input.InputHelper;
import ru.xdim.common.input.validators.SingleNumberValidator;

public class PalindromeTask implements Task {
    private final InputHelper<Integer> inputHelper;

    public PalindromeTask() {
        this.inputHelper = new InputHelper<>(new SingleNumberValidator());
    }

    @Override
    public void run() {
        final int maxNumber = inputHelper.getValue();

        int count = 0;

        for (int i = 0; i <= maxNumber; i++) {
            if (this.isPalindrome(i)) {
                count++;
            }
        }

        System.out.println("Palindrome count in range 0 - " + maxNumber + ": " + count);
    }

    /**
     * Check the number is palindrome
     *
     * @param n input number
     * @return true if the argument is palindrome
     */
    boolean isPalindrome(int n) {
        if (n % 10 == 0) {
            return false;
        }

        int reverted = 0;

        for (int i = n; i > 0; i /= 10) {
            reverted = reverted * 10 + i % 10;
        }

        return (n == reverted);
    }
}

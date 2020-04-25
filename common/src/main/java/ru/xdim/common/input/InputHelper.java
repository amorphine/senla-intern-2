package ru.xdim.common.input;

import ru.xdim.common.input.validators.InputValidatorInterface;
import ru.xdim.common.input.validators.ValidationException;

import java.util.Scanner;

/**
 * The class to get user input and convert it to some form via Validator object
 *
 * @param <T>
 * @see InputValidatorInterface
 */
public class InputHelper<T> {
    // I'd like to use scanner in try-resource but it closes System.in. So let's leave it as is
    private static final Scanner scanner = new Scanner(System.in);

    private final InputValidatorInterface<T> validator;

    public InputHelper(final InputValidatorInterface<T> validator) {
        this.validator = validator;
    }

    /**
     * Show prompt message to user and get the input
     *
     * @return user input converted through validator
     */
    public T getValue() {
        return this.getValue(null);
    }

    /**
     * Show prompt message to user and get the input
     *
     * @return user input converted through validator
     */
    public T getValue(String prompt) {
        System.out.println(prompt == null || prompt.isEmpty() ? validator.getPromptMessage() : prompt);

        try {
            return this.validator.validateAndSanitize(scanner.nextLine());
        } catch (ValidationException e) {
            System.out.println("Please try again and ensure the input is correct");

            return this.getValue(prompt);
        }
    }
}

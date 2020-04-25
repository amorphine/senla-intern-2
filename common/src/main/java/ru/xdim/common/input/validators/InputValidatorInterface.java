package ru.xdim.common.input.validators;

/**
 * Class to validate, sanitize and cast a string into another form
 *
 * @param <T>
 */
public interface InputValidatorInterface<T> {
    /**
     * Converts the string into the type is being expected
     *
     * @param input raw string
     * @return parsed data
     * @throws ValidationException is thrown if conversion is not possible
     */
    T validateAndSanitize(final String input) throws ValidationException;

    /**
     * Message to show to the user for him to understand
     * what kind of input is being expected from him to enter
     *
     * @return invite message
     */
    String getPromptMessage();
}

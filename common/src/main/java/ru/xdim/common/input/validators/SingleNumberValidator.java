package ru.xdim.common.input.validators;

public class SingleNumberValidator extends AbstractInputValidator<Integer> {
    protected final String defaultPromptMessage = "Enter number";

    public SingleNumberValidator() {
        super();
    }

    public SingleNumberValidator(final String promptMessage) {
        super(promptMessage);
    }

    @Override
    public String getDefaultPromptMessage() {
        return this.defaultPromptMessage;
    }

    @Override
    public Integer validateAndSanitize(final String input) throws ValidationException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ValidationException();
        }
    }
}

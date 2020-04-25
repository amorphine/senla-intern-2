package ru.xdim.common.input.validators;

public class TextValidator extends AbstractInputValidator<String> {
    private static final String defaultPromptMessage = "Enter some text";

    public TextValidator() {
        this.promptMessage = this.getDefaultPromptMessage();
    }

    public TextValidator(String message) {
        this.promptMessage = message;
    }

    public String getDefaultPromptMessage() {
        return TextValidator.defaultPromptMessage;
    }

    public String validateAndSanitize(String input) throws ValidationException {
        input = input.trim();

        if (input.length() == 0) {
            throw new ValidationException();
        }

        return input;
    }
}

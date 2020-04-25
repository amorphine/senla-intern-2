package ru.xdim.common.input.validators;

public abstract class AbstractInputValidator<T> implements InputValidatorInterface<T> {
    protected String promptMessage = "";

    public AbstractInputValidator() {
        this.promptMessage = this.getDefaultPromptMessage();
    }

    public AbstractInputValidator(final String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(final String promptMessage) {
        this.promptMessage = promptMessage;
    }

    /**
     * Get default prompt message
     *
     * @return - default prompt message
     */
    public abstract String getDefaultPromptMessage();
}

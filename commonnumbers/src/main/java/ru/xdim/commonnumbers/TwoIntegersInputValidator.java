package ru.xdim.commonnumbers;

import ru.xdim.common.input.validators.AbstractInputValidator;
import ru.xdim.common.input.validators.ValidationException;
import ru.xdim.commonnumbers.dto.TwoIntegersDTO;

import java.util.Arrays;

public class TwoIntegersInputValidator extends AbstractInputValidator<TwoIntegersDTO> {
    private final String defaultPromptMessage = "Please enter two positive numbers divided with a space:";

    @Override
    public String getDefaultPromptMessage() {
        return this.defaultPromptMessage;
    }

    @Override
    public TwoIntegersDTO validateAndSanitize(String input) throws ValidationException {
        int[] ints = Arrays.stream(
                input.replaceAll("-", " -").split("[^-\\d]+")
        ).filter(s -> !s.matches("-?"))
                .mapToInt(Integer::parseInt).toArray();

        if (ints.length != 2 || ints[0] < 0 || ints[1] < 0) {
            throw new ValidationException();
        }

        return new TwoIntegersDTO(ints[0], ints[1]);
    }
}

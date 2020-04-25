package ru.xdim.sentence;

import ru.xdim.common.Task;
import ru.xdim.common.input.InputHelper;
import ru.xdim.common.input.validators.TextValidator;

import java.text.Collator;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SentenceTask implements Task {
    private static final String sentencePrompt = "Please enter a text: ";

    private final InputHelper<String> textInputHelper;

    SentenceTask() {
        this.textInputHelper = new InputHelper<>(new TextValidator(sentencePrompt));
    }

    public void run() {
        final String text = textInputHelper.getValue();

        String[] words = text.split("\\P{L}+");
        Arrays.sort(words, Collator.getInstance());

        System.out.println("Words count: " + words.length);
        System.out.println("Sorted words: " + String.join(", ", words));
        System.out.println("Capitalized text: " + this.capitalize(text));

    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return Arrays.stream(str.split("\\s+"))
                .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
    }
}

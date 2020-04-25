package ru.xdim.wordcount;

import ru.xdim.common.Task;
import ru.xdim.common.input.InputHelper;
import ru.xdim.common.input.validators.TextValidator;

import java.util.Arrays;

public final class WordCountTask implements Task {
    private static final String sentencePrompt = "Please enter a text: ";
    private static final String wordPrompt = "Please enter a word: ";

    private final InputHelper<String> textInputHelper;
    private final InputHelper<String> wordInputHelper;

    WordCountTask() {
        this.textInputHelper = new InputHelper<>(new TextValidator(sentencePrompt));
        this.wordInputHelper = new InputHelper<>(new TextValidator(wordPrompt));
    }

    @Override
    public void run() {
        final String text = this.textInputHelper.getValue().toLowerCase();
        final String word = this.wordInputHelper.getValue().toLowerCase();

        long textWordsCount = Arrays.stream(text.split("\\P{L}+")).filter(
                textWord -> textWord.equals(word)
        ).count();

        System.out.println("Word count: " + textWordsCount);
    }
}

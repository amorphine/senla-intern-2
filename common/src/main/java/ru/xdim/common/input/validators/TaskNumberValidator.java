package ru.xdim.common.input.validators;

import org.reflections.Reflections;
import ru.xdim.common.Task;

/**
 * Class can be used to offer to chose the task number
 */
public class TaskNumberValidator extends AbstractInputValidator<Integer> {
    protected final String defaultPromptMessage = "Enter task number";
    private Class<? extends Task>[] tasks;

    public TaskNumberValidator() {
        this.initTaskSet();
    }

    private void initTaskSet() {
        Reflections reflections = new Reflections();

        this.tasks = reflections.getSubTypesOf(Task.class).toArray(new Class[0]);
    }

    public String getPromptMessage() {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (Class<? extends Task> task : tasks) {
            sb.append(index);
            sb.append(" - ");
            sb.append(task.getSimpleName());
            sb.append("\r\n");

            index++;
        }

        return sb.toString();
    }

    @Override
    public String getDefaultPromptMessage() {
        return this.defaultPromptMessage;
    }

    public Integer validateAndSanitize(String input) throws ValidationException {
        return null;
    }
}

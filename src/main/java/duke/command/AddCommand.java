package duke.command;

import duke.Bot;
import duke.task.Task;
import duke.task.TaskList;

public class AddCommand implements Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(Bot bot, TaskList list) {
        list.add(task);
        bot.sayLine("Got it, I've added this task:");
        bot.sayLine("  " + task.displayString());
        bot.sayLine("Now you have " + list.size() + " item(s) in your list.");
    }
}

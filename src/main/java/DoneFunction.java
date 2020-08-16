import java.util.List;

public class DoneFunction implements Function {
    private int index;

    public DoneFunction(int index) {
       this.index = index;
    }

    @Override
    public void execute(Bot bot, List<Task> list) {
        if (list.isEmpty()) {
            bot.sayLine("Your list is empty.");
        } else if (index < 0) {
            bot.sayLine("That's not a valid number, please give a number from 1 to " + list.size() + ".");
        } else if (index >= list.size()) {
            bot.sayLine(String.format("That's not a valid number, you only have %d item(s) in your list.", list.size()));
        } else {
            Task t = list.get(index);
            if (t.isDone()) {
                bot.sayLine("You've already completed this task:");
            } else {
                t.markAsDone();
                bot.sayLine("Nice! I've marked this task as done:");
            }
            bot.sayLine("  " + t.displayString());
        }
    }
}

package commands;

import java.util.Map;
import java.util.TreeMap;

/**
 * Класс инвокер паттерна Команда
 */


public class Invoker {

    public static Map<String, Commandable> commands = new TreeMap<>();
    public boolean check(String s){
        return commands.containsKey(s);
    }


    public void register(String commandName, Commandable command) {
        commands.put(commandName, command);
    }

    public void register(Commandable... commands) {
        for (Commandable command : commands)
            this.commands.put(command.getName(), command);
    }

    public void execute(String commandName) {
        Object argument = null;
        String[] NameAndArgs = commandName.split(" ");
        Commandable command = commands.get(NameAndArgs[0]);
        if (!NameAndArgs[0].equals("KLPO"))
        try {
            if (command == null)
                throw new IllegalStateException();

            if (NameAndArgs.length == 2)
                argument = NameAndArgs[1];

            command.execute(argument);
        } catch (IllegalStateException e) {
            if (!NameAndArgs[0].equals(""))
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
        }

    }
}

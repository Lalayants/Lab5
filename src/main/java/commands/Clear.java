package commands;

/**
 * Класс команды очистки коллекции
 */

public class Clear implements Commandable{

    @Override
    public void execute(Object o) {
        labcollection.clear();
    }

    @Override
    public String getDescription() {
        return ": очистить коллекцию";
    }

    @Override
    public String getName() {
        return "clear";
    }
}

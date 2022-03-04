package Commands;

import LabStuff.LabCollection;

/**
 * Класс команды, выводящей команду в консоль
 */

public class Show implements Commandable{

    @Override
    public void execute(Object o) {
        labcollection.show();
    }

    @Override
    public String getDescription() {
        return ": показать все элементы коллекции";
    }

    @Override
    public String getName() {
        return "show";
    }
}

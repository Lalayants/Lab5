package commands;

/**
 * Класс команды, выводящей справку по коллекции
 */
public class Info implements Commandable {

    @Override
    public void execute(Object o) {
        System.out.println(labcollection.getInfo());
    }

    @Override
    public String getDescription() {
        return ": вывести в стандартный поток вывода информацию о коллекции";
    }

    @Override
    public String getName() {
        return "info";
    }
}

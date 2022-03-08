package commands;

/**
 * Класс команды, выводящей справку по всем командам
 */
public class Help implements Commandable{
    @Override
    public void execute(Object o) {
        for (Commandable i: Invoker.commands.values()){
            System.out.println(i.getName() + " " + i.getDescription());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return " : вывести справку по доступным командам";
    }
}

package commands;

import utilities.LabWorkCreator;

/**
 * Класс команды добавления элемента в коллекцию
 */

public class Add implements Commandable{
    /**
     *
     * @param o
     */




    @Override
    public void execute(Object o) {
        labcollection.add(LabWorkCreator.create());
        System.out.println("Добавлено");
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "add";
    }

    /**
     * @return
     */
    public String getDescription(){
        return ": добавить новый элемент в коллекцию";
    }
}

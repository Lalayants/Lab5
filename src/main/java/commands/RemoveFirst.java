package commands;

import labStuff.LabCollection;

/**
 * Класс команды, удаляющей первый элемент
 */

public class RemoveFirst implements Commandable{
    @Override
    public void execute(Object o) {
        LabCollection.collection.remove(0);
        System.out.println("Первый элемент удален");

    }

    @Override
    public String getDescription() {
        return ": удалить первый элемент из коллекции";
    }

    @Override
    public String getName() {
        return "remove_first";
    }
}

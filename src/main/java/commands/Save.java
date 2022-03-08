package commands;

import labStuff.LabCollection;
import utilities.FileWriter;

/**
 * Класс команды, сохраняющий коллекцию в файл
 */
public class Save implements Commandable {
    @Override
    public void execute(Object o) {
        FileWriter.writeToFile(LabCollection.getCollection());
        System.out.println("Коллекция сохранена");
    }

    @Override
    public String getDescription() {
        return ": сохранить коллекцию в файл";
    }

    @Override
    public String getName() {
        return "save";
    }
}

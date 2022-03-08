package commands;

import labStuff.LabCollection;
import labStuff.LabWork;
import utilities.LabWorkCreator;

/**
 * Класс команды, обновляющей элемент по ID
 */

public class UpdateId implements Commandable{
    @Override
    public void execute(Object o) {
        try {
            int id = Integer.parseInt((String) o);
            if (LabCollection.ids.contains(id)) {
                for (LabWork elems : LabCollection.collection) {
                    if (elems.getId().equals(id)) {
                        LabCollection.ids.remove(elems.getId());
                        elems.clone(LabWorkCreator.create(id));
                    }
                }
                System.out.println("Замена прошла успешно");
            } else {
                System.out.println("Нет элемента с таким ID");
            }
        } catch (NumberFormatException e){
            System.out.println("Id должен быть целым числом");
        }
    }

    @Override
    public String getDescription() {
        return ": обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "updateid";
    }
}

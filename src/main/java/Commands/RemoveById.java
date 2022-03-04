package Commands;

import LabStuff.LabCollection;
import LabStuff.LabWork;
import Utilities.LabWorkCreator;

/**
 * Класс команды, удаляющей элемент по id
 */

public class RemoveById implements Commandable{
    @Override
    public void execute(Object o) {
        try {
            LabWork td = null;
            int id = Integer.parseInt((String) o);
            if (LabCollection.ids.contains(id)) {
                for (LabWork elems : LabCollection.collection) {
                    if (elems.getId().equals(id)) {
                        LabCollection.ids.remove(elems.getId());
                        td = elems;
                        break;
                    }
                }
                labcollection.remove(td);
                System.out.println("Элемент удален успешно");
            } else {
                System.out.println("Нет элемента с таким ID");
            }
        } catch (NumberFormatException e){
            System.out.println("Id должен быть целым числом");
        }

    }

    @Override
    public String getDescription() {
        return ": удалить элемент из коллекции по его id";
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}

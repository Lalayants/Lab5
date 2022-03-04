package Commands;

import LabStuff.LabCollection;
import LabStuff.LabWork;
import Utilities.LabComparator;
import Utilities.LabWorkCreator;

import java.util.Vector;

/**
 * Класс команды, удаляющей все элементы меньше указанного
 */

public class RemoveLower implements Commandable{
    @Override
    public void execute(Object o) {
        LabWork ref = LabWorkCreator.create();
        Vector<LabWork> buffer = new Vector<>();
        LabCollection labcollection = new LabCollection();
        labcollection.add(ref);
        for (LabWork elems : LabCollection.collection) {
            if (elems.compareTo(ref)<0) {
                LabCollection.ids.remove(elems.getId());
                buffer.add(elems);
            }
        }
        if (buffer.isEmpty()){
            System.out.println("Таких элементов нет");
        } else {
            for (LabWork elems: buffer){
                labcollection.remove(elems);
            }
            System.out.println("Элементы меньше данного удалены");
        }


    }

    @Override
    public String getDescription() {
        return ": удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public String getName() {
        return "remove_lower";
    }
}

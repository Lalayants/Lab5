package commands;

import labStuff.LabCollection;
import labStuff.LabWork;
import utilities.LabComparator;
import utilities.LabWorkCreator;

import java.util.Vector;

/** Класс команды добавления элемента, если он будет наименьшним
 *
 */

public class AddIfMin implements Commandable{
    /**
     *
     * @param o
     */
    @Override
    public void execute(Object o) {
        LabWork a = LabWorkCreator.create();
        Vector<LabWork> copy= LabCollection.getClone();
        copy.sort(new LabComparator());
        try {
            if (a.compareTo(copy.get(0)) < 0) {
                LabCollection.collection.add(a);
                System.out.println("Элемент добавлен");
            } else {
                System.out.println("Элемент больше минимального, поэтому не добавлен");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Коллекция пуста, команда не будет выполняться");
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription() {
        return ": добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "add_if_min";
    }
}

package Commands;

import LabStuff.LabCollection;
import LabStuff.LabWork;
import Utilities.LabComparator;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 * Класс команды, выводящий коллекцию в порядке уменьшения
 */

public class PrintDescending implements Commandable{
    @Override
    public void execute(Object o) {
        Vector<LabWork> v = LabCollection.getClone();
        v.sort(new LabComparator().reversed());
        LabCollection.show(v);

    }

    @Override
    public String getDescription() {
        return " : вывести элементы коллекции в порядке убывания";
    }

    @Override
    public String getName() {
        return "print_descending";
    }
}

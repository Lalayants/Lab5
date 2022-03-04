package Commands;

import LabStuff.LabCollection;
import LabStuff.LabWork;

import java.util.ArrayList;

/**
 * Класс команды, выводящий количество уникальных значений полей минимальный балл
 */
public class PrintUniqueMinimalPoint implements Commandable {
    @Override
    public void execute(Object o) {
        ArrayList<Double> points = new ArrayList<>();
        for (LabWork elems : LabCollection.collection) {
            if (!points.contains(elems.getMinimalPoint()))
                points.add(elems.getMinimalPoint());
        }
        if (!points.isEmpty())
            System.out.println("Набор уникальных значений минимальных баллов: " + points);
        else
            System.out.println("Набор уникальных значений пуст, тк коллекция пуста");
    }

    @Override
    public String getDescription() {
        return ": вывести уникальные значения поля minimalPoint всех элементов в коллекции";
    }

    @Override
    public String getName() {
        return "print_unique_minimal_point";
    }
}

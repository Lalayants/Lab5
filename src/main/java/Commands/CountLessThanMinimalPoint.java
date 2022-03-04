package Commands;

import LabStuff.LabCollection;
import LabStuff.LabWork;

/**
 * Класс команды подсчета элементов, минимальный балл которых меньше заданного
 */
public class CountLessThanMinimalPoint implements Commandable{
    @Override
    public void execute(Object o) {
        try {
            int i = 0;
            int ref = Integer.parseInt((String) o);
            for (LabWork elems : LabCollection.collection) {
                if (elems.getMinimalPoint() < ref) {
                    i++;
                }
            }
            System.out.println("Таких " + i);
        } catch(NumberFormatException e){
            System.out.println("MinimalPoint должен быть целым числом");
        }
    }

    @Override
    public String getDescription() {
        return ": вывести количество элементов, значение поля minimalPoint которых меньше заданного";
    }

    @Override
    public String getName() {
        return "count_less_than_minimal_point";
    }
}

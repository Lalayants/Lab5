package Utilities;

import LabStuff.LabWork;

import java.util.Comparator;

/**
 * Класс для сравнения элементов коллекции
 */

public class LabComparator implements Comparator<LabWork>{
    @Override
    public int compare(LabWork a, LabWork b) {
        return a.getName().compareTo(b.getName());
    }

    @Override
    public Comparator<LabWork> reversed() {
        return Comparator.super.reversed();
    }
}

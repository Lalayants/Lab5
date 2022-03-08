package utilities;

import exceptions.ComaInsteadOfDotException;
import exceptions.IdBusyException;
import labStuff.*;

/**
 * Класс для создания элементов коллекции
 */

public class LabWorkCreator {
    //public static Scanner in = new Scanner(System.in);

    public static LabWork create() {
        LabWork labWork = new LabWork();
        labWork.setCreationDate();
        setId(labWork);
        setName(labWork);
        setMinimalPoint(labWork);
        setPersonalQualitiesMinimum(labWork);
        setCoordinates(labWork);
        setPerson(labWork);
        setDifficulty(labWork);

        return labWork;
    }
    public static LabWork create(int id) {
        LabWork labWork = new LabWork();
        labWork.setCreationDate();
        try {
            labWork.setId(id);
        } catch (IdBusyException e) {
            e.printStackTrace();
        }
        setName(labWork);
        setMinimalPoint(labWork);
        setPersonalQualitiesMinimum(labWork);
        setCoordinates(labWork);
        setPerson(labWork);
        setDifficulty(labWork);

        return labWork;
    }

    private static void setId(LabWork l) {
        try {
            l.setId(LabCollection.getFreeId());
        } catch (IdBusyException e) {
            e.printStackTrace();
        }
    }

    private static void setPersonalQualitiesMinimum(LabWork l) {
        System.out.print("Введите минимальный балл за личные качества:\n" + ">");
        try {
            String s = ConsoleIO.ConsoleIn();
            if (s.equals("") || s.equals("null")) {
                System.out.println("Не может быть null или \"\" ");
                setPersonalQualitiesMinimum(l);
            } else {
                int point = Integer.parseInt(s);
                if (point > 0) {
                    l.setPersonalQualitiesMinimum(point);
                } else {
                    System.out.println("Балл должен быть больше 0");
                    setPersonalQualitiesMinimum(l);
                }
            }
        } catch (NumberFormatException a) {
            System.out.println("Нужно ввести балл в формате целого числа");
            setPersonalQualitiesMinimum(l);
        }
    }

    public static void setMinimalPoint(LabWork l) {
        System.out.print("Введите минимальный балл :\n" + ">");
        try {
            String s = ConsoleIO.ConsoleIn();
            if (s.contains(",")) {
                throw new ComaInsteadOfDotException();
            } else if (s.equals("") || s.equals("null")) {
                System.out.println("Не может быть null или \"\" ");
                setMinimalPoint(l);
            } else {
                double point = Double.parseDouble(s);
                if (point > 0) {
                    l.setMinimalPoint(point);
                } else {
                    System.out.println("Масса должна быть больше 0");
                    setMinimalPoint(l);
                }
            }
        } catch (NumberFormatException a) {
            System.out.println("Нужно ввести массу в формате десятичной дроби разделенной точкой");
            setMinimalPoint(l);
        } catch (ComaInsteadOfDotException a) {
            setMinimalPoint(l);
        }
    }

    public static void setDifficulty(LabWork lab) {
        Difficulty[] difficulties = Difficulty.values();
        String s = "";
        for (Difficulty a : difficulties) {
            s += a.name() + ", ";
        }
        System.out.print("Оцените лабораторную работу одной из перечисленных сложностей(" + s + "):\n" + ">"); //Так аккуратнее или можно без плюса в одних ""?
        String name = ConsoleIO.ConsoleIn();
        try {
            if (name.equals("") || name.equals("null")) {
                System.out.println("Ошибка.Сложность не может быть null/пустой строкой");
                setDifficulty(lab);
            } else {
                lab.setDifficulty(Difficulty.valueOf(name.toUpperCase()));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Вы ошиблись, такой сложности нет");
            setDifficulty(lab);
        }

    }

    private static void setName(LabWork lab) {
        System.out.print("Введите имя лабораторной работы:\n" + ">"); //Так аккуратнее или можно без плюса в одних "?
        String name = ConsoleIO.ConsoleIn();
        if (name.equals("") || name.equals("null")) {
            System.out.println("Ошибка. Имя не может быть null/пустой строкой");
            setName(lab);
        } else {
            lab.setName(name);
        }
    }

    private static void setCoordinates(LabWork lab) {
        Coordinates coordinates = new Coordinates();
        coordinates.setX();
        coordinates.setY();
        lab.setCoordinates(coordinates);
    }

    private static void setPerson(LabWork lab) {
        Person p = new Person();
        p.setName();
        p.setWeight();
        p.setEyeColor();
        p.setBirthday();
        lab.setAuthor(p);
    }


}

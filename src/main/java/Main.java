import java.io.*;

import Commands.*;
import LabStuff.LabCollection;
import Utilities.ConsoleIO;
import Utilities.Decode;
import Utilities.FileReader;
import Utilities.FileWriter;


import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        Decode.fill(FileReader.readFromFile());
        Invoker inv = new Invoker();
        inv.register(new Add(), new Help(), new Info(), new Show(), new Clear(), new Exit(), new Save(), new UpdateId(),
                new RemoveById(), new RemoveFirst(), new AddIfMin(), new RemoveLower(), new CountLessThanMinimalPoint(),
                new PrintDescending(), new RemoveById(), new PrintUniqueMinimalPoint(), new ExecuteScript());
        //Scanner in = new Scanner(System.in);
//        while (true) {
//            Scanner in = new Scanner(System.in);
//            System.out.print("> ");
//            try {
//                String s = in.nextLine();
//                if (s != "")
//                    inv.execute(s);
//            } catch (NoSuchElementException e) {
//                //System.out.println("Такая комбинация завершает программу");
//                inv.execute("exit");
//
//            }

//
        System.out.println("Приложение готово к работе, введите команду, для справки введите help.");
        while (true) {
            System.out.print(">");
            inv.execute(ConsoleIO.ConsoleIn());
        }


    }
}

